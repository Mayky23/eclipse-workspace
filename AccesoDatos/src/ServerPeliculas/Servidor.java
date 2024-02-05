package ServerPeliculas;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Servidor {

    private ServerSocket servidor;
    private Socket cliente;
    private ObjectInputStream entrada;
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public Servidor() {
        try {
            servidor = new ServerSocket(27017);
            System.out.println("Servidor esperando conexiones...");
            mongoClient = new MongoClient("localhost", 27017);
            database = mongoClient.getDatabase("cine");
            collection = database.getCollection("peliculas");
            while (true) {
                cliente = servidor.accept();
                System.out.println("Cliente conectado desde " + cliente.getInetAddress().getHostName());
                manejarConexion(cliente);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void manejarConexion(Socket cliente) {
        try {
            entrada = new ObjectInputStream(cliente.getInputStream());
            Pelicula pelicula = (Pelicula) entrada.readObject();
            System.out.println("Pelicula recibida: " + pelicula);

            // Insertar o actualizar la película en MongoDB
            
            Document doc = new Document("nombre", pelicula.getNombre());
            Document found = collection.find(doc).first();
            if (found != null) {
                int votos = found.getInteger("votos") + 1;
                int notaTotal = found.getInteger("notaTotal") + pelicula.getNota();
                double notaMedia = (double) notaTotal / votos; // Casting para evitar división de enteros
                collection.updateOne(found, new Document("$set", new Document("notaMedia", notaMedia)
                        .append("votos", votos).append("notaTotal", notaTotal)));
            } else {
                collection.insertOne(new Document("nombre", pelicula.getNombre()).append("anio", pelicula.getAnio())
                        .append("duracion", pelicula.getDuracion()).append("notaMedia", pelicula.getNota())
                        .append("votos", 1).append("notaTotal", pelicula.getNota()));
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }
}

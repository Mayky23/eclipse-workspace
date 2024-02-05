package ServerPeliculas;

import java.io.*;
import java.net.*;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;

public class Servidor {

    private ServerSocket servidor;
    private Socket cliente;
    private ObjectInputStream entrada;
//    private MongoClient mongoClient;
//    private MongoDatabase database;
//    private MongoCollection<Document> collection;

    public Servidor() {
        try {
            servidor = new ServerSocket(1234);
            System.out.println("Servidor esperando conexiones...");
//            mongoClient = MongoClients.create("mongodb://localhost:27017");
//            database = mongoClient.getDatabase("test");
//            collection = database.getCollection("peliculas");
            while (true) {
                cliente = servidor.accept();
                System.out.println("Cliente conectado desde " + cliente.getInetAddress().getHostName());
                manejarConexion();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void manejarConexion() {
        try {
            entrada = new ObjectInputStream(cliente.getInputStream());
            Pelicula pelicula = (Pelicula) entrada.readObject();
            System.out.println("Pelicula recibida: " + pelicula);

            // Insertar o actualizar la película en MongoDB
//            Document doc = new Document("nombre", pelicula.getNombre());
//            Document found = collection.find(doc).first();
//            if (found != null) {
//                int votos = found.getInteger("votos") + 1;
//                int notaTotal = found.getInteger("notaTotal") + pelicula.getNota();
//                collection.updateOne(found, new Document("$set", new Document("notaMedia", notaTotal / votos)
//                        .append("votos", votos).append("notaTotal", notaTotal)));
//            } else {
//                collection.insertOne(new Document("nombre", pelicula.getNombre()).append("anio", pelicula.getAnio())
//                        .append("duracion", pelicula.getDuracion()).append("notaMedia", pelicula.getNota())
//                        .append("votos", 1).append("notaTotal", pelicula.getNota()));
//            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }
}

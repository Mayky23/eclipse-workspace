package ServerPeliculas;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;




public class Servidor {

    private final ServerSocket servidor;
    private final MongoCollection<Document> collection;

    public Servidor(MongoClient mongoClient, MongoDatabase database) throws IOException {
        servidor = new ServerSocket(27017);
        System.out.println("Servidor esperando conexiones...");
        this.collection = database.getCollection("peliculas");
        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado desde " + cliente.getInetAddress().getHostName());
            manejarConexion(cliente);
        }
    }

    private void manejarConexion(Socket cliente) {
        try (ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream())) {
            Pelicula pelicula = (Pelicula) entrada.readObject();
            System.out.println("Pelicula recibida: " + pelicula);

            // Insertar o actualizar la película en MongoDB
            Document doc = new Document("nombre", pelicula.getNombre());
            Document found = collection.find(doc).first();
            if (found != null) {
                int votos = found.getInteger("votos") + 1;
                int notaTotal = found.getInteger("notaTotal") + pelicula.getNota();
                double notaMedia = (double) notaTotal / votos;
                collection.updateOne(found, new Document("$set", new Document("notaMedia", notaMedia)
                        .append("votos", votos).append("notaTotal", notaTotal)));
            } else {
                Document nuevaPelicula = new Document("nombre", pelicula.getNombre())
                        .append("anio", pelicula.getAnio())
                        .append("duracion", pelicula.getDuracion())
                        .append("notaMedia", pelicula.getNota())
                        .append("votos", 1)
                        .append("notaTotal", pelicula.getNota());
                collection.insertOne(nuevaPelicula);
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

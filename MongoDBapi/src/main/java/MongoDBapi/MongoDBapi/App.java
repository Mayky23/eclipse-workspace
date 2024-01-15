package MongoDBapi.MongoDBapi;

import java.util.Iterator;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class App {
    public static void main(String[] args) {

        // Configura la conexión a MongoDB
        MongoClient mongo = new MongoClient("localhost", 27017);

        // Acceder a la base de datos
        MongoDatabase database = mongo.getDatabase("animales");

        for (String name : database.listCollectionNames()) {
            System.out.println(name);
        }

        // Crear colección
         database.createCollection("mamiferos");

        MongoCollection<Document> mamiferos = database.getCollection("mamiferos");

        // Generar el iterador para mostrar todos los datos de la base de datos
        Iterator<Document> it = mamiferos.find().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Crear una nueva colección
        database.createCollection("reptiles");

        MongoCollection<Document> reptiles = database.getCollection("reptiles");

        // Insertar datos en la colección
        Document document = new Document("nombre", "camaleón")
                .append("patas", 4)
                .append("bipedo", false);

        reptiles.insertOne(document);

        // Borrar datos de un documento
        mamiferos.deleteMany(Filters.eq("patas", 5));
        
        // Update de datos
        mamiferos.updateOne(Filters.eq("nombre", "gato"), Updates.set("patas",20));

        // Cerrar la conexión a MongoDB al finalizar
        mongo.close();
    }
}

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;public class ConexionBD2 {
    public static void main(String[] args){
        //Conexión a la base de datos en MongoDB
        MongoClient client = MongoClients.create("mongodb+srv://oluna1103:nrksTPMIOuY43LHR@clusterchatbot.iq5067f.mongodb.net/?retryWrites=true&w=majority"); //cambiar
        MongoDatabase database = client.getDatabase("chatbot"); //cambiar
        MongoCollection<Document> collection = database.getCollection("clientes"); //cambiar

        Document doc = new Document("nombre", "jasldkfjalskdf");
        collection.insertOne(doc);
        client.close();
    }
}

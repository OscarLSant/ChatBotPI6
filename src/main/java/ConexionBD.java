//en esta clase se hará la conexión con MongoDB para almacenar la info del cliente a Atlas

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
public class ConexionBD {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    /*public static void main(String[] args){
        //Conexión a la base de datos en MongoDB
        MongoClient client = MongoClients.create("mongodb+srv://oluna1103:nrksTPMIOuY43LHR@clusterchatbot.iq5067f.mongodb.net/?retryWrites=true&w=majority"); //cambiar
        MongoDatabase database = client.getDatabase("chatbot"); //cambiar
        MongoCollection<Document> collection = database.getCollection("clientes"); //cambiar

        Document doc = new Document("nombre", "Peter Pan");
        collection.insertOne(doc);
        client.close();
    }*/

    public void conectar(){
        client = MongoClients.create("mongodb+srv://oluna1103:nrksTPMIOuY43LHR@clusterchatbot.iq5067f.mongodb.net/?retryWrites=true&w=majority"); //cambiar
        database = client.getDatabase("chatbot"); //cambiar
        collection = database.getCollection("clientes"); //cambiar
    }
    public void insertar(ClienteBD c){
        Document doc = new Document("nombre", c);
        collection.insertOne(doc);
    }
    public void desconectar(){
        client.close();
    }
}

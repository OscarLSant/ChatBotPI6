import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.alicebot.ab.Chat;
import org.bson.Document;

import static com.mongodb.client.model.Filters.*;

///construct

public class ConexionConsultasBD {
    // ed modificacion private static ChatbotSocket chatbotSocket = new ChatbotSocket();
    MongoClient client;
    MongoDatabase database;
    MongoCollection<Document> collection;
    Document doc, query;
    ChatbotSocket socket;

    public ConexionConsultasBD(ChatbotSocket sock){
         socket = sock;
    }

    /* ed modificaciones public void salida() {
        chatbotSocket.getSalida();
    }*/

    public void conectar(){
        client = MongoClients.create("mongodb+srv://oluna1103:4LhDHtpTduRAnG83@clusterchatbot.iq5067f.mongodb.net/?retryWrites=true&w=majority"); //cambiar
        database = client.getDatabase("chatbot"); //cambiar
        collection = database.getCollection("consultas"); //cambiar
    }

    public void saludos(ClienteBD c){

        String saludo = c.getSaludo();
        if(saludo.contains("días")){
            query = new Document("saludo", new Document("$regex", ".*días.*"));
            doc = collection.find(query).first();
            if (doc != null) {
                String registroSaludo = doc.getString("saludo");
                socket.getSalida().println("MongoDBAtlas: " + registroSaludo);
            }
        }else if (saludo.contains("tardes")) {
            query = new Document("saludo", new Document("$regex", ".*tardes.*"));
            doc = collection.find(query).first();
            if (doc != null) {
                String registroSaludo = doc.getString("saludo");
                //System.out.println("MongoDBAtlas: " + registroSaludo);
                socket.getSalida().println("MongoDBAtlas: " + registroSaludo);
            }
        }else if (saludo.contains("noches")) {
            query = new Document("saludo", new Document("$regex", ".*noches.*"));
            doc = collection.find(query).first();
            if (doc != null) {
                String registroSaludo = doc.getString("saludo");
                //System.out.println("MongoDBAtlas: " + registroSaludo);
                socket.getSalida().println("MongoDBAtlas: " + registroSaludo);
            }
        }

    }

    public void ayuda(ClienteBD c){
        String ayuda = c.getAyuda();
        if(ayuda.contains("ayuda") || ayuda.contains("apoyo")){
            query = new Document("ayuda", new Document("$regex", ".*ayudarte.*"));
            doc = collection.find(query).first();
            if (doc != null) {
                String registroSaludo = doc.getString("ayuda");
                //System.out.println("MongoDBAtlas: " + registroSaludo);
                socket.getSalida().println("MongoDBAtlas: " + registroSaludo);
            }
        }
    }

    public void InfoChat(ClienteBD c){
        String info = c.getInfochatbot();
        if(info.contains("eres")){
            query = new Document("infochatbot", new Document("$regex", ".*ChatBot.*"));
            doc = collection.find(query).first();
            if (doc != null) {
                String infochat = doc.getString("infochatbot");
                //System.out.println("MongoDBAtlas: " + registroSaludo);
                socket.getSalida().println("MongoDBAtlas: " + infochat);
            }
        }
    }

    public void desconectar(){
        client.close();
    }
}

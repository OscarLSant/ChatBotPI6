import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatbotSocket extends Thread{

    private Socket socket; // se crea un atributo que almacena el socket de la conexión
    private ChatbotV2 chatbot; //se crea un atributo que almacena una instancia del chatbot

    //este constructor recibe un socket de conexión
    public ChatbotSocket(Socket socket){
        //asignación del atributo socket
        super("EchoMultiServerThread");
        this.socket = socket; //se asigna el soctek recibido al atributo socket
        chatbot = new ChatbotV2();// se crea una instancia de chatbot
    }

    //este método se ejecuta cuando se inicia el hilo
    public void run() {
        try (

                //se crean los flujos de entrada y salida para comunicarse con el cliente
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader entrada = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
        ){
            String lectura = entrada.readLine();//se lee la primera línea recibida desde el cliente
            while (lectura != null) {// mientras haya líneas por leer
                System.out.println(lectura);// se muestra en consola la línea recibida
                String escritura = chatbot.getResponse(lectura);// se procesa la línea con el chatbot
                System.out.println(escritura);// se muestra en consola la respuesta del chatbot
                salida.println(escritura);// se envía la respuesta del chatbot al cliente
                lectura = entrada.readLine();// se lee la siguiente línea del cliente
            }

        }catch (IOException e){
            System.out.println(e);
        }
    }
}
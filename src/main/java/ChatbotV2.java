import org.alicebot.ab.*;
import org.alicebot.ab.utils.IOUtils;

import java.io.File;

public class ChatbotV2 {
    private static final boolean TRACE_MODE = false; //se define una constante que indica el seguimiento
    static String botName = "super";// se define el nombre del chatbot

    //se crean las instancias del objeto Bot y Chat, que permiten la comunicación entre el usuario y el bot
    Bot bot;
    Chat chatSession;
    private ClienteBD clientebd;
    private ConexionBD conexionbd;

    //se crea el constructor, que inicializa el bot y la sesión de chat
    public ChatbotV2() {
        String resourcesPath = getResourcesPath();
        System.out.println(resourcesPath);
        MagicBooleans.trace_mode = TRACE_MODE;
        bot = new Bot("super", getResourcesPath());
        chatSession = new Chat(bot);
        bot.brain.nodeStats();
        clientebd = new ClienteBD();
        conexionbd = new ConexionBD();
    }

    //este método toma una línea de texto como entrada y devuelve la respuesta del bot en texto.
    public String getResponse(String textLine) {
            while (true) {
                String request = textLine;
                    if (MagicBooleans.trace_mode)
                        System.out.println(
                                "STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0)
                                        + ":TOPIC=" + chatSession.predicates.get("topic"));
                    String response = chatSession.multisentenceRespond(request);
                    while (response.contains("&lt;"))
                        response = response.replace("&lt;", "<");
                    while (response.contains("&gt;"))
                        response = response.replace("&gt;", ">");

                    clientebd.setMensaje(chatSession.predicates.get("mensaje"));
                    clientebd.setTelefono(chatSession.predicates.get("telefono"));
                    clientebd.setNombre(chatSession.predicates.get("nombre"));

                    conexionbd.conectar();
                    conexionbd.insertar(clientebd);
                    conexionbd.desconectar();


                    System.out.println(chatSession.predicates.get("mensaje"));
                    System.out.println(chatSession.predicates.get("telefono"));
                    System.out.println(chatSession.predicates.get("nombre"));

                    return response;
                }
            }
            // devuelve la ruta donde se encuentran los recursos del bot
    private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatbotCliente {
    public static void main(String[] args) {

        byte[] direccion = new byte[] {127, 0, 0, 1};       //es la dirección ip 52.43.121.77
        InetAddress ip = null;        //Variable InetAddress vacía que convierte el arreglo a ip

        try{
            ip = InetAddress.getByAddress(direccion);        //se le asigna la ip del arreglo a la variable addr
            Socket socket = new Socket(ip, 8887);      /*Se crea el objeto socket con un constructor de dos parámetros (variable que representa la dirección ip, y un número que representa el puerto)
                                                              Es la dirección a la que quiere enlazar el socket*/
            BufferedReader entradaSocket = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())                         //se envuelven caracteres de byte en buffered reader
            );

            PrintWriter salidaSocket = new PrintWriter(socket.getOutputStream(), true);                     //manipular el flujo de entrada, se hace referencia al flujo de salida del socket (argumento)

            String entrada = null;
            Scanner obj = new Scanner(System.in);

            do {
                System.out.println(entradaSocket.readLine());
                entrada = obj.nextLine();                           //se lee la entrada del servidor o socket
                //System.out.println(entrada);
                salidaSocket.println(entrada);                      //se imprime en el flujo de salidad del socket
            }while (entrada != null);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
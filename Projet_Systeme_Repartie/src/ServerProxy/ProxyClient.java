package ServerProxy;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/**
 * @author Rafiaa
 */
public class ProxyClient  {
    public static void main(String argv[]) throws Exception { 
        Socket socket = new Socket("127.0.0.1", 5000);
        
        //------------ envoie code client -----------------------------
        System.out.println("Donner le code client : " );
        Scanner xx = new Scanner(System.in); 
        int code_c = xx.nextInt();
        String code = String.valueOf(code_c);  
        
        PrintWriter send_client = new PrintWriter(socket.getOutputStream(), true);
        send_client.println(code);
        //------------ envoie num System -----------------------------
        System.out.println("Donner le num System : " );
        Scanner yy = new Scanner(System.in); 
        int Num = yy.nextInt();
        String NumSystem = String.valueOf(Num);
        PrintWriter send_system = new PrintWriter(socket.getOutputStream(), true);
        send_system.println(NumSystem);
        
         
        BufferedReader receive = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String client = receive.readLine();
        //------------ simple affichage -----------------------------
        System.out.println( client);
        socket.close();
        }
        
 }

    


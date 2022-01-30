package SI1;
import java.net.*;
import java.io.*;
/**
 * @author Rafiaa
 */
public class SI1_server { 
    public static void main(String argv[]) throws Exception 
    { //----------Creation socket
      DatagramSocket socket = new DatagramSocket(8532);
      
      while(true){
      System.out.println ("Serveur prêt.") ;
      System.out.println("Attente des invocations des clients ...");
      //----------reçevoir le code client
      byte[] receiveData = new byte[1024];
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      socket.receive(receivePacket);
      //----------reçevoir l'@ et le port 
      InetAddress IPAddress = receivePacket.getAddress();
      int port = receivePacket.getPort();
      String code = new String(receivePacket.getData());
        try{
            //----------connexion au  fichier text
            InputStream flux0=new FileInputStream("text.txt"); // une connexion à un fichier
            
            InputStreamReader lecture0=new InputStreamReader(flux0);
            BufferedReader buff0=new BufferedReader(lecture0);
            //----------rechercher de client dans le fichier text
            String ligne ;
            while ((ligne=buff0.readLine())!=null){
                String[] companies = ligne.split("\\s+");
                int x = Integer.parseInt(companies[0].trim());
                int y = Integer.parseInt(code.trim());
                if(x == y)
                    {
                    //-------envoyer le client            
                     byte[] sendData = new byte[1024];
                     sendData = ligne.getBytes();
                     DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                     socket.send(sendPacket);
                     break;
                    }
                } 
            // ---------- au cas client non trouver
            if(ligne==null){
                 byte[] sendData = new byte[1024];
                     sendData = "null null 0 ".getBytes();
                     DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                     socket.send(sendPacket);
                    }
            } catch (Exception e){ System.out.println(e.toString()); }
      } }} 
 



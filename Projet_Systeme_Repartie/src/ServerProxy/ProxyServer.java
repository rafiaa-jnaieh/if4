package ServerProxy;
import SI3.SI3_RMI_Server.service.TransportInterface;
import java.io.BufferedReader;
import java.io.*;
import java.net.*;
import java.rmi.registry.*;
/**
 * @author Rafiaa
 */
public class ProxyServer {
    public static void main(String argv[]) throws Exception {
        String resultat ;
        
        ServerSocket listener = new ServerSocket(5000) ;
        System.out.println ("Serveur prêt. \n  Attente des invocations des clients ...") ;
        Socket socket_proxy = listener.accept();
        //------------ reçoie code client -----------------------------
        BufferedReader receive_proxy_client = new BufferedReader(new InputStreamReader(socket_proxy.getInputStream()));
        String code = receive_proxy_client.readLine();
        System.out.println(code);
        //------------ reçoie num System -----------------------------
        BufferedReader receive_proxy_system = new BufferedReader(new InputStreamReader(socket_proxy.getInputStream()));
        String Num = receive_proxy_system.readLine();
        System.out.println(Num);
        
        int NumSystem = Integer.parseInt(Num);
        int code_c = Integer.parseInt(code);
        
        switch (NumSystem) {
            //--------------------------- System d'information 1 ---------------------------
            case 1 : 
            
                DatagramSocket socket_SI = new DatagramSocket();
                InetAddress IPAddress = InetAddress.getByName("localhost");
     
                // envoyer le code client
                byte[] sendData = new byte[1024];
                sendData = code.getBytes();
                DatagramPacket sentPacket = new DatagramPacket(sendData,sendData.length,IPAddress,8532); 
                socket_SI.send(sentPacket); 
                
      
      // reçevoir le code client
        byte[] receiveData = new byte[1024];
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      socket_SI.receive(receivePacket);
      
      
      // simple affichage
      String client = new String(receivePacket.getData());
      System.out.println(" LE CLIENT EST :" + client);
      
                //envoie code client
                PrintWriter sendI0 = new PrintWriter(socket_proxy.getOutputStream(), true);
                sendI0.println(client);
                socket_SI.close();     
                break;
                 //--------------------------- System d'information 2 ---------------------------
                case 2 : 
                    
                Socket socket_SII = new Socket("localhost", 9090);
                //envoie code client 
                PrintWriter send = new PrintWriter(socket_SII.getOutputStream(), true);
                send.println(code);
        
               
        
         //------------ reçoie code client -----------------------------
        BufferedReader receive = new BufferedReader(new InputStreamReader(socket_SII.getInputStream()));
        String client_SII = receive.readLine();
        
        //------------ simple affichage -----------------------------
        resultat = "LE CLIENT EST :" + client_SII ;
        System.out.println(resultat);
                
                
                //envoie code client 
                PrintWriter sendII = new PrintWriter(socket_proxy.getOutputStream(), true);
                sendII.println(resultat);
                break;
                //--------------------------- System d'information 3 ---------------------------
                case 3: 
                try {
                Registry reg = LocateRegistry.getRegistry("localhost",1099); 
                TransportInterface stub = (TransportInterface) reg.lookup("vehicule");
             
                String client0 = stub.getInformation(code_c);
                System.out.println("les coordonnées du client  : " + client0);
                //envoie code client 
                PrintWriter sendIII = new PrintWriter(socket_proxy.getOutputStream(), true);
                sendIII.println(client0);
                break;
                
              } catch (Exception e) { e.printStackTrace(); }
                
                
                default : 
                    //----------------------------------------------------------------------
//_____________________________________________________________________________________________________
//_____________________________________________________________________________________________________
                   try{
                       
                    DatagramSocket socket_SI0 = new DatagramSocket();
                    InetAddress MIPAddress = InetAddress.getByName("localhost");
                
                    // envoyer le code client
                    byte[] MsendData = new byte[1024];
                    sendData = code.getBytes();
                    DatagramPacket MsentPacket = new DatagramPacket(sendData,sendData.length,MIPAddress,8532); 
                    socket_SI0.send(MsentPacket); 
                    
                    // reçevoir le  client
        byte[] receiveData0 = new byte[1024];
      DatagramPacket receivePacket0 = new DatagramPacket(receiveData0, receiveData0.length);
      socket_SI0.receive(receivePacket0);
      
      
      // simple affichage
      String client0 = new String(receivePacket0.getData());
      System.out.println(client0);
      String[] companies1 = client0.split("\\s+");
      int montant = Integer.parseInt(companies1[2].trim());
      System.out.println(montant);
             socket_SI0.close();
//_____________________________________________________________________________________________________
//_____________________________________________________________________________________________________

                Socket socket_SII0 = new Socket("localhost", 9090);
                //envoie code client 
                PrintWriter send0 = new PrintWriter(socket_SII0.getOutputStream(), true);
                send0.println(code);
        
               
        
         //------------ reçoie  client -----------------------------
        BufferedReader receive0 = new BufferedReader(new InputStreamReader(socket_SII0.getInputStream()));
        String client_SII0 = receive0.readLine();
        System.out.println(client_SII0);
        String[] companies2 = client_SII0.split("\\s+");
        montant += Integer.parseInt(companies2[2].trim());
          System.out.println(montant);
socket_SII0.close();
//_____________________________________________________________________________________________________
//_____________________________________________________________________________________________________

                Registry reg = LocateRegistry.getRegistry("localhost",1099); 
                TransportInterface stub = (TransportInterface) reg.lookup("vehicule");
       
                String client3 = stub.getInformation(code_c);
                 System.out.println(client3);
                
                
                String[] companies3 = client3.split("\\s+");
                montant += Integer.parseInt(companies3[2].trim());
                
                
                
                
               
                String recette_g = "LA RECETTE GLOBALE EST  =  : " + montant;
                System.out.println(recette_g);
                
                //envoie montant
                PrintWriter send_recette = new PrintWriter(socket_proxy.getOutputStream(), true);
                send_recette.println(recette_g);
                break;
                } catch (Exception e) { e.printStackTrace(); } 
                   
                    
        }
      listener.close();
        
 }
    
}

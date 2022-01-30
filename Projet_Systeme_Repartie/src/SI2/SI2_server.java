package SI2;
import java.io.*;
import java.net.*;
import java.sql.*;
/**
 * @author Rafiaa
 */
public class SI2_server {  
 public static void main(String argv[]) throws Exception {
     
     ServerSocket listener = new ServerSocket(9090) ;
     while(true){
            System.out.println ("Serveur prêt . \n Attente des invocations des clients ...") ;
            //----------Creation socket
            Socket socket = listener.accept();
            // Reçoie code client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = in.readLine();
            int code  = Integer.parseInt(response);
            try {
            //--------------connection à la base 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/transport","root","");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select code_c , nom_c , montant  from vehicule1 ");
            while(result.next()){
                //----------rechercher de client 
                if ( result.getInt("code_c")== code){
                    String s=result.getInt("code_c")+ "   "+ result.getString("nom_c")+ "  "+ result.getInt("montant");
                    //-------envoyer le client  
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(s);
                     break;
                }
               
            } 
            // ---------- au cas client non trouver
            if(!result.next()){
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 out.println("null null 0");
            }
        } catch (Exception e) { e.printStackTrace();}
     }}}



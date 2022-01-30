package SI3.SI3_RMI_Server.service;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
/**
 * @author Rafiaa
 */
public class TransportImpl extends UnicastRemoteObject implements TransportInterface{
    public TransportImpl() throws RemoteException{
        super();   
    }
    @Override
    public String getInformation(int code ) throws RemoteException {
        String s = null;
        try {
             //-----------------connection à la base --------------------------------
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/transport","root","");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select code_c , nom_c , montant  from vehicule2 ");
            //----------rechercher de client 
            while(result.next()){
                if ( result.getInt("code_c")== code){
                    s=result.getInt("code_c")+ "  "+ result.getString("nom_c")+ "  "+ result.getInt("montant");
                    return s; 
                }   
            }
            // ---------- au cas client non trouver
            if(!result.next()){  return("null null 0"); } 
        } catch (Exception e) { e.printStackTrace();  }
      return s;
    } 
}
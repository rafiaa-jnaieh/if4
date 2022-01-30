import java.rmi.Naming;
import service.IBanqueRemote;

/**
 *
 * @author Rafiaa
 */
public class ClientRMI {
     public static void main(String[] args) {
         try {
             IBanqueRemote stub = (IBanqueRemote) Naming.lookup("rmi://localhost:1099/BK"); // connect à l'annuaire
             System.out.println(stub.conversion(70));
             System.out.println(stub.getServerDate());
         } catch (Exception e) {
             e.printStackTrace();
            
         } 
    }
    
}

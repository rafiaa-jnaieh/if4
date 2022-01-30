package SI3.SI3_RMI_Server.service;
import java.rmi.RemoteException;
import java.rmi.registry.*;
/**
 * @author Rafiaa
 */
public class TransportServer {
    public  static void main (String[] args) throws RemoteException{ 
       
       Registry registry = LocateRegistry.createRegistry(1099); 
       while(true){
       TransportImpl vehicule=new TransportImpl();
       registry.rebind("vehicule",vehicule); 
       System.out.println ("Serveur prêt. \n Attente des invocations des clients ...") ;
   
       }   
} 
    }


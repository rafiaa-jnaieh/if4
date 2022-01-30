
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Rafiaa
 */
public class HelloServer {
    public static void main(String[] args) {
try { 
       Registry registry = LocateRegistry.createRegistry(1099); 
       System.out.println( "Serveur : Construction de l'implementation");
       HelloImp hi=new HelloImp();
       registry.rebind ("HiRMI",hi);
       System.out.println("Objet Fabrique lie dans le RMIregistry");
    }
catch (Exception e) {
	             System.out.println("Erreur de liaison de l'objet Fabrique");
                     System.out.println(e.toString());
                     }
}
}

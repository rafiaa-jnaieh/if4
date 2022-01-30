
package service;
import java.rmi.registry.*;
/**
 *
 * @author Rafiaa
 */

public class CompteurServer {
public static void main(String[] args) {
try { 
       Registry registry = LocateRegistry.createRegistry(1099); 
       System.out.println( "Serveur : Construction de l'implementation");
       CompteurImpl cpt=new CompteurImpl();
       
       System.out.println("Objet Fabrique lie dans le RMIregistry");
       registry.rebind ("cpt",cpt);
       System.out.println ("Serveur prêt.") ;
       System.out.println("Attente des invocations des clients ...");
    }
catch (Exception e) {
	             System.out.println("Erreur de liaison de l'objet Fabrique");
                     System.out.println(e.toString());
                     }
} 
}
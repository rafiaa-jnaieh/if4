import java.rmi.registry.*;
import service.Compteur;
/**
 *
 * @author Rafiaa
 */


public class CompteurClient {
public static void main (String [] args) {
    try{
          Registry reg = LocateRegistry.getRegistry("localhost",1099); 
          Compteur cpt = (Compteur) reg.lookup("cpt");
          System.out.println("Compteur après incrémentation : " + cpt.incr());
          System.out.println("Compteur a la valeur : " + cpt.getValue());
          System.out.println("Compteur a été utilisé : " + cpt.getAccess());
     }    
     catch (Exception e) {
	  System.out.println ("Erreur d'acces a l'objet distant.");
	  System.out.println (e.toString());
          }
}
}
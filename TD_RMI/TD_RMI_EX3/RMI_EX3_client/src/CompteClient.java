
import java.rmi.*;
import java.rmi.registry.*;
import service.Compte;
/**
 *
 * @author Rafiaa
 */
public class CompteClient {

public static void main (String [] args) {
    try{
          Registry reg = LocateRegistry.getRegistry("localhost",1099); 
          Compte cpt = (Compte) reg.lookup("cpt");
          System.out.println("Solde après crédit de 100 dinars : " + cpt.crediter(100));
          System.out.println("Solde après retrait de 30 dinars : " + cpt.debiter(30));
		  
     }    
     catch (Exception e) {
	  System.out.println ("Erreur d'acces a l'objet distant.");
	  System.out.println (e.toString());
          }
}
}
 package rmi_ex1_client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.HelloInterface;

/**
 *
 * @author Rafiaa
 */
public class client {
    public static void main (String [] args) {  
    try{
          Registry reg = LocateRegistry.getRegistry("localhost",1099); 
          HelloInterface hi = (HelloInterface) reg.lookup("HiRMI");          
          System.out.println(hi.say());
     }    
     catch (Exception e) {
	  System.out.println ("Erreur d'acces a l'objet distant.");
	  System.out.println (e.toString());
          }
}
}

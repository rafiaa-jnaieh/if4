/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.rmi.registry.*;
/**
 *
 * @author Rafiaa
 */

public class ReverseServer {
public static void main(String[] args) {
try { 
       Registry registry = LocateRegistry.createRegistry(1099); 
       System.out.println( "Serveur : Construction de l'implementation");
       FabReverseImpl fab=new FabReverseImpl();
       System.out.println("Objet Fabrique lie dans le RMIregistry");
       registry.rebind ("Fabrique",fab);
       System.out.println ("Serveur prêt.") ;
       System.out.println("Attente des invocations des clients ...");
    }
catch (Exception e) {
	             System.out.println("Erreur de liaison de l'objet Fabrique");
                     System.out.println(e.toString());
                     }
} 
}

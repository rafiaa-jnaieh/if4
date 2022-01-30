/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicclient;

import java.lang.reflect.Constructor;
import java.rmi.*;
import java.rmi.server.RMIClassLoader;
import java.util.Properties;

/**
 *
 * @author Rafiaa
 */
public class DynamicClient {

   

public DynamicClient (String[] args) throws Exception {
Properties p = System.getProperties();
String url = p.getProperty("java.rmi.server.codebase");
Class ClasseClient = RMIClassLoader.loadClass(url, "ReverseClient");
// lancer le client
Constructor [] C = ClasseClient.getConstructors();
C[0].newInstance(new Object[]{args});
} // vérifier le passage de paramètres
public static void main (String [] args) {
System.setSecurityManager(new RMISecurityManager());
try{
DynamicClient cli = new DynamicClient(args);
}
catch (Exception e) {
System.out.println (e.toString());
}
}}
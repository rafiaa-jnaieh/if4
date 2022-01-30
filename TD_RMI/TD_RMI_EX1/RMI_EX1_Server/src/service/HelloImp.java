
package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author Rafiaa
 */
public class HelloImp extends UnicastRemoteObject implements HelloInterface {
     public HelloImp() throws RemoteException
       {
	    super();
       }
     @Override
     public String say() throws RemoteException {
         return "Hello World!";
    }
        
    
    
}

       
	

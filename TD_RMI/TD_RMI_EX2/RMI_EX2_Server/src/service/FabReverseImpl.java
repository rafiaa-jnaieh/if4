
package service;
import java.rmi.*;
import java.rmi.server.*;
/**
 *
 * @author Rafiaa
 */

public class FabReverseImpl extends UnicastRemoteObject implements FabReverseInterface{
   public FabReverseImpl()throws RemoteException {}; 
   @Override
   public ReverseInterface newReverse() throws RemoteException {       
   return new Reverse();}
}

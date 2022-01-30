package service;
import java.rmi.*;
import java.rmi.server.*;
/**
 *
 * @author Rafiaa
 */
public class CompteurImpl extends UnicastRemoteObject implements Compteur{
    private int val;
    private int nbocc;
    private final Object objLock;
     public CompteurImpl() throws RemoteException
       {
	    super();
		val=0;
                nbocc=0;
		objLock = new Object();
       }

    @Override
    public int incr() throws RemoteException {
        synchronized(objLock) 
        {
            nbocc++;
            return val++;
        }	
    }

    @Override
    public int getValue() throws RemoteException {
        synchronized(objLock) 
        {
		nbocc++;
		return val;
	}
    }
    @Override
    public int getAccess() throws RemoteException {
        return nbocc;
    } 
}

   

               


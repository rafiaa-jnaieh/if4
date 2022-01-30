package service;
import java.rmi.*;
import java.rmi.server.*;
/**
 *
 * @author Rafiaa
 */

public class CompteImpl extends UnicastRemoteObject implements Compte 
{
    private float solde;
    public CompteImpl() throws RemoteException
       {
	    super();
		solde=(float)0;
       }
    @Override
    public float crediter (float montant) throws RemoteException 
       {
           return solde+=montant;
       }
    @Override
    public float debiter (float montant) throws RemoteException 
        {
            return solde -= montant;
	}
    @Override
    public float infoSolde() throws RemoteException 
    {
        return solde;
    }
}

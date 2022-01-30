
package service;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Rafiaa
 */

public interface Compte extends Remote 
{
	public float crediter(float montant) throws RemoteException;
	public float debiter(float montant) throws RemoteException;
	public float infoSolde() throws RemoteException;
}


package SI3.SI3_RMI_Server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Rafiaa
 */
public interface TransportInterface extends Remote{
    
    public String getInformation(int code ) throws RemoteException;
   
}

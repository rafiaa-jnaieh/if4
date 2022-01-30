

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Rafiaa
 */
public interface HelloInterface extends Remote {
    public String say() throws RemoteException;
}

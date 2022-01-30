import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Rafiaa
 */
public class Reverse extends UnicastRemoteObject implements reverseInterface
{
public Reverse() throws RemoteException {
super();
}
    @Override
    public String ReverseString(String chaine) throws RemoteException {
        int longueur=chaine.length();
        StringBuffer temp=new StringBuffer(longueur);
        for (int i=longueur; i>0; i--)
        {
            temp.append(chaine.substring(i-1, i));
        }
       return temp.toString();
    }
}
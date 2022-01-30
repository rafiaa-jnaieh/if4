import java.rmi.Naming;

/**
 *
 * @author Rafiaa
 */
public class ReverseClient {
    public ReverseClient(String [] args){
        String mot ="Alice";
        try{
            reverseInterface rev = (reverseInterface) Naming.lookup("rmi://localhost:1099/MyReverse");
            String result = rev.ReverseString (args [0]);
System.out.println ("L'inverse de "+args[0]+" est "+result);
}
catch (Exception e)
{
System.out.println ("Erreur d'accès à l'objet distant.");
System.out.println (e.toString());
}
}
}

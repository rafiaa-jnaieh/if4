package examen_tp_tlc;
import java.util.Scanner;

/**
 
 * @author Rafiaa Jnaieh
 */
public class Tp_TLC {
    
    public static boolean etat(int e,int p,String mot){
		if(e==2 && mot.length()==p)
			return true;
		else if(p<mot.length()){
			switch (e) {
			case 0:
                            if((mot.charAt(p)=='a')){
					return etat(e+1, p+1, mot);
				}
				else 
                                    return  false;
				
			case 1 : 
                        {
                           
                            if((mot.charAt(p))=='b')
                                return   etat(e+1,p+1,mot);
                            else
                                return   false;
                        }
                
                        case  2:
                            if((mot.charAt(p))=='a')
                                return   etat(e-1,p+1,mot);
                           else
                                return   false;  
                        }
                }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("donner un mot : ");
        Scanner sr= new Scanner(System.in);
        String mot = sr.nextLine();
        System.out.println( etat(1,1,mot));

}
}
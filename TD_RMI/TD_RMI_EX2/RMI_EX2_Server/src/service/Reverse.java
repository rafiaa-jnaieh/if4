/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.rmi.*;
import java.rmi.server.*;
public class Reverse extends UnicastRemoteObject implements ReverseInterface 
/**
 *
 * @author Rafiaa
 */

{
       public Reverse() throws RemoteException
       {
	    super();
       }
       @Override
	 public String reverseString (String ChaineOrigine) throws RemoteException 
       {
	     int longueur=ChaineOrigine.length();
	     StringBuffer temp=new StringBuffer(longueur);
	     for (int i=longueur; i>0; i--) 
	     {
		temp.append(ChaineOrigine.substring(i-1, i));
	     }
	     return temp.toString();
       }
}
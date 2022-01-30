/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Rafiaa
 */


public interface ReverseInterface extends Remote 
{
	String reverseString(String chaine) throws RemoteException;
}

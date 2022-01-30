/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author Rafiaa
 */
public interface IBanqueRemote extends Remote {
    public double conversion (double mt) throws RemoteException ;
    public Date getServerDate () throws RemoteException ;
}

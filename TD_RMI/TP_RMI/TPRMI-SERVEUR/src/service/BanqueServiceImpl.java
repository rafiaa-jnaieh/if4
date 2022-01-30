/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 *
 * @author Rafiaa
 */
public class BanqueServiceImpl extends UnicastRemoteObject implements IBanqueRemote{
    
    protected  BanqueServiceImpl() throws RemoteException {
        super();
    }
    @Override
    public double conversion(double mt) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return 14*mt; 
    }

    @Override
    public Date getServerDate() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new Date();
    
    }
    
}

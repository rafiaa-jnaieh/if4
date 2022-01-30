
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafiaa
 */
public class ServeurRMI {
    public  static void main (String[] args){
        try {
            LocateRegistry.createRegistry(1099); // demarrer l'annuaire
            BanqueServiceImpl od = new BanqueServiceImpl();
            System.out.println(od.toString()); // afficher la reference d'obj distant / @ip et port 
                                                // ce quoi dans l'annuaire)
            Naming.rebind("rmi://localhost:1099/BK", od);
        } catch (Exception ex) {
            Logger.getLogger(ServeurRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

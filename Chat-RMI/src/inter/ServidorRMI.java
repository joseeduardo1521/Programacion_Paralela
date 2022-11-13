/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josee
 */
public class ServidorRMI {
        public static void main(String[] args) {
        // TODO code application logic here
        try{
            Registry rmi = LocateRegistry.createRegistry(1005);
            rmi.rebind("Chat", (Remote) new implementacionChat());
            System.out.println("Server Activo");
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}

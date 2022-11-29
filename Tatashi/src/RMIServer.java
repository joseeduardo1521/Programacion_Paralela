/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author josee
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMIServer {
        public static void main(String[] args) {
        try{
            Registry rmi = LocateRegistry.createRegistry(1005);
            rmi.rebind("RMIEncryptor", (Remote) new communicationImplementation());
            System.out.println("Cargando.....");
            System.out.println("Servidor Localizado..");
            
        } catch (RemoteException e) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

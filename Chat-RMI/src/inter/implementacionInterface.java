/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author josee
 */
public class implementacionInterface extends UnicastRemoteObject implements interfaceRMI{

    public implementacionInterface() throws RemoteException{
        super();
    }
    
    @Override
    public String nombre(String nombre) throws RemoteException {
        return nombre;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

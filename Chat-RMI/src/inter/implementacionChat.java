/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author josee
 */
public class implementacionChat extends UnicastRemoteObject implements chatServidor{
    public ArrayList<chatCliente>clientes;
    
    public implementacionChat() throws RemoteException{
        clientes = new ArrayList<chatCliente>();
    }
    
    
    @Override
    public void registro(chatCliente cliente) {
    this.clientes.add(cliente);

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mensaje(String mensaje) throws RemoteException {
        int a=0;
        while(a<clientes.size()){
            clientes.get(a++).mensajeCliente(mensaje);
        }
        }
    
}

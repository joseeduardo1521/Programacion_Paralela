/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author josee
 */
interface chatServidor extends Remote{
    void registro(chatCliente cliente) throws RemoteException;
    void mensaje(String mensaje) throws RemoteException;
}

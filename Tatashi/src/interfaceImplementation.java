/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josee
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class interfaceImplementation extends UnicastRemoteObject implements interfaceRMI {

    public interfaceImplementation() throws RemoteException {
        super();
    }
    
    @Override
    public String user(String user) throws RemoteException {
        return user;
    }
}

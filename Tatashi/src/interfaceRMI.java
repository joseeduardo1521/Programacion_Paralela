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

public interface interfaceRMI extends Remote {
    String user(String user)throws RemoteException;
}


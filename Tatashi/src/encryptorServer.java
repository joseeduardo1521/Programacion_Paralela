/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author josee
 */
interface encryptorServer extends Remote{
    void session(encryptorClient client, String user) throws RemoteException;
    void data(String data) throws RemoteException;
    int addition() throws RemoteException;
    int subtraction() throws RemoteException;
    int multiplication() throws RemoteException;
    int division() throws RemoteException;
    String mergeStrings() throws RemoteException;
}

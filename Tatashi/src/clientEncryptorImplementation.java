/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author josee
 */
public class clientEncryptorImplementation extends UnicastRemoteObject implements encryptorClient, Runnable {

    encryptorServer encryptorServer;
    public String user, data;

    clientEncryptorImplementation(String user, encryptorServer encryptorServer, String data1) throws RemoteException {
        this.user = user;
        this.encryptorServer = encryptorServer;
        this.data = data1;
        encryptorServer.session(this, user);
    }

    @Override
    public void clientMessage(String data) throws RemoteException {
        System.out.println(data);
    }

    @Override
    public void run() {
        try {
            encryptorServer.data("----------\n" + "User: " + user + " -> " + data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getData() throws RemoteException {
        return data;
    }
}

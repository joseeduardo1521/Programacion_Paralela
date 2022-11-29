/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author josee
 */

public class communicationImplementation extends UnicastRemoteObject implements encryptorServer {

    public ArrayList<encryptorClient> usersArray;
    public ArrayList users = new ArrayList();
    

    public communicationImplementation() throws RemoteException {
        usersArray = new ArrayList<encryptorClient>();
    }

    @Override
    public void session(encryptorClient client, String user) {
        if (users.size() == 0) {
            this.usersArray.add(client);
            users.add(user);
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (!users.contains(user)) {
                    this.usersArray.add(client);
                    users.add(user);
                }
            }
        }
    }

    @Override
    public void data(String data) throws RemoteException {
        int a = 0;
        while (a < usersArray.size()) {
            usersArray.get(a++).clientMessage(data);
        }
    }

    @Override
    public int addition() throws RemoteException {
        int num1 = Integer.parseInt(usersArray.get(0).getData());
        int num2 = Integer.parseInt(usersArray.get(1).getData());
        return num1 + num2;
    }

    @Override
    public int subtraction() throws RemoteException {
        int num1 = Integer.parseInt(usersArray.get(0).getData());
        int num2 = Integer.parseInt(usersArray.get(1).getData());
        return num1 - num2;
    }

    @Override
    public int multiplication() throws RemoteException {
        int num1 = Integer.parseInt(usersArray.get(0).getData());
        int num2 = Integer.parseInt(usersArray.get(1).getData());
        return num1 * num2;
    }

    @Override
    public int division() throws RemoteException {
        int num1 = Integer.parseInt(usersArray.get(0).getData());
        int num2 = Integer.parseInt(usersArray.get(1).getData());
        return num1 / num2;
    }

    @Override
    public String mergeStrings() throws RemoteException {
        String str1 = usersArray.get(0).getData();
        String str2 = usersArray.get(1).getData();
        return str1 + str2;
    }

}

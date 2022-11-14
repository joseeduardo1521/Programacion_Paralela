package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceCalculadora extends Remote {
    void agregarNumero(int numero) throws RemoteException;
    void agregarNumm(int numero) throws RemoteException;
    void agregarOperacion(int operacion) throws RemoteException;
    void agregarOperacion2(int operacionc) throws RemoteException;
    void realizarOperacion() throws RemoteException;
    void realizarOperacion2() throws RemoteException;
    void clean() throws RemoteException;
    void limpiar() throws RemoteException;
    String recuperarDatos() throws RemoteException;
    String recp() throws RemoteException;
    //void envi() throws RemoteException;
}

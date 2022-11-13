/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author josee
 */
public class implementacionClienteChat extends UnicastRemoteObject implements chatCliente, Runnable{
    chatServidor servidor;
    public String nombre=null;
    implementacionClienteChat(String nombre, chatServidor servidor) throws RemoteException{
        this.nombre = nombre;
        this.servidor = servidor;
        servidor.registro(this);
    }
    
    @Override
    public void mensajeCliente(String mensaje) throws RemoteException {
        System.err.println(mensaje);
         }

    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        String mensaje;
        
        while(true){
            mensaje=s.nextLine();
            try{
                servidor.mensaje(nombre+" : "+ mensaje);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import com.sun.istack.internal.logging.Logger;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;



/**
 *
 * @author josee
 */
public class ServidorMultiParlante implements Runnable{
    
    static final int PUERTO = 8080;
    public static void main(String[] args) throws IOException{
        ServerSocket ss;
        System.out.print("Inicializando servidor....");
        try{
            ss=new ServerSocket(PUERTO);
            System.out.println("\t[OK]");
            int idSession = 0;
            while (true){
                Socket socket;
                socket = ss.accept();
                System.out.println("Nueva conexión entrante: "+socket);
                ((ServidorMultiParlante) new ServidorMultiParlante (socket,idSession)).start();
                idSession++;
            }
        }catch(IOException ex){
           //Logger.getLogger(ServidorUnParlante.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private int idSessio;
    
    
    
    public ServidorMultiParlante(Socket socket, int id){
        this.socket = socket;
        this.idSessio = id;
        try{
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        }catch(IOException ex){
            //Logger.getLogger(ServidorMultiParlante.class.getName()).log(Level.SEVERE, null, ex);
            //Logger.getLogger(ServidorMultiParlante.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void desconnectar(){
        try{
          socket.close();
        }catch(IOException ex){
            
        }

    }
//El método run se hace bien pendejo por culpa del .start(); allá arriba por lo que la wea que esta adentro se la pasas
    //al método start y ya jala 
    @Override
    public void run() {
        String accion = "";
        try{
            accion = dis.readUTF();
            if(accion.equals("hola"));
            System.out.println("El cliente con idSesion "+this.idSessio+" Saluda");
            dos.writeUTF("adios");
        }catch(IOException ex){
           //Logger.getLogger(ServidorMultiParlante.class.getName().log(Level.SEVERE), null, ex);
        }
        desconnectar();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void start() {
       //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String accion = "";
        try{
            accion = dis.readUTF();
            if(accion.equals("hola"));
            System.out.println("El cliente con idSesion "+this.idSessio+" Saluda");
            dos.writeUTF("adios");
        }catch(IOException ex){
           //Logger.getLogger(ServidorMultiParlante.class.getName().log(Level.SEVERE), null, ex);
        }
        desconnectar();
    }

    
}

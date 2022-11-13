/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author josee
 */
public class HiloClienteParlante implements Runnable {
    static final int MAX_HILOS = 10;
    public static final String HOST = "192.168.0.111";
    
    public static void main(String[] args) throws IOException, InterruptedException{
        ArrayList<Thread> clients = new ArrayList<Thread>();
        for (int i=0; i<5; i++){ 
           clients.add(new Thread(new HiloClienteParlante(i))); 
        }
        for (Thread thread : clients){
            thread.start();
        }
     


   }
        private Socket sk;
        private DataOutputStream dos;
        private DataInputStream dis;
        private int id;
        
        
        public HiloClienteParlante(int id){
            this.id = id;
            
        }

    @Override
    public void run() {
        try{
            sk=new Socket("127.0.0.1",8080);
            dos=new DataOutputStream(sk.getOutputStream());
            dis=new DataInputStream(sk.getInputStream());
            System.out.println(id+ " envia saludo");
            dos.writeUTF("hola");
            String respuesta="";
            respuesta = dis.readUTF();
            System.out.println(id+ " devuelve saludo:"+respuesta);
            dis.close();
            dos.close();
            sk.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloClienteParlante.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
        
        
        
}
    


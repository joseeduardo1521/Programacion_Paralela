/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author josee
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends JFrame {
    encryptorServer server;
    clientEncryptorImplementation clientEncryptorImplementation;
    JLabel userLbl, nanoSecTime, nanoForkTime, sexotime;
    String userName;
    long calltime;
    public static AlgoSHA256 algoSHA256;
    public static JTextField initialString;
    //public static JTextField texto1,texto2,texto3;
    JLabel infoT=new JLabel("Texto Combinado Desencriptado");
    JLabel infosex= new JLabel("Texto combinado Encriptado");
    JLabel infoadd=new JLabel ("Texto ingresado");
    public static JTextField cryptoString;
    JTextArea areaTexto = new JTextArea();
    JTextArea comboplus = new JTextArea();
    public static TextArea encryptedStr;
    JTextArea areaCrip = new JTextArea();
    String secret_key = "CLIENT_SECRET";
    Random rand = new Random();
    float r = (float) (rand.nextFloat() / 2f + 0.5);
    float g = (float) (rand.nextFloat() / 2f + 0.5);
    float b = (float) (rand.nextFloat() / 2f + 0.5);

    public Cliente() throws RemoteException, NotBoundException {

        setTitle("NULL");
        setLayout(null);
        setSize(1500,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(237, 242, 244));

        userName = JOptionPane.showInputDialog("Usuario:");

        initialString = new JTextField(10);
        initialString.setBounds(20, 20, 300, 35);
        this.add(initialString);

        Button submitBtn = new Button("Enviar al servidor");
//        submitBtn.setOpaque(true);
//        submitBtn.setBorderPainted(false);
        submitBtn.setBounds(350, 20, 120, 35);
 
        //submitBtn.setFont(new Font("Arial", Font.BOLD, 15));

        userLbl = new JLabel();
        userLbl.setBounds(20,700,210,30);
        userLbl.setFont(new Font("Arial", Font.ITALIC, 15));
        this.add(userLbl);

        Button secubtn = new Button();
        secubtn.setLabel("Secuencial");
        secubtn.setBounds(150, 50, 75, 30);
        secubtn.setBounds(20, 120, 105, 40);
        secubtn.setForeground(Color.black);
        secubtn.setFocusable(false);
        //secubtn.setBackground(new Color(177, 220, 230));
        this.add(secubtn);

        nanoSecTime = new JLabel();
        nanoSecTime.setBounds(100, 420, 200, 50);
        nanoSecTime.setVisible(true);
        nanoSecTime.setForeground(Color.black);
        this.add(nanoSecTime);

        Button secuttorButton = new Button();
        secuttorButton.setLabel("Fork/Join");
        secuttorButton.setBounds(20, 190, 105, 40);
        secuttorButton.setForeground(Color.black);
        secuttorButton.setFocusable(false);
        //secuttorButton.setBackground(new Color(177, 220, 230));
        this.add(secuttorButton);

        sexotime = new JLabel();
        sexotime.setBounds(100, 440, 210, 50);
        sexotime.setForeground(Color.black);
        this.add(sexotime);
        Button desc = new Button();
        desc.setLabel("Descifrar");
        desc.setBounds(20, 315, 105, 40);
        this.add(desc);
        
        
        Button Forkybtn = new Button();
        Forkybtn.setLabel("Executor");
        Forkybtn.setBounds(50, 50, 75, 30);
        Forkybtn.setBounds(20, 260, 105, 40);
        Forkybtn.setForeground(Color.black);
        Forkybtn.setFocusable(false);
        //Forkybtn.setBackground(new Color(142, 236, 245));
        this.add(Forkybtn);

        nanoForkTime = new JLabel();
        nanoForkTime.setBounds(100, 460, 210, 50);
        nanoForkTime.setForeground(Color.black);
        this.add(nanoForkTime);
        
        infoT.setBounds(1050,60, 200,30);
        this.add(infoT);
        infosex.setBounds(450, 420, 200, 30);
        this.add(infosex);
        infoadd.setBounds(450,60,200,30);
        this.add(infoadd);
        
        encryptedStr = new TextArea();
        encryptedStr.setBounds(20,330, 650, 300);
        //this.add(encryptedStr);
        
//        areaCrip = new TextArea();
        //areaCrip.setBounds(700, 330, 650, 300);
        //this.add(areaCrip);
         JPanel panel = new JPanel();
            this.getContentPane().add(panel);
            areaTexto.setBounds(450,90,500,300);
            areaTexto.setLineWrap(true);
            JScrollPane scroll = new JScrollPane(areaTexto,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scroll.setBounds(450,90,500,300);
             add(scroll);
          areaCrip.setBounds(450, 450, 500, 300);
        add(areaCrip);
        areaCrip.setLineWrap(true);
        JScrollPane scrupy = new JScrollPane(areaCrip,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrupy.setBounds(450, 450, 500, 300);
        add(scrupy);
        comboplus.setBounds(1050,90, 350, 300);
        comboplus.setLineWrap(true);
        JScrollPane css = new JScrollPane(comboplus,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        css.setBounds(1050,90,350,300);
        add(css);
        
        Registry RMIRegistry = LocateRegistry.getRegistry("192.168.0.113", 1005);
       
        server = (encryptorServer) RMIRegistry.lookup("RMIEncryptor");
        clientEncryptorImplementation = new clientEncryptorImplementation(userName, server, "");
        userLbl.setText("Usuario: " + userName);
        new Thread(clientEncryptorImplementation).start();

        algoSHA256 = new AlgoSHA256();

        secuttorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String finalResult = server.mergeStrings();
                    System.out.println("Executor Resultado: ");
                    long initTime = System.nanoTime();
                    String results = managerFunct(initialString.getText());
                    long finalTime = System.nanoTime();
                    //cryptoString.setText(results);
                    
                    //result.setText(results);
                    System.out.println("Resultado final: " + finalResult);
                    //encryptedStr.setText(results);
                    areaCrip.setText(results);
                    System.out.println(String.valueOf(finalTime - initTime) + "(ns)");
                    sexotime.setText("Fork/Join: "+String.valueOf((finalTime - initTime)) + "(ns)");
                } catch (RemoteException ex){
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        desc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                        try{
                    String finalResult = server.mergeStrings();
                    comboplus.setText(finalResult);
                } catch (RemoteException ex){
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
        secubtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String finalResult = server.mergeStrings();
                    System.out.println("Resultado Secuencial: ");
                    System.out.println(finalResult);
                    long initTime = System.nanoTime();
                    String results = managerFunct(initialString.getText());
                    secuentialTiming(initialString.getText());
                    long finalTime = System.nanoTime();
                    //result.setText(results);
                    System.out.println("Resultado final:  " + finalResult);
                    //encryptedStr.setText(results);
                    areaCrip.setText(results);
                    System.out.println(String.valueOf(finalTime - initTime) + "(ns)");
                    nanoSecTime.setText("Secuencial: "+String.valueOf(finalTime - initTime) + "(ns)");
                } catch (RemoteException ex){
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        ForkJoin forkJoin = new ForkJoin(initialString.getText());
        Forkybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String finalResult = server.mergeStrings();
                    System.out.println("Resultado Fork/Join: ");
                    System.out.println("Resultado final: " + finalResult);
                    long initTime = System.nanoTime();
                    ForkJoinPool forkJoinObj = new ForkJoinPool();
                    String results = forkJoinObj.invoke(new ForkJoin(initialString.getText()));
                    long finalTime = System.nanoTime();
                    calltime=(long)(finalTime-initTime);
                    double seccun = (double) calltime / 2;
                    nanoForkTime.setText("Executor: "+String.valueOf((calltime)) + "(ns)");
                    //cryptoString.setText(results);
                    //result.setText(results);
                    encryptedStr.setText(results);
                    areaCrip.setText(results);
                    //comboplus.setText(finalResult);
                    System.out.println(String.valueOf(finalTime - initTime) + "(ns)");
                } catch (RemoteException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    clientEncryptorImplementation.data = initialString.getText();
                    //areaCrip.setText(initialString.getText());
                    areaTexto.setText(initialString.getText());
                    clientEncryptorImplementation.run();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        this.add(submitBtn);
        setVisible(true);
    }

    public void secuentialTiming(String arr) {
        algoSHA256 = new AlgoSHA256();
        String cypherString1 = algoSHA256.encriptionFunc(secret_key,arr);
        //cryptoString.setText(cypherString1);
    }


    public String managerFunct(String a) {
        if (a.length() <= 1)
            return a;
        String firstHalf = a.substring(0, a.length() / 2);
        String secondHalf = a.substring((a.length() / 2), a.length());
        final ExecutorService executorService = Executors.newFixedThreadPool(2);

        Collection<Callable<String>> callables = new ArrayList<>();
        callables.add(() -> algoSHA256.encriptionFunc(secret_key,firstHalf));
        callables.add(() -> algoSHA256.encriptionFunc(secret_key,secondHalf));
        String product = "";
        try {
            List<Future<String>> finalResult = executorService.invokeAll(callables);
            for (Future<String> expectedResult : finalResult) {
                try {
                    product = product+expectedResult.get();
                } catch (ExecutionException executionException) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, executionException);
                }
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        executorService.shutdownNow();
        return product;
    }

    public void orderAlgo() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new ForkJoin(initialString.getText()));
    }

    public String mergeSortOrdering(String array) {
        if (array.length() <= 1)
            return array;
        AlgoSHA256 algoSHA256 = new AlgoSHA256();
        String firstHalf = array.substring(0, array.length() / 2);
        String secondHalf = array.substring((array.length() / 2), array.length());
        mergeSortOrdering(firstHalf);
        mergeSortOrdering(secondHalf);
        algoSHA256.encriptionFunc(secret_key, array);
        return array;
    }
    private class ForkJoin extends RecursiveTask<String> {
        private final String arrayList;
        public ForkJoin(String arrayList) {
            this.arrayList = arrayList;
        }
        @Override
        protected String compute() {
            if (arrayList.length() <= 1) {
                return "";
            }
            if (arrayList.length() > 10000) {
                int center = arrayList.length() / 2;
                ForkJoin firstTask = new ForkJoin(arrayList.substring(0, center));
                ForkJoin secondTask = new ForkJoin(arrayList.substring(center));
                secondTask.fork();
                return firstTask.compute() + secondTask.join();
            } else{
                return algoSHA256.encriptionFunc(secret_key, arrayList);
            }
        }
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        new Cliente();
    }
}

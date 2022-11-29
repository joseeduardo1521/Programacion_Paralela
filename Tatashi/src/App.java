/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josee
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends JFrame {

    public static JTextField initialString;
    public static JTextField cryptoString;
    public static AlgoSHA256 algoSHA256;
    String secret_key = "CLIENT_SECRET";

    public static void main(String[] args) {
        new App();
    }

    public App() {
        setTitle("SHA-256 Multi-Thread Encoder");
        setLayout(null);
        setSize(1020, 500);
        getContentPane().setBackground(new Color(177, 220, 230));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JLabel initStringLbl = new JLabel("Initial String:");
        initStringLbl.setBounds(50, 115, 200, 30);
        initStringLbl.setForeground(Color.black);
        this.add(initStringLbl);

        initialString = new JTextField();
        initialString.setBounds(50, 150, 300, 30);
        initialString.setForeground(Color.BLACK);
        initialString.setBorder(null);
        this.add(initialString);

        JLabel encryptedTxtLbl = new JLabel("Encrypted String:");
        encryptedTxtLbl.setBounds(400, 115, 300, 30);
        encryptedTxtLbl.setForeground(Color.black);
        this.add(encryptedTxtLbl);

        cryptoString = new JTextField();
        cryptoString.setBounds(400, 150, 300, 30);
        cryptoString.setForeground(Color.black);
        cryptoString.setBorder(null);
        this.add(cryptoString);

        int proportionalYFactor = 100;
        JLabel totalTimeFork = new JLabel("ForkJoin results:");
        totalTimeFork.setBounds(50, 350-proportionalYFactor, 200, 30);
        totalTimeFork.setForeground(Color.black);
        this.add(totalTimeFork);

        JLabel nanoForkTime = new JLabel();
        nanoForkTime.setBounds(250, 350-proportionalYFactor, 200, 30);
        nanoForkTime.setForeground(Color.black);
        this.add(nanoForkTime);

        JLabel totalTimeSecuential = new JLabel("Secuential results:");
        totalTimeSecuential.setBounds(50, 300-proportionalYFactor, 200, 30);
        totalTimeSecuential.setForeground(Color.black);
        this.add(totalTimeSecuential);

        JLabel nanoSecTime = new JLabel();
        nanoSecTime.setBounds(250, 300-proportionalYFactor, 200, 30);
        nanoSecTime.setForeground(Color.black);
        this.add(nanoSecTime);

        JLabel totalTimeExecutorService = new JLabel("Executor Service results:");
        totalTimeExecutorService.setBounds(50, 400-proportionalYFactor, 200, 30);
        totalTimeExecutorService.setForeground(Color.black);
        this.add(totalTimeExecutorService);

        JLabel nanoExecutorServiceTime = new JLabel();
        nanoExecutorServiceTime.setBounds(250, 400-proportionalYFactor, 200, 30);
        nanoExecutorServiceTime.setForeground(Color.black);
        this.add(nanoExecutorServiceTime);

        Button forkJoinBtn = new Button();
        forkJoinBtn.setLabel("Run ForkJoin");
        forkJoinBtn.setBounds(50, 50, 150, 40);
        forkJoinBtn.setBounds(250, 50, 150, 40);
        forkJoinBtn.setForeground(Color.black);
        forkJoinBtn.setFocusable(false);
        forkJoinBtn.setBackground(new Color(177, 220, 230));
        this.add(forkJoinBtn);

        Button secuentialBtn = new Button();
        secuentialBtn.setLabel("Run Secuential");
        secuentialBtn.setBounds(250, 50, 150, 40);
        secuentialBtn.setBounds(50, 50, 150, 40);
        secuentialBtn.setForeground(Color.black);
        secuentialBtn.setFocusable(false);
        secuentialBtn.setBackground(new Color(177, 220, 230));
        this.add(secuentialBtn);

        Button executorServiceBtn = new Button();
        executorServiceBtn.setLabel("Run Executor Service");
        executorServiceBtn.setBounds(450, 50, 150, 40);
        executorServiceBtn.setForeground(Color.black);
        executorServiceBtn.setFocusable(false);
        executorServiceBtn.setBackground(new Color(177, 220, 230));
        this.add(executorServiceBtn);

        algoSHA256 = new AlgoSHA256();

        executorServiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long initTime = System.nanoTime();
                String results = managerFunct(initialString.getText());
                long finalTime = System.nanoTime();
                nanoExecutorServiceTime.setText(String.valueOf(finalTime - initTime) + "(ns)");
                cryptoString.setText(results);
            }
        });
        secuentialBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long initTime = System.nanoTime();
                secuentialTiming(initialString.getText());
                long finalTime = System.nanoTime();
                nanoSecTime.setText(String.valueOf(finalTime - initTime) + "(ns)");
            }
        });

        ForkJoin forkJoin = new ForkJoin(initialString.getText());
        forkJoinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long initTime = System.nanoTime();
                ForkJoinPool forkJoinObj = new ForkJoinPool();
                String results = forkJoinObj.invoke(new ForkJoin(initialString.getText()));
                long finalTime = System.nanoTime();
                nanoForkTime.setText(String.valueOf(finalTime - initTime) + "(ns)");
                cryptoString.setText(results);
                System.out.println("results: " + results);
            }
        }
        );
    }

    public void secuentialTiming(String arr) {
        algoSHA256 = new AlgoSHA256();
        String cypherString1 = algoSHA256.encriptionFunc(secret_key,arr);
        cryptoString.setText(cypherString1);
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
}
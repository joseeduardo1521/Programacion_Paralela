/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;

import servidor.InterfaceCalculadora;

public class Principal extends JFrame {
    
    public Principal() {
        
    }

    public static void main(String[] args) {
        int puerto = 1111;
        System.out.println("Estableciendo conexión...");

        try {

            // Se realiza la conexión
            Registry registro = LocateRegistry.getRegistry("localhost", puerto);
            InterfaceCalculadora conexion = (InterfaceCalculadora) registro.lookup("calculadora");

            // Se carga la interfaz gráfica
            Principal principal = new Principal();

            /* Layouts */
            BorderLayout layoutContenedor = new BorderLayout();
            GridLayout layoutBotones = new GridLayout(4, 4);

            principal.setLayout(layoutContenedor);
            
            /* Contenedores */
            JPanel panelVentana = new JPanel();
            JPanel panelBotones = new JPanel(layoutBotones);

            /* Elementos */

            // Ventana de operaciones
            JLabel ventana = new JLabel("Hola");
            ventana.setFont(new Font("Arial", 0, 25));
            ventana.setVisible(true);
            panelVentana.add(ventana);

            // Botones númericos
            JButton boton1 = new JButton("1");
            boton1.addActionListener((ActionEvent ae) -> {
                try {
                    conexion.agregarNumm(1);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            boton1.setVisible(true);

            JButton boton2 = new JButton("2");
            boton2.addActionListener((ActionEvent ae) -> {
                try {
                    conexion.agregarNumm(2);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            boton2.setVisible(true);
            
            JButton boton3 = new JButton("3");
            boton3.addActionListener((ActionEvent ae) -> {
                try {
                    conexion.agregarNumm(3);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            boton3.setVisible(true);

            JButton boton4 = new JButton("4");
            boton4.addActionListener((ActionEvent ae) -> {
                try {
                     conexion.agregarNumm(4);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            boton4.setVisible(true);

            JButton boton5 = new JButton("5");
            boton5.addActionListener((ActionEvent ae) -> {
                try {
                     conexion.agregarNumm(5);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            boton5.setVisible(true);

            JButton boton6 = new JButton("6");
            boton6.addActionListener((ActionEvent ae) -> {
                try {
                     conexion.agregarNumm(6);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            boton6.setVisible(true);

            JButton boton7 = new JButton("7");
            boton7.addActionListener((ActionEvent ae) -> {
                try {
                     conexion.agregarNumm(7);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            boton7.setVisible(true);

            JButton boton8 = new JButton("8");
            boton8.addActionListener((ActionEvent ae) -> {
                try {
                     conexion.agregarNumm(8);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            boton8.setVisible(true);

            JButton boton9 = new JButton("9");
            boton9.addActionListener((ActionEvent ae) -> {
                try {
                     conexion.agregarNumm(9);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            boton9.setVisible(true);

            JButton boton0 = new JButton("0");
            boton0.addActionListener((ActionEvent ae) -> {
                try {
                     conexion.agregarNumm(0);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            boton0.setVisible(true);

            // Botones de operaciones

            JButton botonSuma = new JButton("+");
            botonSuma.addActionListener((ActionEvent ae) -> {
                try {
                    conexion.agregarOperacion2(1);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            botonSuma.setVisible(true);

            JButton botonResta = new JButton("-");
            botonResta.addActionListener((ActionEvent ae) -> {
                try {
                    conexion.agregarOperacion2(2);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            botonResta.setVisible(true);

            JButton botonMultiplicacion = new JButton("*");
            botonMultiplicacion.addActionListener((ActionEvent ae) -> {
                try {
                    conexion.agregarOperacion2(3);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            botonMultiplicacion.setVisible(true);

            JButton botonDivision = new JButton("/");
            botonDivision.addActionListener((ActionEvent ae) -> {
                try {
                    conexion.agregarOperacion2(4);
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            botonDivision.setVisible(true);

            JButton botonIgual = new JButton("=");
            botonIgual.addActionListener((ActionEvent ae) -> {
                try {
                    conexion.realizarOperacion2();
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            botonIgual.setVisible(true);

            JButton botonLimpiar = new JButton("C");
            botonLimpiar.addActionListener((ActionEvent ae) -> {
                try {
                    conexion.clean();;
                } catch (Exception e) {
                    System.err.println("Ocurrió un error al mandar la información: " + e);
                }
            });
            botonLimpiar.setVisible(true);
            
            panelBotones.add(boton7);
            panelBotones.add(boton8);
            panelBotones.add(boton9);
            panelBotones.add(botonDivision);

            panelBotones.add(boton4);
            panelBotones.add(boton5);
            panelBotones.add(boton6);
            panelBotones.add(botonMultiplicacion);
            
            panelBotones.add(boton1);
            panelBotones.add(boton2);
            panelBotones.add(boton3);
            panelBotones.add(botonResta);
            
            panelBotones.add(boton0);
            panelBotones.add(botonIgual);
            panelBotones.add(botonLimpiar);
            panelBotones.add(botonSuma);

            // Incrustación de los paneles
            principal.add(panelVentana, BorderLayout.NORTH);
            principal.add(panelBotones, BorderLayout.CENTER);

            /* Hilo para recuperar los datos desde el servidor */
            Thread recp = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            ventana.setText(conexion.recp());
                        } catch (Exception e) {
                            System.err.println("Ocurrió un error al recuperar los datos: " + e + "\nSe terminó la conexión con el servidor. :)");
                            break;
                        }
                    }
                }
            });
            recp.start();

            principal.setTitle("Calculadora cliente 2");
            principal.setSize(300, 450);
            principal.setResizable(false);
            principal.setVisible(true);
            principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e);
        }
    }
}

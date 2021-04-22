/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chatservidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sistemas-12
 */
public class Server extends Thread {
    
    
    private ServerSocket serverSocket;
    
    LinkedList<ClienteHilo> cliente;
    
    private final VentanaServer ventana;
    
    private final String puerto;
    
    static int correlativo;
    
    public Server(String puerto, VentanaServer ventana) {
        correlativo=0;
        this.puerto=puerto;
        this.ventana=ventana;
        cliente=new LinkedList<>();
        this.start();
    }
      
    public void run() {
        try {
            serverSocket = new ServerSocket(Integer.valueOf(puerto));
            ventana.addServerIniciado();
            while (true) {
                ClienteHilo p;
                Socket socket;
                socket = serverSocket.accept();
                System.out.println("Nueva conexion entrante: "+socket);
                p=new ClienteHilo(socket, this);               
                p.start();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ventana, "El servidor no se ha podido iniciar,\n"
                                                 + "puede que haya ingresado un puerto incorrecto.\n"
                                                 + "Esta aplicación se cerrará.");
            System.exit(0);
        }                
    }        
    
    LinkedList<String> getUsuariosConectados() {
        LinkedList<String>usuariosConectados=new LinkedList<>();
        cliente.stream().forEach(c -> usuariosConectados.add(c.getIdentificador()));
        return usuariosConectados;
    }
    
    void agregarLog(String texto) {
        ventana.agregaarLog(texto);
    }
}
   
    
    


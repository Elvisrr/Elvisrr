/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chatservidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

/**
 *
 * @author Sistemas-12
 */


    public class ClienteHilo extends Thread{
    
    private final Socket socket;    
        
    private ObjectOutputStream objectOutputStream;
    
    private ObjectInputStream objectInputStream;            
           
    private final Server server;
    
    private String identificador;
    
    private boolean escuchando;
   
    public ClienteHilo(Socket socket,Server server) {
        this.server=server;
        this.socket = socket;
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.err.println("Error en la inicialización del ObjectOutputStream y el ObjectInputStream");
        }
    }
        
    public void desconnectar() {
        try {
            socket.close();
            escuchando=false;
        } catch (IOException ex) {
            System.err.println("Error al cerrar el socket de comunicación con el cliente.");
        }
    }
        
    public void run() {
        try{
            escuchar();
        } catch (Exception ex) {
            System.err.println("Error al llamar al método readLine del hilo del cliente.");
        }
        desconnectar();
    }
        
        
    public void escuchar(){        
        escuchando=true;
        while(escuchando){
            try {
                Object aux=objectInputStream.readObject();
                if(aux instanceof LinkedList){
                    ejecutar((LinkedList<String>)aux);
                }
            } catch (Exception e) {                    
                System.err.println("Error al leer lo enviado por el cliente.");
            }
        }
    }
            
    public void ejecutar(LinkedList<String> lista){
        
        String tipo=lista.get(0);
        switch (tipo) {
            case "SOLICITUD_CONEXION":
               
                confirmarConexion(lista.get(1));
                break;
            case "SOLICITUD_DESCONEXION":
                
                confirmarDesConexion();
                break;                
            case "MENSAJE":
               
                String destinatario=lista.get(2);
                server.cliente
                        .stream()
                        .filter(p -> (destinatario.equals(p.getIdentificador())))
                        .forEach((p) -> p.enviarMensaje(lista));
                break;
            default:
                break;
        }
    }
    
        
    private void enviarMensaje(LinkedList<String> lista){
        try {
            objectOutputStream.writeObject(lista);            
        } catch (Exception e) {
            System.err.println("Error al enviar el objeto al cliente.");
        }
    }    
    /**
     * Una vez conectado un nuevo cliente, este método notifica a todos los clientes
     * conectados que hay un nuevo cliente para que lo agreguen a sus contactos.
     * @param identificador 
     */
    private void confirmarConexion(String identificador) {
        Server.correlativo++;
        this.identificador=Server.correlativo+" - "+identificador;
        LinkedList<String> lista=new LinkedList<>();
        lista.add("CONEXION_ACEPTADA");
        lista.add(this.identificador);
        lista.addAll(server.getUsuariosConectados());
        enviarMensaje(lista);
        server.agregarLog("\nNuevo cliente: "+this.identificador);
        //enviar a todos los clientes el nombre del nuevo usuario conectado excepto a él mismo
        LinkedList<String> auxLista=new LinkedList<>();
        auxLista.add("NUEVO_USUARIO_CONECTADO");
        auxLista.add(this.identificador);
        server.cliente
                .stream()
                .forEach(cliente -> cliente.enviarMensaje(auxLista));
        server.cliente.add(this);
    }
    
    public String getIdentificador() {
        return identificador;
    }
    
    private void confirmarDesConexion() {
        LinkedList<String> auxLista=new LinkedList<>();
        auxLista.add("USUARIO_DESCONECTADO");
        auxLista.add(this.identificador);
        server.agregarLog("\nEl cliente \""+this.identificador+"\" se ha desconectado.");
        this.desconnectar();
        for(int i=0;i<server.cliente.size();i++){
            if(server.cliente.get(i).equals(this)){
                server.cliente.remove(i);
                break;
            }
        }
        server.cliente
                .stream()
                .forEach(h -> h.enviarMensaje(auxLista));        
    }
}
    



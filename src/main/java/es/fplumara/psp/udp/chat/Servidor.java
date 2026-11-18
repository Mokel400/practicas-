package es.fplumara.psp.udp.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args){
        try(DatagramSocket socket = new DatagramSocket(5000)){
            System.out.println("Servidor iniciado");
            while (true){
                byte[] buffer = new byte[1024];
                DatagramPacket paquete = new DatagramPacket(buffer,buffer.length);
                try {
                    socket.receive(paquete);
                    String mensaje = new String(paquete.getData(), 0,  paquete.getLength());
                    if (mensaje.equalsIgnoreCase("exit")){
                        System.out.println("Cerrando servidor");
                        break;
                    }
                    paquete.getAddress();
                    System.out.println("Mensaje recibido con exito");
                    System.out.println(mensaje);
                } catch (IOException e) {
                    System.out.println("Error al recibir el paquete" + e.getMessage());
                }
            }
        } catch (SocketException e) {
            System.out.println("El puerto ya esta en uso");
        }
    }
}

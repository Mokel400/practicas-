package es.fplumara.psp.udp.chat;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args){

        try (DatagramSocket socket = new DatagramSocket()) {
            while(true){
                Scanner sc = new Scanner(System.in);
                InetAddress ipServidor = InetAddress.getByName("localhost");
                int puerto = 5000;
                System.out.println("Escribe tu mensaje");
                String mensaje = sc.nextLine();
                if (mensaje.equalsIgnoreCase("exit")){
                    System.out.println("Cerrando conexiónº");
                    break;
                }
                byte[] buffer = mensaje.getBytes();
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, ipServidor, puerto);
                socket.send(paquete);
                System.out.println("Mensaje enviado con exito");
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("Servidor no encontrado");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

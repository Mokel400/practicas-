package es.fplumara.psp.tcp.convertidorMayusculas;

import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Iniciando servidor");
            System.out.println("Esperando cliente");
            Socket cliente = server.accept();
            PrintWriter salida = new PrintWriter(
                    cliente.getOutputStream(), true
            );
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream())
            );
            while(true){
                String mensaje = entrada.readLine();
                System.out.println("Cliente: "+ mensaje);
                if(mensaje.equalsIgnoreCase("exit") || mensaje.equalsIgnoreCase("salir") ){
                    break;
                }
                String respuesta = mensaje.toUpperCase();
                System.out.print("Servidor: " + respuesta);
                salida.println(respuesta);
            }
            server.close();
            cliente.close();

        } catch (ConnectException e){
            System.out.println("fallo en la conexion");
        } catch (IOException e) {
            System.out.println("fallo en la conexion");
        }
    }
}

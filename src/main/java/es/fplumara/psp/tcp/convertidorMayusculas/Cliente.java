package es.fplumara.psp.tcp.convertidorMayusculas;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6000);
            System.out.println("Conexion establecida correctamente.");
            PrintWriter salida = new PrintWriter(
                    socket.getOutputStream(), true
            );
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Cliente: ");
                String mensaje = sc.nextLine();
                salida.println(mensaje);
                if(mensaje.equalsIgnoreCase("exit") || mensaje.equalsIgnoreCase("salir") ){
                    break;
                }
                String respuesta = entrada.readLine();
                System.out.println("Servidor: " + respuesta);
            }
            socket.close();

        } catch (ConnectException e){
            System.out.println("fallo en la conexion");
        } catch (IOException e) {
            System.out.println("fallo en la conexion");
        }
    }
}

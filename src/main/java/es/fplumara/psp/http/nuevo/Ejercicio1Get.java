package es.fplumara.psp.http.nuevo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Ejercicio1Get {

    public static void main(String[] args) {

        String endpoint = "https://jsonplaceholder.typicode.com/users/1";

        //Paso 1: Crear el cliente
        HttpClient client = HttpClient.newHttpClient();

        //Paso 2: Crear la petición
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();

        try {
            //Paso 3: Enviar la petición de forma síncrona y obtener la respuesta
            HttpResponse<String> repuesta = client.send(peticion, HttpResponse.BodyHandlers.ofString());

            //Paso 4: Obtener el código de repuesta
            int codigo =  repuesta.statusCode();
            System.out.println("Código de respuesta: " + codigo);

            //Paso 5: Procesar el resultado
            if (codigo >= 200 && codigo < 300) {
                System.out.println("Respuesta del serividor: " + repuesta.body());
            } else {
                System.out.println("Error de HTTP: " + codigo);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error de HTTP: " + e.getMessage());
        }
    }






}

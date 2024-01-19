package Tema11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class ClienteHTTP {

    public static void main(String[] args) {
        try {
            // Creamos la instancia URI
            URI uri = new URI("https://www.flightradar24.com/45.04,-5.13/5");

            // Convertimos la instancia a URL
            URL url = uri.toURL();

            // Abrimos la conexión
            URLConnection connection = url.openConnection();

            // Obtenemos el flujo de entrada del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Leemos los datos de la respuesta
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            // Cerramos la conexión
            reader.close();

        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
    }
}


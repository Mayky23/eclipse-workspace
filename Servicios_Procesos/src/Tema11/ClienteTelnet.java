package Tema11;

import org.apache.commons.net.telnet.TelnetClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClienteTelnet {

    public static void main(String[] args) {
        // Crea un objeto TelnetClient usando el constructor por defecto
        TelnetClient telnetClient = new TelnetClient();

        try {
            // Realiza la conexión Telnet a "telehack.com" en el puerto 23
            telnetClient.connect("telehack.com", 23);

            // Obtiene los flujos de comunicación
            BufferedReader reader = new BufferedReader(new InputStreamReader(telnetClient.getInputStream()));

            // Imprime cada línea de contenido del servidor
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Desconecta el servidor Telnet
            telnetClient.disconnect();

        } catch (IOException e) {
            // Maneja las excepciones
            e.printStackTrace();
        }
    }
}

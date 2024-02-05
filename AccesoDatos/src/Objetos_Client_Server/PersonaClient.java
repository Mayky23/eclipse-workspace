package Objetos_Client_Server;

import java.io.*;
import java.net.*;

public class PersonaClient {
    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int portNumber = 20000;

        try (Socket echoSocket = new Socket(hostName, portNumber);
             ObjectOutputStream out = new ObjectOutputStream(echoSocket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(echoSocket.getInputStream())) {

            // Crea un objeto Persona para enviar al servidor
            Persona persona = new Persona("Juan", 25);

            // Envia el objeto Persona al servidor
            out.writeObject(persona);

            // Puedes seguir realizando otras operaciones si es necesario
        }
    }
}

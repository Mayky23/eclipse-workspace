package Objetos_Client_Server;

import java.io.*;
import java.net.*;

public class PersonaServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int portNumber = 20000;

        try (ServerSocket serverSocket = new ServerSocket(portNumber);
             Socket clientSocket = serverSocket.accept();
             ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {

            // Recibe el objeto Persona del cliente
            Persona persona = (Persona) in.readObject();
            System.out.println("Persona recibida en el servidor: " + persona);

            // Puedes trabajar con el objeto Persona como desees
        }
    }
}

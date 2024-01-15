package Tema10;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClienteTCP {

    private static final String HOST = "localhost";
    private static final int PUERTO = 6000;

    public static void main(String[] args) {
        // Crear instancia de ClienteTCP
        ClienteTCP cliente = new ClienteTCP();
        
        cliente.establecerConexionYRecibirMensaje();
    }

    // Constructor
    public ClienteTCP() {
    }
    
 // Establecer Conexión
    public void establecerConexionYRecibirMensaje() {
        try {
            // Creación de un socket cliente para la conexión.
            Socket skCliente = new Socket(HOST, PUERTO);
            
            // Obtención del flujo de entrada
            InputStream aux = skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream(aux);
            
            // Datos de entrada de datos para leer del socket cliente.
            System.out.println("Mensaje recibido del servidor");
            System.out.println(flujo.readUTF());

            // Cerrar el socket skCliente
            skCliente.close();
        } catch (IOException ex) {
            // Manejar excepciones en caso de error
            System.out.println("Error en el cliente: " + ex.toString());
        }
    }
}

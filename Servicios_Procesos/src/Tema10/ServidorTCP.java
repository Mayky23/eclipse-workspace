package Tema10;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
	
    private static final int PUERTO = 6000;
    private static final int MAX_CLIENTES = 3;

    public static void main(String[] args) {
        
        ServidorTCP servidor = new ServidorTCP();
        
        servidor.iniciarServidor();
    }

    // Constructor
    public ServidorTCP() {  
    }

    // Método para iniciar el servidor
    public void iniciarServidor() {
        try {
            // Crear el socket servidor
            ServerSocket skServidor = new ServerSocket(PUERTO);
         // Imprime un mensaje
            System.out.println("Escuchando en el puerto " + PUERTO);
            
         // Bucle para atender a todos los clientes
            for (int numCli = 1; numCli <= MAX_CLIENTES; numCli++) {
            	
            	// Acepta un cliente
                Socket skCliente = skServidor.accept();
                // Indicar cliente
                System.out.println("Sirvo al cliente " + numCli);
                
             // Obtiene el flujo de salida del socket del cliente
                OutputStream aux = skCliente.getOutputStream();
             // Crea un flujo de salida para enviar el mensaje al cliente
                DataOutputStream flujo = new DataOutputStream(aux);
                // Mandar un mensaje al cliente
                flujo.writeUTF("Hola cliente " + numCli);

                // Cerrar el socket del cliente
                skCliente.close();
            }
            
            // Cerrar el socket del servidor
            skServidor.close();
        } catch (IOException e) {
            // Manejar excepciones en caso de error
            System.out.println(e.getMessage());
        }
    }
}

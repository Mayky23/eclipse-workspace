package Tema10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class ClienteUDP {
    private static final int PUERTO = 6789;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
    	
        ClienteUDP clienteUDP = new ClienteUDP();

        clienteUDP.comunicacionUDP();
    }

    // Constructor
    public ClienteUDP() {
    }

    // Método para realizar la comunicación UDP
    public void comunicacionUDP() {
        try {
            Random aleatorio = new Random();
            int numerocliente = aleatorio.nextInt(100) + 1;

            // Crear el mensaje que se enviará al servidor
            String mensajeenviar = String.valueOf(numerocliente);

         // Crea un socket UDP
            DatagramSocket socketUDP = new DatagramSocket();

            // Convierte el mensaje a un array de bytes
            byte[] mensaje = mensajeenviar.getBytes();

            // Obtiene la IP del servidor
            InetAddress hostServidor = InetAddress.getByName(HOST);

            // Crea un paquete para enviar el mensaje
            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, PUERTO);

            // Envía el paquete al servidor
            socketUDP.send(peticion);


            // Construir el DatagramPacket que contendrá la respuesta
            byte[] buffer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);

            // Recibir la respuesta del servidor
            socketUDP.receive(respuesta);

            // Imprimir la respuesta del servidor
            System.out.println("Respuesta: " + new String(respuesta.getData()).trim());

            // Cerrar el socket UDP
            socketUDP.close();
        } catch (IOException e) {
        	
            // Manejar excepciones en caso de error
            System.out.println("Error: " + e.getMessage());
        }
    }
}

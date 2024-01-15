package Tema10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {
    private static final int PUERTO = 6789;

    public static void main(String[] args) {

        ServidorUDP servidorUDP = new ServidorUDP();
        servidorUDP.iniciarServidorUDP();
    }

    // Constructor
    public ServidorUDP() {
    }

    // Método para iniciar el servidor UDP
    public void iniciarServidorUDP() {
        try {
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);
            System.out.println("Escuchando en el puerto " + PUERTO);

            // Bucle infinito para atender a todos los clientes
            while (true) {
                // Construir el DatagramPacket para recibir peticiones
                byte[] buffer = new byte[1000];
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                // Leer la petición del DatagramSocket
                socketUDP.receive(peticion);

                // Obtener la información del cliente
                String mensajeRecibido = new String(peticion.getData());
                System.out.println("Datagrama recibido del host: " + peticion.getAddress());
                System.out.println("Desde el puerto remoto: " + peticion.getPort());
                System.out.println("Con el mensaje: " + mensajeRecibido);

                // Construir el DatagramPacket para enviar la respuesta
                String mensajeRespuesta = "Hola Cliente " + mensajeRecibido;
                DatagramPacket respuesta = new DatagramPacket(mensajeRespuesta.getBytes(),
                        mensajeRespuesta.length(), peticion.getAddress(), peticion.getPort());

                // Enviar la respuesta al cliente
                socketUDP.send(respuesta);
            }
        } catch (IOException e) {
            // Manejar excepciones en caso de error
            System.out.println("Error: " + e.getMessage());
        }
    }
}

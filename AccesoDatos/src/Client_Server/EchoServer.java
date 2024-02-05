package Client_Server;

/* Un socket es un mecanismo de comunicación que permite que dos procesos (programas) en diferentes 
dispositivos o en el mismo dispositivo se comuniquen entre sí. Es un concepto fundamental en redes 
de computadoras y programación de sistemas.

En el contexto de la programación de red, un socket es una interfaz que permite la comunicación 
entre procesos a través de una red. Un socket proporciona un medio para que los programas envíen y 
reciban datos, ya sea en la misma máquina (comunicación interproceso o IPC) o a través de una red 
(comunicación entre dispositivos).

Hay dos tipos principales de sockets:

Socket de cliente: Representa el punto final del cliente en una conexión. Un programa cliente 
utiliza un socket de cliente para conectarse a un servidor.

Socket de servidor: Representa el punto final del servidor en una conexión. Un programa servidor 
utiliza un socket de servidor para esperar y aceptar conexiones entrantes de clientes.

En resumen, un socket es esencialmente un conjunto de funciones y estructuras de datos que 
facilitan la comunicación entre procesos a través de una red. En Java, las clases Socket y 
ServerSocket son utilizadas para implementar sockets y permitir la comunicación entre programas 
cliente y servidor.
*/

import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        // Puerto predeterminado al que el servidor estará escuchando
        int portNumber = 20000;

        try (
                // Paso 1: Crea un ServerSocket que escucha en el puerto especificado o en el
                // predeterminado
                ServerSocket serverSocket = new ServerSocket(portNumber);

                // Paso 2: Espera a que un cliente se conecte y acepta la conexión
                Socket clientSocket = serverSocket.accept();

                // Paso 3: Crea un PrintWriter para enviar datos al cliente
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Paso 4: Crea un BufferedReader para recibir datos del cliente
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));) {
            
                            String inputLine;

            // Paso 5: Lee datos del cliente y los reenvía de vuelta
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
            }
        } catch (IOException e) {
            // Captura cualquier excepción de E/S y muestra un mensaje de error
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}

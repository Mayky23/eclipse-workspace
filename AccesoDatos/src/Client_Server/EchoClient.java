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

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        // Dirección del servidor al que el cliente se conectará
        String hostName = "localhost";

        // Puerto en el que el servidor está escuchando
        int portNumber = 20000;

        try (
                // Paso 1: Crea un Socket para conectarse al servidor en la dirección y puerto
                // especificados
                Socket echoSocket = new Socket(hostName, portNumber);

                // Paso 2: Crea un PrintWriter para enviar datos al servidor
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);

                // Paso 3: Crea un BufferedReader para recibir datos del servidor
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

                // Paso 4: Crea un BufferedReader para leer la entrada del usuario desde la
                // consola
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput;

            // Paso 5: Lee la entrada del usuario desde la consola y envía al servidor
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);

                // Muestra la respuesta del servidor en la consola del cliente
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            // Captura una excepción si la dirección del host es desconocida
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            // Captura una excepción si hay un problema de E/S durante la conexión
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
    }
}

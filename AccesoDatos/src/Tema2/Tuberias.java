package Tema2;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Tuberias {

    public static void main(String[] args) {
        // Creamos un tubo (pipe) de entrada y salida
        final PipedOutputStream salida = new PipedOutputStream();
        final PipedInputStream entrada;

        try {
            // Conectamos la entrada al tubo de salida
            entrada = new PipedInputStream(salida);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Creamos un hilo (thread) para escribir en el tubo
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Escribimos "Hola por aquí!" en el tubo de salida
                    salida.write("Hola por aqui amigo".getBytes());
                    // Cerramos el extremo de escritura del tubo
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Creamos un hilo para leer del tubo
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int unByte = entrada.read();
                    // Leemos bytes del tubo y los imprimimos como caracteres hasta que lleguemos al final (-1)
                    while (unByte != -1) {
                        System.out.print((char) unByte);
                        unByte = entrada.read();
                    }
                    // Cerramos el extremo de lectura del tubo
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Iniciamos ambos hilos
        thread1.start();
        thread2.start();

        try {
            // Esperamos a que ambos hilos terminen antes de salir del programa principal
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

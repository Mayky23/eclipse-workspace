package Tema2;

import java.io.CharArrayReader;
import java.io.IOException;

public class Arrays {

    public static void main(String[] args) throws IOException {
        // Creamos un array de caracteres a partir de la cadena "hola amigo"
        char[] chars = "hola amigo".toCharArray();
        
        // Creamos un CharArrayReader para leer desde el array de caracteres
        CharArrayReader charArrayReader = new CharArrayReader(chars);
        
        int data = 0;
        try {
            // Leemos un carácter a la vez desde el CharArrayReader
            data = charArrayReader.read();
            
            while (data != -1) {
                // Realizamos operaciones (en este caso, simplemente imprimimos el carácter)
                System.out.println((char) data);
                
                // Leemos el siguiente carácter
                data = charArrayReader.read();
            }
        } catch (IOException e) {
            // Manejamos cualquier excepción de entrada/salida que pueda ocurrir
            e.printStackTrace();
        } finally {
            // Cerramos el CharArrayReader en un bloque finally para asegurarnos de que siempre se cierre
			charArrayReader.close();
        }
    }
}
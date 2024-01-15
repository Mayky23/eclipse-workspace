package Tema2;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Tokens {

    public static void main(String[] args) {
        // Creamos un objeto StreamTokenizer para analizar el texto
        String texto = "Hola mi edad es 45";
        StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(texto));

        try {
            // Configuramos StreamTokenizer para reconocer números como tokens
            streamTokenizer.ordinaryChar(' '); // Tratamos el espacio como carácter ordinario
            streamTokenizer.wordChars('0', '9'); // Permitimos caracteres numéricos en palabras

            // Leemos y procesamos los tokens
            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    // Si es una palabra, la imprimimos
                    System.out.println(streamTokenizer.sval);
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    // Si es un número, lo imprimimos
                    System.out.println(streamTokenizer.nval);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package Tema2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class BuscaNumeros{
    public static void main(String[] args) {
        try {
            // Ruta del archivo que deseas analizar
            String rutaArchivo = "C:\\Users\\AlumnoT\\Desktop\\lista.html";

            // Crea un objeto FileReader para abrir el archivo
            FileReader archivo = new FileReader(rutaArchivo);

            // Crea un objeto StreamTokenizer para analizar el contenido del archivo
            StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(archivo));

            // Define los caracteres que serán considerados números
            tokenizer.parseNumbers();

         // Recorre el documento en busca de edades (números) siempre y cuando tenga detrás la palabra "años"
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                // Verifica si el token actual es un número y si el siguiente token es una palabra "años"
                if (tokenizer.ttype == StreamTokenizer.TT_NUMBER && tokenizer.nextToken() == StreamTokenizer.TT_WORD && tokenizer.sval.equals("años")) {
                    // Cumple la condición, significa que hemos encontrado una edad seguida de la palabra "años"
                    int edad = (int) tokenizer.nval;
                    System.out.println("Edad encontrada: " + edad);
                }
            }


            // Cierra el archivo después de usarlo
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

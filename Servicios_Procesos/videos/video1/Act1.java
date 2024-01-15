package video1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Act1 {

/**
 * 
 * @param args comando de línea de argumentos para el programa
 */
	
	    public static void main(String[] args) {


	        Scanner teclado = new Scanner(System.in);
	        int numero1, numero2;


	        System.out.println("Dame un número:");
	        numero1 = teclado.nextInt();

	        System.out.println("Dame otro número:");
	        numero2 = teclado.nextInt();

	        try {
	            int estado_ejecucion = ejecutarClaseProceso(Sumador.class, numero1, numero2);

	            if (estado_ejecucion == 0) {
	                System.out.println("Proceso ejecutado correctamente.");
	            } else {
	                System.out.println("Error ejecutando el proceso.");
	            }

	        } catch (IOException | InterruptedException ex) {
	            System.err.println("Error: " + ex.toString());
	            System.exit(-1);
	        }
	        teclado.close();
	    }

	    /**Ejecuta una clase del proyecto en un proceso
	     * 
	     * @param clase Clase a ejecutar
	     * @param n1 numero 1
	     * @param n2 numero 2
	     * @return Resultado de haber ejecutado el proceso
	     * @throws IOException Esta excepcion se lanzara si ocurre algun error en la ejecucion del proceso
	     * @throws InterruptedException Esta excepcion se lanzara si ocurre algun error en la ejecucion del proceso
	     * 
	     * La clase a ejecutar debe tener un main
	     */

	    public static int ejecutarClaseProceso(Class<?> clase, int n1, int n2) throws IOException, InterruptedException {
	        // Definir donde esta el home de Java
	    	String javaHome = System.getProperty("java.home");
	    	//Definir ubicacion del bin de Java
	        String javaBin = javaHome 
	                + File.separator + "bin" 
	                + File.separator + "java";
	        //Definir el path 
	        String classpath = System.getProperty("java.class.path");
	        //Obtener el nombre canónico de la clase que se va a ejecutar
	        String className = clase.getCanonicalName();
	        // Crear el proceso a ejecutar
	        // Los dos últimos son los parámetros del método main de la clase
	        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className, String.valueOf(n1), String.valueOf(n2));
	        Process process = builder.start();
	        // Esperar a que se ejecute el proceso
	        process.waitFor();
	        return process.exitValue();
	    }
	}

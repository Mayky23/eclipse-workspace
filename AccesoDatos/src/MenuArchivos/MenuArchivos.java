package MenuArchivos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuArchivos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**************************************");
            System.out.println("**  MENU DE ARCHIVOS Y DIRECTORIOS  **");
            System.out.println("**************************************");
            System.out.println("** 1. Crear archivo                 **");
            System.out.println("** 2. Mover archivo                 **");
            System.out.println("** 3. Eliminar archivo              **");
            System.out.println("** 4. Añadir info a un archivo      **"); 
            System.out.println("** 5. Consultar info de un archivo  **");
            System.out.println("** 6. Crear directorio              **"); 
            System.out.println("** 7. Salir                         **");
            System.out.println("**************************************");
            System.out.println("Seleccione una opción:");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearArchivo(scanner);
                    break;
                case 2:
                    moverArchivo(scanner);
                    break;
                case 3:
                    eliminarArchivo(scanner);
                    break;
                case 4:
                    añadirInfoArchivo(scanner);
                    break;
                case 5:
                    consultarInfoArchivo(scanner); 
                    break;
                case 6:
                    crearDirectorio(scanner); 
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }
    }

    private static void crearArchivo(Scanner scanner) {
        
    System.out.println("Ingrese el nombre del archivo a crear:");
    String nombreArchivo = scanner.next();

    try {
        File archivo = new File(nombreArchivo);
        if (archivo.createNewFile()) {
            System.out.println("Archivo creado exitosamente.");
        } else {
            System.out.println("El archivo ya existe.");
        }
    } catch (IOException e) {
        System.out.println("Error al crear el archivo");
    }
    }
    

    private static void moverArchivo(Scanner scanner) {
       
    System.out.println("Ingrese el nombre del archivo a mover:");
    String nombreArchivo = scanner.next();

    System.out.println("Ingrese la nueva ubicación del archivo:");
    String nuevaUbicacion = scanner.next();

    File archivo = new File(nombreArchivo);
    File nuevaUbicacionDir = new File(nuevaUbicacion);

    if (archivo.exists() && archivo.isFile()) {
        if (nuevaUbicacionDir.isDirectory()) {
            File nuevoArchivo = new File(nuevaUbicacionDir, archivo.getName());
            if (archivo.renameTo(nuevoArchivo)) {
                System.out.println("Archivo movido exitosamente.");
            } else {
                System.out.println("No se pudo mover el archivo.");
            }
        } else {
            System.out.println("La nueva ubicación no es un directorio válido.");
        }
    } else {
        System.out.println("El archivo no existe o no es válido.");
    }
    

    }

    private static void eliminarArchivo(Scanner scanner) {
        System.out.println("Ingrese el nombre del archivo a eliminar:");
    String nombreArchivo = scanner.next();

    File archivo = new File(nombreArchivo);

    if (archivo.exists() && archivo.isFile()) {
        if (archivo.delete()) {
            System.out.println("Archivo eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el archivo.");
        }
    } else {
        System.out.println("El archivo no existe o no es válido.");
    }
    }

    private static void añadirInfoArchivo(Scanner scanner) {
    System.out.println("Ingrese el nombre del archivo al que desea añadir información:");
    String nombreArchivo = scanner.next();

    System.out.println("Ingrese la información que desea añadir:");
    String informacion = scanner.next();

    try {
        FileWriter writer = new FileWriter(nombreArchivo, true); // Abre el archivo en modo de escritura al final.
        writer.write(informacion);
        writer.close();
        System.out.println("Información añadida exitosamente al archivo.");
    } catch (IOException e) {
        System.out.println("Error al añadir información al archivo");
    }
}

private static void consultarInfoArchivo(Scanner scanner) {
    System.out.println("Ingrese el nombre del archivo del que desea consultar información");
    String nombreArchivo = scanner.next();

    try {
        File archivo = new File(nombreArchivo);
        if (archivo.exists() && archivo.isFile()) {
            try (Scanner fileScanner = new Scanner(archivo)) {
                while (fileScanner.hasNextLine()) {
                    String linea = fileScanner.nextLine();
                    System.out.println(linea);
                }
            }
        } else {
            System.out.println("El archivo no existe o no es válido.");
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo");
    }
}

    private static void crearDirectorio(Scanner scanner) {
        System.out.println("Ingrese el nombre del directorio a crear");
        String nombreDirectorio = scanner.next();

        File directorio = new File(nombreDirectorio);

        if (directorio.mkdir()) {
            System.out.println("Directorio creado exitosamente en la ubicación actual.");
        } else {
            System.out.println("El directorio ya existe o no se pudo crear.");
        }
    }
}

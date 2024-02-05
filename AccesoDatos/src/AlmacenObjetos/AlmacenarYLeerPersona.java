package AlmacenObjetos;

import java.io.*;

class Persona implements Serializable {
    private String nombre;
    private int edad;

    // Constructor vacío
    public Persona() {
        this.nombre = "";
        this.edad = 0;
    }

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método toString para representar la clase como una cadena
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}

public class AlmacenarYLeerPersona {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Crear una instancia de Persona que se va a almacenar
        Persona personaOriginal = new Persona("Juan", 25);

        // Paso 1: Crear un FileOutputStream para escribir en el archivo
        // FileOutputStream: Un flujo de salida de bytes que se utiliza para escribir datos en un archivo.
        FileOutputStream fileOutputStream = new FileOutputStream("persona.obj");

        // Paso 2: Crear un ObjectOutputStream para escribir objetos en el FileOutputStream
        // ObjectOutputStream: Un flujo de salida que proporciona la capacidad de escribir objetos Java de manera serializada en un OutputStream.
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        // Paso 3: Escribir el objeto serializado en el archivo
        objectOutputStream.writeObject(personaOriginal);

        // Paso 4: Cerrar manualmente los flujos de salida para liberar recursos
        objectOutputStream.close();
        fileOutputStream.close();

        // Mensaje de éxito al almacenar la Persona
        System.out.println("Persona almacenada correctamente en el archivo.");

        // Paso 5: Crear un FileInputStream para leer desde el archivo
        // FileInputStream proporciona la entrada de bytes desde un archivo
        FileInputStream fileInputStream = new FileInputStream("persona.obj");

        // Paso 6: Crear un ObjectInputStream para leer objetos desde el FileInputStream
        // ObjectInputStream lee y deserializa los objetos a partir de esa secuencia de bytes.
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        // Paso 7: Leer la Persona desde el archivo y convertirla de nuevo a Persona
        Persona personaCargada = (Persona) objectInputStream.readObject();

        // Paso 8: Cerrar manualmente los flujos de entrada para liberar recursos
        objectInputStream.close();
        fileInputStream.close();

        // Mensaje de éxito al cargar la Persona desde el archivo
        System.out.println("Persona cargada correctamente desde el archivo.");

        // Puedes trabajar con la persona cargada (personaCargada) según tus necesidades
        System.out.println("Datos de la Persona cargada: " + personaCargada);
    }
}

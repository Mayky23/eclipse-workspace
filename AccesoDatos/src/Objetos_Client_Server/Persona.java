package Objetos_Client_Server;

import java.io.Serializable;

class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
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

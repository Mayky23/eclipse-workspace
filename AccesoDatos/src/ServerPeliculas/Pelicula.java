package ServerPeliculas;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String nombre;
    private int anio;
    private int duracion;
    private int nota;

    public Pelicula() {}

    public Pelicula(String nombre, int anio, int duracion, int nota) {
        this.nombre = nombre;
        this.anio = anio;
        this.duracion = duracion;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", anio=" + anio +
                ", duracion=" + duracion +
                ", nota=" + nota +
                '}';
    }
}

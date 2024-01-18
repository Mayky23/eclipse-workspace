package Actividad1;

class Counter {

    // Variable que indica si el contador está sincronizado
    boolean sincronizado;

    // Constructor de la clase Counter que recibe un booleano para indicar si está sincronizado
    public Counter(boolean sincronizado) {
        this.sincronizado = sincronizado;
    }

    // Método que imprime números de forma sincronizada con un identificador de hilo y un límite
    public synchronized void imprimirNumerosSincronizados(int n, int id) {
        for (int i = 0; i <= n; i++) {
            System.out.println("Hilo " + id + " (sincronizado): " + i);
        }
    }

    // Método que imprime números de forma no sincronizada con un identificador de hilo y un límite
    public void imprimirNumeros(int n, int id) {
        for (int i = 0; i <= n; i++) {
            System.out.println("Hilo " + id + " (no sincronizado): " + i);
        }
    }
}

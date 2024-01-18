package Actividad1;

// CountingThread que extiende de Thread
class CountingThread extends Thread {

    
    private int id; // Identificador del  hilo
    private int numero; // Número límite de la secuencia
    private Counter counter; // Objeto Counter utilizado por el hilo

    // Constructor de la clase CountingThread que recibe un identificador, un número y un objeto Counter
    public CountingThread(int id, int numero, Counter counter) {
        this.id = id;
        this.numero = numero;
        this.counter = counter;
    }

    // Método run, se ejecuta cuando el hilo comienza a correr
    @Override
    public void run() {
        // Verifica si el contador está sincronizado
        if (counter.sincronizado) {
            // imprimir números de forma sincronizada
            counter.imprimirNumerosSincronizados(numero, id);
        } else {
            // imprimir números de forma no sincronizada
            counter.imprimirNumeros(numero, id);
        }
    }
}

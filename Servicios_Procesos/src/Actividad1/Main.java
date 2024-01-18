package Actividad1;


public class Main {
    
    public static void main(String[] args) throws InterruptedException {
    	
        // Variable booleana para controlar la sincronización
        boolean sincronizado = false;

        // Creación de un objeto Counter con el valor de sincronización dado
        Counter counter = new Counter(sincronizado);

        // Creación de dos hilos de conteo con parámetros específicos
        CountingThread h1 = new CountingThread(1, 5, counter);
        CountingThread h2 = new CountingThread(2, 5, counter);

        // Inicio de los hilos
        h1.start();
        h2.start();

        // Espera a que ambos hilos finalicen
        h1.join();
        h2.join();

        // Mensaje de finalización de la ejecución
        System.out.println("Ejecución terminada");

        // Cambiando el valor de sincronizado a true
        sincronizado = true;
        counter = new Counter(sincronizado);

        // Creación de nuevos hilos con el nuevo objeto Counter
        h1 = new CountingThread(1, 5, counter);
        h2 = new CountingThread(2, 5, counter);

        // Inicio de los nuevos hilos
        h1.start();
        h2.start();

        // Espera a que ambos hilos finalicen
        h1.join();
        h2.join();

        // Mensaje de finalización de la ejecución
        System.out.println("Ejecución terminada");
    }
}

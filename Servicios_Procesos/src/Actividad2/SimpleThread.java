package Actividad2;

// SimpleThread extiende de Thread
class SimpleThread extends Thread {
	
    // Constructor que recibe un nombre y una prioridad
    public SimpleThread(String name, int priority) {
        super(name); // Llama al constructor de la clase base Thread con el nombre dado
        setPriority(priority); // Establece la prioridad del hilo
    }

    // Método run que se ejecuta cuando el hilo comienza a correr
    @Override
    public void run() {
        // Imprime el nombre y la prioridad del hilo
        System.out.println("Hilo: " + getName() + ", Prioridad: " + getPriority());
    }
}

package Actividad4;

public class Consumidor extends Thread {
    private Buffer buffer;
    private int dormir;

    public Consumidor(Buffer buffer, int dormir) {
        this.buffer = buffer;
        this.dormir = dormir;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            int valor = buffer.get();
            System.out.println("Consumidor saca: " + valor);
            try {
                Thread.sleep(dormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

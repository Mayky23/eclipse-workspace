package Actividad4;

public class Productor extends Thread {
    private Buffer buffer;
    private int dormir;

    public Productor(Buffer buffer, int dormir) {
        this.buffer = buffer;
        this.dormir = dormir;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.put(i);
            System.out.println("Productor pone: " + i);
            try {
                Thread.sleep(dormir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

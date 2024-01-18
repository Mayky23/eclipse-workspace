package Actividad4;

public class Main {
    public static void main(String[] args) {
        final int dormirProductor = 1000;
        final int dormirConsumidor = 2000;

        Buffer buffer = new Buffer();

        Productor productor = new Productor(buffer, dormirProductor);
        Consumidor consumidor = new Consumidor(buffer, dormirConsumidor);

        productor.start();
        consumidor.start();
    }
}

package eti.policarto.threads.exemplodois;

public class Contador implements Runnable {

    private final int inicial;

    public Contador(int inicial) {
        this.inicial = inicial;
    }

    @Override
    public void run() {
        for (int i = this.inicial; i < 1000; i++) {
            System.out.println("Thread: "+ Thread.currentThread().getId() +" -> "+ i);
        }
    }
}

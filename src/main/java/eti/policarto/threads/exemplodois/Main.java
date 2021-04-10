package eti.policarto.threads.exemplodois;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Contador(1), "THREAD-1");
        Thread thread2 = new Thread(new Contador(1), "THREAD-2");
        Thread thread3 = new Thread(new Contador(1), "THREAD-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

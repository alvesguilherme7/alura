package eti.policarto.threads.exemplotres;

public class Main {
    public static void main(String[] args) {
        Banheiro banheiro = new Banheiro();

        Thread thread1 = new Thread(new Tarefa1(banheiro), "João");
        Thread thread2 = new Thread(new Tarefa2(banheiro), "Maria");

        thread1.start();
        thread2.start();
    }
}

package eti.policarto.threads.exemploum;

public class Main {
    public static void main(String[] args) {
        final String termoBusca = "a";
        Buscador buscador1 = new Buscador("assinaturas1.txt", termoBusca);
        Buscador buscador2 = new Buscador("assinaturas2.txt", termoBusca);
        Buscador buscador3 = new Buscador("autores.txt", termoBusca);

        Thread thread1 = new Thread(buscador1, "THREAD-1");
        Thread thread2 = new Thread(buscador2, "THREAD-2");
        Thread thread3 = new Thread(buscador3, "THREAD-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

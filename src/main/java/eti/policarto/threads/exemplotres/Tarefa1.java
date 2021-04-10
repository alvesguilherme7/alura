package eti.policarto.threads.exemplotres;

public class Tarefa1 implements Runnable {

    private final Banheiro banheiro;

    public Tarefa1(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        this.banheiro.fazerNumero1();
    }
}

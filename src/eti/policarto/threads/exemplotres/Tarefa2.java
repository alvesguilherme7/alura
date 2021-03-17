package eti.policarto.threads.exemplotres;

public class Tarefa2 implements Runnable {

    private final Banheiro banheiro;

    public Tarefa2(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        this.banheiro.fazerNumero2();
    }
}

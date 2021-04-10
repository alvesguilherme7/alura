package eti.policarto.threads.exemplotres;

public class Main {
    public static void main(String[] args) {
        Banheiro banheiro = new Banheiro();

        Thread thread1 = new Thread(new Tarefa1(banheiro), "João");
        Thread thread2 = new Thread(new Tarefa2(banheiro), "Maria");
        Thread threadLimpeza = new Thread(new TarefaLimpeza(banheiro), "Limpeza");
        threadLimpeza.setDaemon(true);//marca essa thread para existe somente quando as outras não estiverem terminado
        threadLimpeza.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        threadLimpeza.start();
    }
}

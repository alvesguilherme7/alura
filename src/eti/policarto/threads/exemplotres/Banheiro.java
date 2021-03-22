package eti.policarto.threads.exemplotres;

public class Banheiro {

    public boolean estaSujo = true;

    public void fazerNumero1(){
        final String usuario = Thread.currentThread().getName();
        System.out.println(usuario+" batendo na porta...");
        synchronized (this){
            while(this.estaSujo)
                esperaLaFora(usuario);
            System.out.println(usuario+" fazendo coisa rapida");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(usuario+" acionando a descarga");
            System.out.println(usuario+" lavando a mão");
            System.out.println(usuario+" saindo...");
            this.estaSujo = true;
        }
    }

    public void fazerNumero2(){
        final String usuario = Thread.currentThread().getName();
        System.out.println(usuario+" batendo na porta...");
        synchronized (this){
            while(this.estaSujo)
                esperaLaFora(usuario);
            System.out.println(usuario+" fazendo coisa demorada");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(usuario+" acionando a descarga");
            System.out.println(usuario+" lavando a mão");
            System.out.println(usuario+" saindo...");
            this.estaSujo = true;
        }
    }

    private void esperaLaFora(String nome) {

        System.out.println(nome + ", opa, banheiro está sujo");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void limpa() {

        final String usuario = Thread.currentThread().getName();

        System.out.println(usuario + " batendo na porta");

        synchronized (this) {

            System.out.println(usuario + " entrando no banheiro");

            if (!this.estaSujo) {
                System.out.println(usuario + ", não está sujo, vou sair");
                return;
            }

            System.out.println(usuario + " limpando o banheiro");
            this.estaSujo = false;

            try {
                Thread.sleep(13000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.notifyAll();

            System.out.println(usuario + " saindo do banheiro");
        }
    }
}

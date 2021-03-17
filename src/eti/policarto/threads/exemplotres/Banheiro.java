package eti.policarto.threads.exemplotres;

public class Banheiro {

    public void fazerNumero1(){
        final String usuario = Thread.currentThread().getName();
        System.out.println(usuario+" batendo na porta...");
        synchronized (this){
            System.out.println(usuario+" fazendo coisa rapida");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(usuario+" acionando a descarga");
            System.out.println(usuario+" lavando a mão");
            System.out.println(usuario+" saindo...");
        }
    }

    public void fazerNumero2(){
        final String usuario = Thread.currentThread().getName();
        System.out.println(usuario+" batendo na porta...");
        synchronized (this){
            System.out.println(usuario+" fazendo coisa demorada");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(usuario+" acionando a descarga");
            System.out.println(usuario+" lavando a mão");
            System.out.println(usuario+" saindo...");
        }
    }
}

package eti.policarto.reflection.geral.model;

import eti.policarto.reflection.geral.commons.Run;

public class Controle implements Run {

    private String msg;

    public Controle() {
        this.msg = "Eu sou o construtor padrão.";
    }

    public Controle(String msg) {
        this.msg += "Eu sou o contrutor com uma String.";
        this.msg += msg == null ?  "": msg;
    }

    private Controle(String msg, Integer teste) {
        this.msg = "Eu sou o contrutor com uma String e um Integer.";
        this.msg += msg == null ?  "": msg;
    }

    public void print(){
        System.out.println(this.msg);
    }

    public void print(String msg){
        System.out.println(msg);
    }

    public void lista(){
        System.out.println("Eu estou listando apartir do controle.");
    }

    @Override
    public void go() {
        print();
    }
}

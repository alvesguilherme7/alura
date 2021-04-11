package eti.policarto.reflection.geral.model;

import eti.policarto.reflection.geral.commons.Run;

public class Controle implements Run {
    public void print(){
        System.out.println("Eu sou o controle");
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

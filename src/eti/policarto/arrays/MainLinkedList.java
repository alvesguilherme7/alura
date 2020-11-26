package eti.policarto.arrays;

import java.util.LinkedList;

public class MainLinkedList {

    public static void main(String[] args){

        // melhor performance em inserções e remoções - implementa a inerface List
        LinkedList<Conta> lista = new LinkedList<>();

        Conta cc1 = new ContaCorrente(22, 22);
        Conta cc2 = new ContaCorrente(22, 22);

        lista.add(cc1);

        boolean existe = lista.contains(cc2); //contains sobrescrito

        System.out.println("Já existe? " + existe);

        for(Conta conta : lista){
            System.out.println(conta);
        }
    }

}

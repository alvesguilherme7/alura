package eti.policarto.arrays;

import java.util.ArrayList;

public class MainArrayList {

    public static void main(String[] args){

        // melhor performance em busca e iteração
        ArrayList<Conta> lista = new ArrayList<>();

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

package eti.policarto.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainArrayList {

    public static void main(String[] args){

        // melhor performance em busca e iteração - implementa a inerface List
        ArrayList<Conta> lista = new ArrayList<>();

        Conta cc1 = new ContaCorrente(11, 11);
        Conta cc2 = new ContaCorrente(22, 22);

        lista.add(cc1);

        boolean existe = lista.contains(cc2); //contains sobrescrito

        System.out.println("Já existe? " + existe);

        for(Conta conta : lista){
            System.out.println(conta);
        }

        lista.add(cc2);

        Collections.sort(lista, Comparator.comparing(Conta::getNumero));

        lista.sort(Comparator.comparing(Conta::getNumero));

        System.out.println(lista);
    }

}

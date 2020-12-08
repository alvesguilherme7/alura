package eti.policarto.list.conta;

import eti.policarto.herancaconta.model.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainArrayList {

    public static void main(String[] args){

        // melhor performance em busca e iteração - implementa a inerface List
        ArrayList<Conta> lista = new ArrayList<>();

        Conta cc1 = new ContaCorrente(11, 11);
        Conta cc2 = new ContaCorrente(22, 22);

        Cliente titular1 = new Cliente();
        titular1.setNome("Cláudio Rodrigues");
        cc1.setTitular(titular1);

        Cliente titular2 = new Cliente();
        titular2.setNome("Álvaro Damião");
        cc2.setTitular(titular2);

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

package eti.policarto.arrays;

import eti.policarto.herancaconta.model.Cliente;

import java.util.ArrayList;
import java.util.Collections;

public class MainArrayList2 {
    public static void main(String[] args) {

        ArrayList<Conta> contas = new ArrayList<>();

        contas.add(new ContaCorrente(1,1));
        contas.add(new ContaCorrente(2,2));
        contas.add(new ContaCorrente(3,3));

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Beatriz");
        contas.get(0).setTitular(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Cláudio");
        contas.get(1).setTitular(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setNome("Antônio");
        contas.get(2).setTitular(cliente3);

        System.out.println(contas);

//        Collections.rotate(contas, 1);
//
//        System.out.println(contas);

        contas.sort(Conta::compareTo);

        System.out.println(contas);

    }
}

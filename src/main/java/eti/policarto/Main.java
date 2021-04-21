package eti.policarto;

import eti.policarto.herancaconta.model.ContaCorrente;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(1,1);
        ContaCorrente[] contas = new ContaCorrente[2];
        contas[0] = contaCorrente;
        contas[0].setAgencia(2);
        System.out.println(contaCorrente.getAgencia());

        int i = 5;
        i =+ 10;

        System.out.println(i);
    }
}


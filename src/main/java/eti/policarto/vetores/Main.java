package eti.policarto.vetores;

import eti.policarto.herancaconta.model.Conta;
import eti.policarto.herancaconta.model.ContaCorrente;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(1,1);
        ContaCorrente[] contas = new ContaCorrente[2];
        contas[0] = contaCorrente;
        contas[0].setAgencia(2);
        System.out.println(contaCorrente.getAgencia());//2
        int[] vetorLiteral = { 1, 2, 3 };
        ContaCorrente[] vetorLiteralCC = { null, null, new ContaCorrente(1,1) };
        System.out.println(vetorLiteralCC[2].getAgencia());
        Conta[] contact = new ContaCorrente[2];
        ArrayList<ContaCorrente> a = new ArrayList(1);

    }
}
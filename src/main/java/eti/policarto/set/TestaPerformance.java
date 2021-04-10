package eti.policarto.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

    public static void main(String[] args) {

        Collection<Integer> numerosHashSet = new HashSet<>();// 39s
        Collection<Integer> numerosArrayList = new ArrayList<>(); // 1753s

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numerosHashSet.add(i);
        }

        for (Integer numero : numerosHashSet) {
            numerosHashSet.contains(numero);
        }

        long fim = System.currentTimeMillis();

        System.out.println("Tempo gasto HashSet: " + (fim - inicio));


        inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numerosArrayList.add(i);
        }

        for (Integer numero : numerosArrayList) {
            numerosArrayList.contains(numero);
        }

        fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;

        System.out.println("Tempo gasto ArrayList: " + tempoDeExecucao);

    }

}

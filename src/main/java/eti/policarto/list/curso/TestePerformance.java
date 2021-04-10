package eti.policarto.list.curso;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TestePerformance {

    public static void main(String[] args) {

        System.out.println("**** ArrayList vs LinkedList ***");

        List<Integer> numerosArrayList = new ArrayList<>();
        List<Integer> numerosLinkedList = new LinkedList<>();
        int quantidadeElementos = 1000000;

        long tempoArrayList  = insereElementosNo(numerosArrayList, quantidadeElementos);
        long tempoLinkedList = insereElementosNo(numerosLinkedList, quantidadeElementos);

        System.out.println("Inser��o Normal na ArrayList demorou  " + tempoArrayList);
        System.out.println("Inser��o Normal na LinkedList demorou " + tempoLinkedList);

        System.out.println("*******");

        tempoArrayList  = ordenaElementosDecrecente(numerosArrayList);
        tempoLinkedList = ordenaElementosDecrecente(numerosLinkedList);

        System.out.println("Ordena��o na ArrayList demorou  " + tempoArrayList);
        System.out.println("Ordena��o na LinkedList demorou " + tempoLinkedList);

        System.out.println("*******");

        tempoArrayList = removePrimeirosElementos(numerosArrayList);
        tempoLinkedList = removePrimeirosElementos(numerosLinkedList);

        System.out.println("Remo��o da ArrayList demorou  " + tempoArrayList);
        System.out.println("Remo��o da LinkedList demorou " + tempoLinkedList);

        System.out.println("*******");

        tempoArrayList = buscarElementosNo(numerosArrayList, 999999);
        tempoLinkedList = buscarElementosNo(numerosLinkedList, 999999);

        System.out.println("Busca da ArrayList demorou  " + tempoArrayList);
        System.out.println("Busca da LinkedList demorou " + tempoLinkedList);
    }

    /*
     * removendo 100 elementos sempre na primeira posi��o
     */
    private static long removePrimeirosElementos(List<Integer> numeros) {
        long ini = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            numeros.remove(0); //removendo sempre o primeiro elemento
        }
        long fim = System.currentTimeMillis();
        return fim-ini;
    }

    private static long insereElementosNo(List<Integer> numeros, int quantidade) {
        long ini = System.currentTimeMillis();
        for (int i = 0; i < quantidade; i++) {
            numeros.add(i);
        }
        long fim = System.currentTimeMillis();
        return fim-ini;
    }

    private static long ordenaElementosDecrecente(List<Integer> numeros) {
        long ini = System.currentTimeMillis();
        numeros.sort(Comparator.reverseOrder());
        long fim = System.currentTimeMillis();
        return fim-ini;
    }

    private static long buscarElementosNo(List<Integer> numeros, int pos) {
        long ini = System.currentTimeMillis();
        for (int i = 0; i < pos; i++) {
            numeros.add(i);
        }
        long fim = System.currentTimeMillis();
        return fim-ini;
    }

}

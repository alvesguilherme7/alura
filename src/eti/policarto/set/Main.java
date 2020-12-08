package eti.policarto.set;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<String> alunos = new HashSet<>();
        alunos.add("Paulo");
        alunos.add("Alberto");
        alunos.add("Pedro");
        alunos.add("Nico");

        System.out.println(alunos.size());//4

        alunos.add("Nico");

        System.out.println(alunos.size());//4

        alunos.forEach(System.out::println);
    }
}

package eti.policarto.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("Aprender");
        palavras.add("Evoluir");
        palavras.add("Viver");

        palavras.sort(Comparator.comparingInt(String::length));

        palavras.forEach(System.out::println);

        Curso curso1 = new Curso("A",123);
        Curso curso2 = new Curso("B",90);
        Curso curso3 = new Curso("C",150);

        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);

        cursos
            .stream()
            .filter( curso -> curso.getAlunos() >= 100)
            .map(Curso::getNome)
            .forEach(System.out::println);

        cursos
            .stream()
            .filter(c -> c.getAlunos() >= 100)
            .map(Curso::getAlunos)
            .forEach(System.out::println);


    }
}

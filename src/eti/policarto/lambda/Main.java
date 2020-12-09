package eti.policarto.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> palavras = new ArrayList<>();
        palavras.add("Aprender");
        palavras.add("Evoluir");
        palavras.add("Viver");

        palavras.sort(Comparator.comparingInt(String::length));

        palavras.forEach(System.out::println);

        Curso curso1 = new Curso("Java",123);
        Curso curso2 = new Curso("Java EE",90);
        Curso curso3 = new Curso("CI/CD",150);

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

        cursos = cursos
                    .stream()
                    .filter(c -> c.getAlunos() >= 100)
                    .collect(Collectors.toList());


        Optional<Curso> safeCurso = cursos
                .stream()
                .filter(c -> c.getAlunos() >= 10000)
                .findFirst();

        Consumer<Curso> consumer = Curso::getNome;
        safeCurso.ifPresent(consumer);

        Supplier<Exception> supplier = () -> new Exception("Não encontrei nada.");
        try{
            safeCurso.orElseThrow(supplier);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        cursos
            .stream()
            .filter(c -> c.getAlunos() >= 100)
            .collect(Collectors.toMap(
                    Curso::getNome,
                    Curso::getAlunos
            ))
            .forEach((curso, alunos) -> System.out.println("Curso "+ curso + " tem "+ alunos +" alunos."));


    }
}

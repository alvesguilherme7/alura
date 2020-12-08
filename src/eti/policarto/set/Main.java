package eti.policarto.set;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Curso cursoJavaColecoes = new Curso("Dominando as colecoes do Java", "Paulo Silveira");

        Aluno a1 = new Aluno("Rodrigo Turini", 34672);
        Aluno a2 = new Aluno("Guilherme Silveira", 5617);
        Aluno a3 = new Aluno("Mauricio Aniche", 17645);
        Aluno a4 = new Aluno("Mauricio Aniche", 17645);

        cursoJavaColecoes.addAluno(a1);
        cursoJavaColecoes.addAluno(a2);
        cursoJavaColecoes.addAluno(a3);
        cursoJavaColecoes.addAluno(a4);

        Set<Aluno> alunos = cursoJavaColecoes.getAlunos();

        try{
            alunos.add(a4);
        } catch (UnsupportedOperationException e){
        }

        alunos.forEach(System.out::println);

        boolean matriculado = cursoJavaColecoes.alunoEstaMatriculado(a4);
        System.out.println(matriculado);


    }
}

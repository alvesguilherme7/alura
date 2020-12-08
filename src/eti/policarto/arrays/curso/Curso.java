package eti.policarto.arrays.curso;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new LinkedList<>();

    public Curso(String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void addAula(Aula aula){
        this.aulas.add(aula);
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }
}
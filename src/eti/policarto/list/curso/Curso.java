package eti.policarto.list.curso;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Curso {

    private final String nome;
    private final String instrutor;
    private final List<Aula> aulas = new LinkedList<>();
    private int tempoTotal;

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
        this.tempoTotal += aula.getTempo();
        this.aulas.add(aula);
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }

    public int getTempoTotal(){
        return this.tempoTotal;
    }

    public static int getTempoTotalStatic(Curso curso){
        return curso.aulas.stream().mapToInt(Aula::getTempo).sum();
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", instrutor='" + instrutor + '\'' +
                ", aulas=" + aulas +
                ", tempoTotal=" + tempoTotal +
                '}';
    }
}
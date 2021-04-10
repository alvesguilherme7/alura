package eti.policarto.set;

import eti.policarto.list.curso.Aula;

import java.util.*;

public class Curso {

    private final String nome;
    private final String instrutor;
    private final List<Aula> aulas = new LinkedList<>();
    private final Set<Aluno> alunos = new HashSet<>();
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

    public void addAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }

    public Set<Aluno> getAlunos() {
        return Collections.unmodifiableSet(alunos);
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

    public boolean alunoEstaMatriculado(Aluno aluno) {
        return this.alunos.contains(aluno);
    }
}
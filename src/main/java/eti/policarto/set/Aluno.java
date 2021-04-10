package eti.policarto.set;

import java.util.Objects;

public class Aluno {

    private final String nome;
    private final int numeroMatricula;

    public Aluno(String nome, int numeroMatricula) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    @Override
    public String toString() {
        return "[Aluno: " + this.nome + ", matricula: " + this.numeroMatricula + "]";
    }

    //https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return this.nome.equals(aluno.nome);
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }
}

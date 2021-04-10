package eti.policarto.serializable;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private int idade;

    // evitando a serialização
    private transient Identidade identidade;

    //private Identidade identidade;

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", identidade=" + identidade +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Identidade getIdentidade() {
        return identidade;
    }

    public void setIdentidade(Identidade identidade) {
        this.identidade = identidade;
    }
}

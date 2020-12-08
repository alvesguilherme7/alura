package eti.policarto.herancafuncionario;

public class Gerente extends Funcionario implements Autenticavel {

    private int senha;

    @Override
    public double getBonificacao() {
        return 200;
    }

    @Override
    public void setSenha(int senha){
        this.senha = senha;
    }

    @Override
    public boolean autentica(int senha){
        return this.senha == senha;
    }

}

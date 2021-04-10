package eti.policarto.herancafuncionario;

public class ControleBonificacao {
    private double soma;

    public void registrar(Funcionario funcionario){
        double vlrBonificacao = funcionario.getBonificacao();
        this.soma =+ this.soma + vlrBonificacao;
    }

    public double getSoma() {
        return soma;
    }
}

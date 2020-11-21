package eti.policarto.heranca;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario gerente = new Gerente();
        gerente.setNome("Guilherme Alves");
        gerente.setCpf("13445634589");
        gerente.setSalario(5000.0);

        System.out.println(gerente.getNome());
        System.out.println(gerente.getBonificacao());
    }
}

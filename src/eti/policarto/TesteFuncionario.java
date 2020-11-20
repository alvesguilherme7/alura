package eti.policarto;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Guilherme Alves");
        funcionario.setCpf("13445634589");
        funcionario.setSalario(5000.0);

        System.out.println(funcionario.getNome());
        System.out.println(funcionario.getBonificacao());
    }
}

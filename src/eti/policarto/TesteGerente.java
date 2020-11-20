package eti.policarto;

public class TesteGerente {
    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        gerente.setNome("Thalia Vaz");
        gerente.setCpf("12345612343");
        gerente.setSalario(8000.0);

        System.out.println(gerente.getNome());
        System.out.println(gerente.getCpf());
        System.out.println(gerente.getSalario());

        gerente.setSenha(7865);
        boolean autenticou = gerente.autentica(7865);

        System.out.println(autenticou);
    }
}

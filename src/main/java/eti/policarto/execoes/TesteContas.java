package eti.policarto.execoes;

public class TesteContas {

    public static void main(String[] args) throws SaldoInsuficienteException{

        ContaCorrente cc = new ContaCorrente(111, 111);
        cc.deposita(100.0);

        System.out.println("CC: " + cc.getSaldo());
    }
}
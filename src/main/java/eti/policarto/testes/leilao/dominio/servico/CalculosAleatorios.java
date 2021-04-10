package eti.policarto.testes.leilao.dominio.servico;

public class CalculosAleatorios {

    public int contaAleatoria(int numero) {
        if (numero > 30)
            return numero * 4;
        else if (numero > 10)
            return numero * 3;
        else
            return numero * 2;
    }
}
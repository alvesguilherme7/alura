package eti.policarto.testes.leilao.test.servico;

import eti.policarto.testes.leilao.dominio.servico.Avaliador;
import eti.policarto.testes.leilao.dominio.servico.Lance;
import eti.policarto.testes.leilao.dominio.servico.Leilao;
import eti.policarto.testes.leilao.dominio.servico.Usuario;

import org.junit.Assert;
import org.junit.Test;

public class AvaliadorTest {

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria,250.0));
        leilao.propoe(new Lance(joao,300.0));
        leilao.propoe(new Lance(jose,400.0));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // comparando a saida com o esperado
        double maiorEsperado = 400;
        double menorEsperado = 250;

        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
    }
}

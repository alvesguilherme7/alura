package eti.policarto.testes.leilao.test.servico;

import eti.policarto.testes.leilao.dominio.servico.Avaliador;
import eti.policarto.testes.leilao.dominio.servico.Lance;
import eti.policarto.testes.leilao.dominio.servico.Leilao;
import eti.policarto.testes.leilao.dominio.servico.Usuario;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

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

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void mediaLances(){
        Lance lance1 = new Lance(new Usuario("Carlos"), 10);
        Lance lance2 = new Lance(new Usuario("Rodrigues"), 20);
        Lance lance3 = new Lance(new Usuario("Marina"), 30);

        Leilao leilao = new Leilao("PS5");
        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double mediaEsperada = 20.0;

        assertEquals(mediaEsperada, leiloeiro.getMediaLance(leilao), 0.0001);
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Usuario joao = new Usuario("Joao");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao,1000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void deveEntenderLeilaoComVariosLances() {
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Usuario carlos = new Usuario("Carlos");
        Usuario joana = new Usuario("Joana");
        Usuario cristina = new Usuario("Cristina");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao,200.0));
        leilao.propoe(new Lance(maria,450.0));
        leilao.propoe(new Lance(carlos,120.0));
        leilao.propoe(new Lance(joana,700.0));
        leilao.propoe(new Lance(cristina,630.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(120.0, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void validaLancesCrescente() {
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Usuario carlos = new Usuario("Carlos");
        Usuario joana = new Usuario("Joana");
        Usuario cristina = new Usuario("Cristina");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao,400.0));
        leilao.propoe(new Lance(maria,300.0));
        leilao.propoe(new Lance(carlos,200.0));
        leilao.propoe(new Lance(joana,100.0));
        leilao.propoe(new Lance(cristina,10.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        leilao.ordenaLancesCrescente();

        List<Lance> lances = leilao.getLances();

        assertEquals(5, lances.size());
        assertEquals(10.0, lances.get(0).getValor(), 0.0001);
        assertEquals(100.0, lances.get(1).getValor(), 0.0001);
        assertEquals(200.0, lances.get(2).getValor(), 0.0001);
        assertEquals(300.0, lances.get(3).getValor(), 0.0001);
        assertEquals(400.0, lances.get(4).getValor(), 0.0001);
    }

    @Test
    public void validaTresMaioresLances() {
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Usuario carlos = new Usuario("Carlos");
        Usuario joana = new Usuario("Joana");
        Usuario cristina = new Usuario("Cristina");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao,400.0));
        leilao.propoe(new Lance(maria,300.0));
        leilao.propoe(new Lance(carlos,200.0));
        leilao.propoe(new Lance(joana,100.0));
        leilao.propoe(new Lance(cristina,10.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> tresMaiores = leiloeiro.getTresMaiores();

        assertEquals(3, tresMaiores.size());
        assertEquals(400.0, tresMaiores.get(0).getValor(), 0.0001);
        assertEquals(300.0, tresMaiores.get(1).getValor(), 0.0001);
        assertEquals(200.0, tresMaiores.get(2).getValor(), 0.0001);
    }

    @Test
    public void validaDoisMaioresLances() {
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");
        Usuario carlos = new Usuario("Carlos");
        Usuario joana = new Usuario("Joana");
        Usuario cristina = new Usuario("Cristina");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joana,100.0));
        leilao.propoe(new Lance(cristina,10.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> tresMaiores = leiloeiro.getTresMaiores();

        assertEquals(2, tresMaiores.size());
        assertEquals(100.0, tresMaiores.get(0).getValor(), 0.0001);
        assertEquals(10.0, tresMaiores.get(1).getValor(), 0.0001);
    }

    @Test
    public void validaNenhumMaioresLances() {

        Leilao leilao = new Leilao("Playstation 3 Novo");

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> tresMaiores = leiloeiro.getTresMaiores();

        assertEquals(0, tresMaiores.size());
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverListaVaziaCasoNaoHajaLances() {
        Leilao leilao = new Leilao("Playstation 3 Novo");

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(0, maiores.size());
    }

    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario(){
        Usuario billGates = new Usuario("Bill Gates");

        Leilao leilao = new Leilao("Xbox One");

        leilao.propoe(new Lance(billGates, 300.));
        leilao.propoe(new Lance(billGates, 400.));

        List<Lance> lances = leilao.getLances();

        assertEquals(1, lances.size());
        assertEquals(300.0, lances.get(0).getValor(), 0.00001);
    }

    @Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario(){
        Usuario billGates = new Usuario("Bill Gates");
        Usuario steveJobs = new Usuario("Steve Jobs");

        Leilao leilao = new Leilao("Xbox One");

        leilao.propoe(new Lance(steveJobs, 300.));
        leilao.propoe(new Lance(billGates, 301.));

        leilao.propoe(new Lance(steveJobs, 400.));
        leilao.propoe(new Lance(billGates, 401.));

        leilao.propoe(new Lance(steveJobs, 500.));
        leilao.propoe(new Lance(billGates, 501.));

        leilao.propoe(new Lance(steveJobs, 600.));
        leilao.propoe(new Lance(billGates, 601.));

        leilao.propoe(new Lance(steveJobs, 700.));
        leilao.propoe(new Lance(billGates, 701.));

        // sem lances permitidos
        leilao.propoe(new Lance(steveJobs, 800));

        List<Lance> lances = leilao.getLances();

        assertEquals(10, lances.size());
        assertEquals(701.0, lances.get(9).getValor(), 0.00001);
    }



}

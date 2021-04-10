package eti.policarto.testes.leilao.test.servico;

import eti.policarto.testes.leilao.dominio.servico.Avaliador;
import eti.policarto.testes.leilao.dominio.servico.Lance;
import eti.policarto.testes.leilao.dominio.servico.Leilao;
import eti.policarto.testes.leilao.dominio.servico.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AvaliadorTest {

    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario jose;
    private Usuario maria;
    private Usuario carlos;
    private Usuario joana;
    private Usuario cristina;
    private Usuario billGates;
    private Usuario steveJobs;

    @Before
    public void setUp(){
        this.leiloeiro = new Avaliador();
        this.joao = new Usuario("João");
        this.jose = new Usuario("José");
        this.maria = new Usuario("Maria");
        this.carlos = new Usuario("Carlos");
        this.joana = new Usuario("Joana");
        this.cristina = new Usuario("Cristina");
        this.billGates = new Usuario("Bill Gates");
        this.steveJobs = new Usuario("Steve Jobs");
    }
    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        Leilao leilao = new CriadorLeilao()
                .para("Playstation 3 Novo")
                .lance(maria,250.0)
                .lance(joao,300.0)
                .lance(jose,400.0)
                .concluir();

        leiloeiro.avalia(leilao);

        double maiorEsperado = 400;
        double menorEsperado = 250;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void mediaLances(){
        Leilao leilao = new CriadorLeilao()
                .para("PS5")
                .lance(maria,10.0)
                .lance(joao,20.0)
                .lance(jose,30.0)
                .concluir();

        leiloeiro.avalia(leilao);

        double mediaEsperada = 20.0;

        assertEquals(mediaEsperada, leiloeiro.getMediaLance(leilao), 0.0001);
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Leilao leilao = new CriadorLeilao()
                .para("Playstation 3 Novo")
                .lance(joao,1000.0)
                .concluir();

        leiloeiro.avalia(leilao);

        assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void deveEntenderLeilaoComVariosLances() {
        Leilao leilao = new CriadorLeilao()
                .para("Playstation 3 Novo")
                .lance(joao,200.0)
                .lance(maria,450.0)
                .lance(carlos,120.0)
                .lance(joana,700.0)
                .lance(cristina,630.0)
                .concluir();

        leiloeiro.avalia(leilao);

        assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(120.0, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void validaLancesCrescente() {
        Leilao leilao = new CriadorLeilao()
                .para("Playstation 3 Novo")
                .lance(joao,400.0)
                .lance(maria,300.0)
                .lance(carlos,200.0)
                .lance(joana,100.0)
                .lance(cristina,10.0)
                .ordenar()
                .concluir();
        
        leiloeiro.avalia(leilao);

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
        Leilao leilao = new CriadorLeilao()
                .para("Playstation 3 Novo")
                .lance(joao,400.0)
                .lance(maria,300.0)
                .lance(carlos,200.0)
                .lance(joana,100.0)
                .lance(cristina,10.0)
                .ordenar()
                .concluir();

        leiloeiro.avalia(leilao);

        List<Lance> tresMaiores = leiloeiro.getTresMaiores();

        assertEquals(3, tresMaiores.size());
        assertEquals(400.0, tresMaiores.get(0).getValor(), 0.0001);
        assertEquals(300.0, tresMaiores.get(1).getValor(), 0.0001);
        assertEquals(200.0, tresMaiores.get(2).getValor(), 0.0001);
    }

    @Test
    public void validaDoisMaioresLances() {
        Leilao leilao = new CriadorLeilao()
                .para("Playstation 3 Novo")
                .lance(joana,100.0)
                .lance(cristina,10.0)
                .concluir();

        leiloeiro.avalia(leilao);

        List<Lance> tresMaiores = leiloeiro.getTresMaiores();

        assertEquals(2, tresMaiores.size());
        assertEquals(100.0, tresMaiores.get(0).getValor(), 0.0001);
        assertEquals(10.0, tresMaiores.get(1).getValor(), 0.0001);
    }

    @Test
    public void validaNenhumMaioresLances() {

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leiloeiro.avalia(leilao);

        List<Lance> tresMaiores = leiloeiro.getTresMaiores();

        assertEquals(0, tresMaiores.size());
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Leilao leilao = new CriadorLeilao()
                .para("Playstation 3 Novo")
                .lance(joao,100.0)
                .lance(maria,200.0)
                .lance(joao,300.0)
                .lance(maria,400.0)
                .concluir();
        
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
        Leilao leilao = new CriadorLeilao()
                .para("Playstation 3 Novo")
                .lance(joao,100.0)
                .lance(maria,200.0)
                .concluir();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverListaVaziaCasoNaoHajaLances() {
        Leilao leilao = new Leilao("Playstation 3 Novo");

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
        Leilao leilao = new CriadorLeilao()
                .para("Xbox One")
                .lance(steveJobs,300.0)
                .lance(billGates,301.)
                .lance(steveJobs,400.)
                .lance(billGates,401.)
                .lance(steveJobs,500.)
                .lance(billGates,501.)
                .lance(steveJobs,600.)
                .lance(billGates,601.)
                .lance(steveJobs,700.)
                .lance(billGates,701.)
                .concluir();

        // sem lances permitidos
        leilao.propoe(new Lance(steveJobs, 800));

        List<Lance> lances = leilao.getLances();

        assertEquals(10, lances.size());
        assertEquals(701.0, lances.get(9).getValor(), 0.00001);
    }

    @Test
    public void testeDobraLance(){
        Leilao leilao = new CriadorLeilao()
                .para("Xbox One")
                .lance(steveJobs,300.0)
                .lance(billGates,301.0)
                .concluir();

        leilao.dobraUltimoLance(steveJobs);

        List<Lance> lances = leilao.getLances();

        assertEquals(3, lances.size());
        assertEquals(600.0, lances.get(2).getValor(), 0.00001);

    }

    @Test(expected = RuntimeException.class)
    public void naoDeveAceitarAvaliarSemLances(){
        Leilao leilao = new CriadorLeilao()
                .para("Xbox One")
                .concluir();
        leiloeiro.avalia(leilao);
    }



}

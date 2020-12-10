package eti.policarto.testes.leilao.test.servico;

import eti.policarto.testes.leilao.dominio.servico.AnoBissexto;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;


public class AnoBissextoTest {

    @Test
    public void validaBissextoVerdadeiro(){
        AnoBissexto anoBissexto = new AnoBissexto();
        boolean ehBissexto = anoBissexto.ehBissexto(2020);
        assertTrue(ehBissexto);
    }

    @Test
    public void validaBissextoFalso(){
        AnoBissexto anoBissexto = new AnoBissexto();
        boolean ehBissexto = anoBissexto.ehBissexto(2021);
        assertFalse(ehBissexto);
    }

    @Test
    public void validaBissexto100Falso(){
        AnoBissexto anoBissexto = new AnoBissexto();
        boolean ehBissexto = anoBissexto.ehBissexto(2100);
        assertFalse(ehBissexto);
    }

    @Test
    public void validaBissexto400Verdadeiro(){
        AnoBissexto anoBissexto = new AnoBissexto();
        boolean ehBissexto = anoBissexto.ehBissexto(2400);
        assertTrue(ehBissexto);
    }

}
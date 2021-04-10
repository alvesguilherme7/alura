package eti.policarto.testes.leilao.test.servico;

import eti.policarto.testes.leilao.dominio.servico.CalculosAleatorios;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculosAleatoriosTest {

    @Test
    public void contaAleatoriaTesteMaiorTrinta() {
        CalculosAleatorios calculosAleatorios = new CalculosAleatorios();
        int esperado = 128;
        assertEquals(esperado,calculosAleatorios.contaAleatoria(32),0.0001);
    }

    @Test
    public void contaAleatoriaTesteMaiorDez() {
        CalculosAleatorios calculosAleatorios = new CalculosAleatorios();
        int esperado = 36;
        assertEquals(esperado,calculosAleatorios.contaAleatoria(12),0.0001);
    }

    @Test
    public void contaAleatoriaTesteMenorDez() {
        CalculosAleatorios calculosAleatorios = new CalculosAleatorios();
        int esperado = 12;
        assertEquals(esperado,calculosAleatorios.contaAleatoria(6),0.0001);
    }

}

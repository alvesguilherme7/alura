package eti.policarto.testes.leilao.dominio.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private List<Lance> maiores;

    public void avalia(Leilao leilao) {

        if(leilao.getLances().isEmpty())
            throw new RuntimeException("Sem lances para avaliar.");

        for(Lance lance : leilao.getLances()) {
            if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
            if (lance.getValor() < menorDeTodos) menorDeTodos = lance.getValor();
        }

        pegaOsMaioresNo(leilao);
    }

    private void pegaOsMaioresNo(Leilao leilao) {
        maiores = new ArrayList<>(leilao.getLances());
        maiores.sort((o1, o2) -> Double.compare(o2.getValor(), o1.getValor()));
        maiores = maiores.subList(0, Math.min(maiores.size(), 3));
    }

    public List<Lance> getTresMaiores() {
        return this.maiores;
    }

    public double getMaiorLance() { return maiorDeTodos; }
    public double getMenorLance() { return menorDeTodos; }
    public double getMediaLance(Leilao leilao) {
        return
            leilao
            .getLances()
            .stream()
            .mapToDouble(Lance::getValor)
            .average()
            .orElse(0.0);
    }
}

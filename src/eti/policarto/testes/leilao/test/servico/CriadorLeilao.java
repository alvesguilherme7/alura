package eti.policarto.testes.leilao.test.servico;

import eti.policarto.testes.leilao.dominio.servico.Lance;
import eti.policarto.testes.leilao.dominio.servico.Leilao;
import eti.policarto.testes.leilao.dominio.servico.Usuario;

public class CriadorLeilao {
    private Leilao leilao;

    public CriadorLeilao para(String produto){
        leilao = new Leilao(produto);
        return this;
    }

    public CriadorLeilao lance(Usuario usuario, Double valor){
        leilao.propoe(new Lance(usuario, valor));
        return this;
    }

    public CriadorLeilao ordenar(){
        leilao.ordenaLancesCrescente();
        return this;
    }

    public Leilao concluir(){
        return leilao;
    }

}

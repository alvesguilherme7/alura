package eti.policarto.testes.leilao.dominio.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		Usuario usuLanceAtual = lance.getUsuario();
		boolean podeDarLance = lances.isEmpty() ||
				( aindaTemLancePara(usuLanceAtual) && !ultimoLanceDo(usuLanceAtual) );
		if(podeDarLance)
			lances.add(lance);
	}

	private boolean aindaTemLancePara(Usuario usuLanceAtual) {
		return lances
				.stream()
				.map(Lance::getUsuario)
				.filter(usuLanceAtual::equals)
				.count() <= 4;
	}

	private boolean ultimoLanceDo(Usuario usuario) {
		return lances.get(lances.size() - 1).getUsuario().equals(usuario);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public void ordenaLancesCrescente() {
		lances.sort(Comparator.comparingDouble(Lance::getValor));
	}

	
	
}

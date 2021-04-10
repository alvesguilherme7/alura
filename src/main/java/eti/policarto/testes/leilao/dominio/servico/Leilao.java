package eti.policarto.testes.leilao.dominio.servico;

import java.util.*;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {
		if(podeDarLance(lance.getUsuario()))
			lances.add(lance);
	}

	public void dobraUltimoLance(Usuario usuario){
		Optional<Lance> lance = this.getLastLanceDo(usuario);

		lance.ifPresent( ultimoLance -> {
			Lance lanceEmDobro = new Lance(usuario, lance.get().getValor() * 2);
			this.propoe(lanceEmDobro);
		});
	}


	private Optional<Lance> getLastLanceDo(Usuario usuario) {
		return lances
				.stream()
				.skip(countLancesPor(usuario) - 1)
				.findFirst();
	}

	private long countLancesPor(Usuario usuario) {
		return lances
				.stream()
				.map(Lance::getUsuario)
				.filter(usuario::equals)
				.count();
	}

	public void ordenaLancesCrescente() {
		lances.sort(Comparator.comparingDouble(Lance::getValor));
	}

	private boolean podeDarLance(Usuario usuLanceAtual) {
		return lances.isEmpty() ||
				(aindaTemLancePara(usuLanceAtual) && !ultimoLanceDo(usuLanceAtual));
	}

	private boolean aindaTemLancePara(Usuario usuLanceAtual) {
		return countLancesPor(usuLanceAtual) <= 4;
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

	
	
}

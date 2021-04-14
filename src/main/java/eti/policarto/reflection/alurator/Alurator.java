package eti.policarto.reflection.alurator;

import eti.policarto.reflection.alurator.protocolo.Request;
import eti.policarto.reflection.alurator.reflexao.Reflexao;

public class Alurator {
	
	private final String PACOTEBASE;

	public Alurator(String pacoteBase) {
		this.PACOTEBASE = pacoteBase;
	}
	
	public Object executa(String url) {

		String nomeControle = new Request(url).getNomeControle();

		Object instanciaControle = new Reflexao()
				.refletirClasse(this.PACOTEBASE + nomeControle)
				.getConstrutorPadrao()
				.instanciar();

		System.out.println(instanciaControle);

		return instanciaControle;
	}
}

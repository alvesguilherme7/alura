package eti.policarto.banco.test;

import eti.policarto.banco.modelo.Conta;
import eti.policarto.banco.modelo.ContaCorrente;
import eti.policarto.banco.modelo.GuardadorDeReferencias;

public class TesteGuardadorReferencias {

	public static void main(String[] args) {
		
		GuardadorDeReferencias guardador = new GuardadorDeReferencias();
		
		Conta cc = new ContaCorrente(22, 11);
		guardador.adiciona(cc);

		Conta cc2 = new ContaCorrente(22, 22);
		guardador.adiciona(cc2);
		
		int tamanho = guardador.getQuantidadeDeElementos();
		System.out.println(tamanho);
		
		Conta ref = (Conta) guardador.getReferencia(1);
		System.out.println(ref.getNumero());
		
	}

}

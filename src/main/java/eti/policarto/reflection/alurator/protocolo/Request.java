package eti.policarto.reflection.alurator.protocolo;

public class Request {

	private final String nomeControle;

	public Request(String url) {
		// ex.: /produto/lista
		String[] partesUrl = url.replaceFirst("/", "")
								.split("/");
		this.nomeControle =
				primeiraLetraMaiscula(partesUrl[0]) + retirarPrimeiraLetra(partesUrl[0]) + "Controller";
	}

	private String retirarPrimeiraLetra(String s) {
		return s.substring(1);
	}

	private char primeiraLetraMaiscula(String s) {
		return Character.toUpperCase(s.charAt(0));
	}

	public String getNomeControle() {
		return nomeControle;
	}
}

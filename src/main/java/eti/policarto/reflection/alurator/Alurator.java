package eti.policarto.reflection.alurator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Alurator {
	
	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}
	
	public Object executa(String url) {
		// TODO - processa a requisicao executando o metodo
		// da classe em questao
		
		// Produto lista
		
		// produto -> roduto
		
		String[] partesUrl = url.replaceFirst("/", "")
								.split("/");
		
		String nomeControle = Character.toUpperCase(partesUrl[0].charAt(0)) + 
								partesUrl[0].substring(1) + "Controller";
		
		try {
			Class<?> classeControle = Class.forName(pacoteBase + nomeControle);

			Constructor<?> constructor = classeControle.getConstructor();

			Object instanciaControle = constructor.newInstance();
			
			System.out.println(instanciaControle);
			
			return null;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException e ) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (InvocationTargetException e){
			e.printStackTrace();
			throw new RuntimeException("Erro no construtor.", e.getTargetException());
		}
	}
}

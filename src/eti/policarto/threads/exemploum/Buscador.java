package eti.policarto.threads.exemploum;

import java.io.File;
import java.util.Scanner;

public class Buscador implements Runnable {

    private final String filename;
    private final String termoBusca;
    private final String PATH = "C:\\Users\\Guilherme Alves\\pessoal\\alura-java-base\\src\\eti\\policarto\\threads\\files";

    public Buscador(String filename, String termoBusca) {
        this.filename = filename.toLowerCase();
        this.termoBusca = termoBusca.toLowerCase();
    }

    public void buscar() throws Exception {
        try(Scanner scanner = new Scanner(new File(String.format("%s\\%s", this.PATH, this.filename)))){
            int contLinha = 1;
            while (scanner.hasNext()){
                String linha = scanner.nextLine();
                if(linha.toLowerCase().contains(this.termoBusca))
                    System.out.println("Arquivo: "+ this.filename +" Linha: "+contLinha + " -> " +linha);
                contLinha++;
            }
        }
    }

    @Override
    public void run() {
        try{
            buscar();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

package eti.policarto.io;

import java.io.*;

public class Main {
    private static final String PATH = "C:\\Users\\Guilherme Alves\\pessoal\\alura\\src\\eti\\policarto\\io\\";

    public static void main(String[] args) throws IOException {

        System.out.println("--- InputStream e OutputStream ---");

        InputStream fis = new FileInputStream(String.format("%smodelo.txt", PATH));
        InputStreamReader isr = new InputStreamReader(fis);

        OutputStream fos = new FileOutputStream(String.format("%ssaida1.txt", PATH));
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        try(BufferedReader br = new BufferedReader(isr)){
            try(BufferedWriter bw = new BufferedWriter(osw)){

                String linha = br.readLine();
                while (linha != null && !linha.isEmpty()) {
                    bw.write(linha);
                    bw.newLine();
                    linha = br.readLine();
                }

            }
        }
        System.out.println("--- PrintStream ---");

        try(PrintStream printStream = new PrintStream(String.format("%ssaida2.txt", PATH))){
            printStream.println("Outra saída mais simples.");
        }

    }
}

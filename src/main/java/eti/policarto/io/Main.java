package eti.policarto.io;

import java.io.*;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    private static final String PATH = "C:\\Users\\Guilherme Alves\\pessoal\\alura\\src\\eti\\policarto\\io\\";

    public static void main(String[] args) throws IOException {

        System.out.println("--- InputStream e OutputStream ---");

        long ini = System.currentTimeMillis();

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
        System.out.println("Processado.\n--- PrintStream ---");

        try(PrintStream printStream = new PrintStream(String.format("%ssaida2.txt", PATH))){
            printStream.println("Outra saída mais simples.");
        }

        System.out.println("Processado.\n--- Scanner ---");

        try(Scanner scanner = new Scanner(new File(String.format("%scontas.csv",PATH)))){
            while (scanner.hasNext())
                System.out.println(scanner.nextLine());
        }

        System.out.println("Processado.\n--- Properties ---");

        Properties props = new Properties();
        props.setProperty("login", "alura"); //chave, valor
        props.setProperty("senha", "alurapass");
        props.setProperty("endereco", "www.alura.com.br");

        props.store(new FileWriter("conf.properties"), "algum comentário");

        props = new Properties();
        props.load(new FileReader("conf.properties"));

        String login = props.getProperty("login");
        String senha = props.getProperty("senha");
        String endereco = props.getProperty("endereco");

        System.out.printf("%s/%s/%s%n",login,senha,endereco);

        long fin = System.currentTimeMillis();

        System.out.printf(new Locale("pt","BR"),"Tempo de execução: %s milisegundos.", (fin - ini) );

    }
}

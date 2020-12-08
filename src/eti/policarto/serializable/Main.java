package eti.policarto.serializable;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String path = "C:\\Users\\Guilherme Alves\\pessoal\\alura\\src\\eti\\policarto\\serializable\\pessoa.bin";

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Guilherme Alves");
        pessoa.setIdade(24);

        Identidade id = new Identidade();
        id.setNumero("89756");
        id.setOrgaoEmissor("SSP");
        pessoa.setIdentidade(id);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(pessoa);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        pessoa = (Pessoa) ois.readObject();
        ois.close();

        System.out.println(pessoa);

        /*
            A atributo identidade não é serializavel, portanto, não é exprotado no objeto.
         */
    }
}

package eti.policarto.reflection.alurator.reflexao;

public class Reflexao {

    public static ManipuladorClasse refletirClasse(String fqn) {
        try {
            Class<?> aClass = Class.forName(fqn);
            return new ManipuladorClasse(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

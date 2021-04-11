package eti.policarto.reflection.geral.reflexao;

public class UsoDinamicoClass {

    public static final String PATH_MODEL = "eti.policarto.reflection.geral.model";

    public static void main(String[] args) throws Exception {
        final String URL = "/controle/lista";
        run(URL);
    }

    private static void run(String URL) throws Exception {
        String[] destino = URL.replaceFirst("/", "").split("/");
        String nameClass = Character.toUpperCase(destino[0].charAt(0)) + destino[0].substring(1);
        Class<?> aClass = Class.forName(String.format("%s.%s", PATH_MODEL, nameClass));
        Object o = aClass.newInstance();
        System.out.println(o);
    }
}

package eti.policarto.reflection.reflexao;

import eti.policarto.reflection.model.Controle;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 3 formas de obter o objeto Class parametrizado
        Class<Controle> controleClass1 = Controle.class;

        Class<? extends Controle> controleClass2 = new Controle().getClass();

        Class<?> controleClass3 = Class.forName("eti.policarto.reflection.model.Controle");

        // Depois disso, você pode usar de forma parametrizada ou não, dependendo do passo anterior

        // parametrizado retorna o objeto Controle diretamente
        Controle controleParametrizado1  = controleClass1.newInstance();
        Controle controleParametrizado2  = controleClass2.newInstance();
        Object   controleNaoParametrizdo = controleClass3.newInstance();

        Controle controleParametrizado3;
        if(controleNaoParametrizdo instanceof Controle) controleParametrizado3 = (Controle) controleNaoParametrizdo;

        controleParametrizado1.print(" Esse metódo pertence a classe Controle. ");
    }
}

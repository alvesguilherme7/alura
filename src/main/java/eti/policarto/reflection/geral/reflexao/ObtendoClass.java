package eti.policarto.reflection.geral.reflexao;

import eti.policarto.reflection.geral.model.Controle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObtendoClass {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 3 formas de obter o objeto Class parametrizado
        Class<Controle> controleClass1 = Controle.class;

        Class<? extends Controle> controleClass2 = new Controle().getClass();

        Class<?> controleClass3 = Class.forName("eti.policarto.reflection.geral.model.Controle");

        // Depois disso, você pode usar de forma parametrizada ou não, dependendo do passo anterior

        // parametrizado retorna o objeto Controle diretamente
        Controle controleParametrizado1  = controleClass1.newInstance();
        Controle controle = controleClass2.newInstance();
        Object   controleNaoParametrizdo = controleClass3.newInstance();

        Controle controleParametrizado3;
        if(controleNaoParametrizdo instanceof Controle) controleParametrizado3 = (Controle) controleNaoParametrizdo;

        controleParametrizado1.print(" Esse metódo pertence a classe controle. ");

        // apartir do Java 9, a forma correta de se instanciar e invocar metódos é
        Constructor<Controle> constructors = controleClass1.getConstructor();
        System.out.println(constructors);
        Controle instancia = constructors.newInstance();
        System.out.println(instancia);
        instancia.print(" Invocando metódo da instância recém criada. ");
    }
}

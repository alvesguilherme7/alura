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
        Controle parametrizado1  = controleClass1.newInstance();
        Controle parametrizado2  = controleClass2.newInstance();
        Object   generico1       = controleClass3.newInstance();

        Controle parametrizado3;
        if(generico1 instanceof Controle) parametrizado3 = (Controle) generico1;

        parametrizado1.print(" Esse metódo pertence a classe controle. ");

        // Apartir do Java 9, a forma correta de se construir um objeto e invocar metódos é através do Constructor.
        // Ele consegue avisar de possíveis exceções em tempo de escrita/compilação.
        Constructor<Controle> constructor1 = controleClass1.getConstructor();
        // defina os tipos dos parametros da sobrecarga desejada
        Constructor<Controle> constructor2 = controleClass1.getConstructor(String.class);

        // O getDeclaredConstructor é capaz de buscar construtores privados
        Constructor<Controle> constructor3 = controleClass1.getDeclaredConstructor(String.class, Integer.class);
        Constructor<?>[] arrayConstructos4 = controleClass1.getDeclaredConstructors();
        for (Constructor<?> c : arrayConstructos4) {
            System.out.println("Contrutor: "+c.getModifiers()+" - "+c.getName());
        }

        Controle controle1 = constructor1.newInstance();
        Controle controle2 = constructor2.newInstance("Mensagem Incial.");
        controle1.print();
        controle2.print();

    }
}

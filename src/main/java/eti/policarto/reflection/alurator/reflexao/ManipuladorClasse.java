package eti.policarto.reflection.alurator.reflexao;

import java.lang.reflect.Constructor;

public class ManipuladorClasse {

    private final Class<?> aClass;

    public ManipuladorClasse(Class<?> aClass) {
        this.aClass = aClass;
    }

    public ManipuladorConstrutor getConstrutorPadrao() {
        try {
            Constructor<?> constructor = aClass.getConstructor();
            return new ManipuladorConstrutor(constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package eti.policarto.reflection.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ManipuladorConstrutor {
    private final Constructor<?> constructor;

    public ManipuladorConstrutor(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public Object instanciar() {
        try {
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao contruir contralador. "+e.getTargetException());
        }
        return null;
    }
}

package eti.policarto.arrays.curso;

public class TestaCurso {
    public static void main(String[] args) {
        Curso curso = new Curso("Java", "Carlos Drummond");
        curso.addAula(new Aula("ArrayList",30));
        curso.addAula(new Aula("LinkedList",40));
        System.out.println(Curso.getTempoTotalStatic(curso));
        System.out.println(curso.getTempoTotal());
    }
}

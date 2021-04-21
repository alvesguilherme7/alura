package eti.policarto.oca.i.tiposdados;

public class Primitivos {
    public static void main(String[] args) {

        /*
         * Tipos de dados primitivos e seus tamanhos
         */

        /* 1 Byte -> 8 bits */
        byte byteMinimo = -128;
        byte byteMaximo =  127;

        /* 2 Bytes -> 16 bits */
        short shortMinimo = -32_768;
        short shortMaximo =  32_767;

        /* 2 Bytes -> 16 bits, Porém, somente positivos, ao contrário do short */
        char charMinimo = 0;
        char charMaximo = 65_535;

        /* 4 Bytes -> 32 bits */
        int intMinimo = -2_147_483_648;
        int intMaximo =  2_147_483_647;

        /*
          8 Bytes -> 64 bits
          É necessário deixar claro para o compilador
          que o tipo é um long e não um Int. Para isso, use a letra L no final do número.
        */
        long longMinimo = -9_223_372_036_854_775_808L;
        long longMaximo =  9_223_372_036_854_775_807L;

        /*
            4 Bytes -> 32 bits
            Precisão de 7 casas decimais no máximo.
            Também é necessária deixar claro que é um Float.
            O Compilador tenta imputar como Double.
         */
        float floatMinimo = -3.4028E38F;
        float floatMaximo =  3.4028E37F;

        /*
            8 Bytes -> 64 bits
            Precisão de 15 casas decimais no máximo.
         */
        double doubleMinimo = -1.7976E308;
        double doubleMaximo =  1.7976E308;


        /*
         * As bases suportadas em números inteiros
         */

        int decimal = 10;
        int octal = 012;// 012 -> 10
        int hexadecimal = 0xA;// A -> 10
        int binaria = 0b1010;// 0b1010 = 10;

        /*
            Para cada tipo primitivo, existe os chamados Wrappers.
            São literalmente embrulhos dos tipos primitivos.
            Eles foram feitos para trabalhar melhor com OO, já que tipos primitivos não são objetos.
            Antigamente, havia uma perda de performance, mas hoje em dia, isso não é mais um problema.
            Ainda sim, talvez por costume, os tipos primitivos são muito usados nos programas Java.
         */

        Integer wrapperIntBinario = 0b1010;
    }
}

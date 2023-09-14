package IntroducaoMetodos.testes;

import IntroducaoMetodos.classes.Calculadora;

public class CalculadoraTeste {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        int[] arrayGrande = new int[100000000];


        for(int i=0; i< arrayGrande.length; i++){
            arrayGrande[i] = i*10;
        }


        int num1 = 5;
        int num2 = 10;
        calculadora.alteraDoisNumeros(num1, num2);
        System.out.println(num1);
        System.out.println(num2);

    }


}

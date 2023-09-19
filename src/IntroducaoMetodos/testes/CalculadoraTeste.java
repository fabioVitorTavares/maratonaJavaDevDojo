package IntroducaoMetodos.testes;

import IntroducaoMetodos.classes.Calculadora;

public class CalculadoraTeste {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        int[] arrayGrande = new int[100000000];


        for(int i=0; i< arrayGrande.length; i++){
            arrayGrande[i] = i*10;
        }



        int[] numeros = {1,2,3,4};

//        calculadora.somaNumeros(numeros);
        calculadora.somaNumeros(4,5,2,5,3);
    }


}

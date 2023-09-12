package IntroducaoMetodos.testes;

import IntroducaoMetodos.classes.Calculadora;

public class CalculadoraTeste {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
//
//        calculadora.soma(8+9, 8);
//
//
//        calculadora.subtrai(9,8);
//
//
//
//

        int[] arrayGrande = new int[100000000];


        for(int i=0; i< arrayGrande.length; i++){
            arrayGrande[i] = i*10;
        }

        calculadora.somaArray(arrayGrande);
    }
}

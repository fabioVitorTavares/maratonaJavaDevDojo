package IntroducaoMetodos.classes;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Calculadora {

    public void soma(double numero1, double numero2){
        System.out.println(numero1 + numero2);
    }

    public  void subtrai(double numero1, double numero2){
        System.out.println(numero1 - numero2);
    }

    public void somaArray(int[] array){

        long time = System.currentTimeMillis();
       int soma = 0;

        for (int valor: array){
            soma+= valor;
        }
        long timeCorrido = System.currentTimeMillis() - time;
        System.out.println(soma + " Executado em : " + timeCorrido + "ms");

        long time2 = System.currentTimeMillis();
        int soma2 = Arrays.stream(array).reduce(0, (s,e) -> s+e);
        long timeCorrido2 = System.currentTimeMillis() - time2;

        System.out.println(soma2 + " Executado em : " + timeCorrido + "ms");

    }
}

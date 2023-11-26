package Threads.teste;

import Threads.teste.ThreadClasses.Conta;

public class ContaTest implements Runnable{

    private Conta conta = new Conta();

    public static void main(String[] args) {
        ContaTest contaTest = new ContaTest();
        Thread fabio = new Thread(contaTest, "Fabio");
        Thread  ze = new Thread(contaTest, "Zé");
        fabio.start();
        ze.start();
    }
    
    private synchronized void saque(int valor){
        if(conta.getSaldo() >= valor){
            System.out.println(Thread.currentThread().getName() + " está indo sacar!");
            conta.saque(valor);
            System.out.println(Thread.currentThread().getName() + " completou o saque! Saldo: " + conta.getSaldo());
        }
        else{
            System.out.println(Thread.currentThread().getName() + " Sem dinheito para efetuar o saque! Saldo: " + conta.getSaldo());
        }
    }
    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            saque(10);
            if(conta.getSaldo() < 0){
                System.out.println("Conta zerada!");
            }
        }
    }
}

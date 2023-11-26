package Threads.teste.ThreadClasses;

public class Conta {
    private int saldo = 50;

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void  saque(int valor){
        saldo = saldo - valor;
    }


}

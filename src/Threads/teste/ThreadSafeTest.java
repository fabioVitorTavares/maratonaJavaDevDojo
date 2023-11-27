package Threads.teste;


import java.util.*;

class  ListaNomes {
    private List<String> nomes = Collections.synchronizedList(new LinkedList<>());

    public  void add(String nome){
        nomes.add(nome);
    }

    public  void  removerPrimeiro(){
        if(!nomes.isEmpty()){
            System.out.println(nomes.remove(0));
        }
    }
}
public class ThreadSafeTest {
    public static void main(String[] args) {
        ListaNomes nomes = new ListaNomes();
        nomes.add("Fabio");

        class RemovedorDeNomes extends Thread {
            public void run(){
                nomes.removerPrimeiro();
            }
        }

        new RemovedorDeNomes().start();
        new RemovedorDeNomes().start();
    }
}

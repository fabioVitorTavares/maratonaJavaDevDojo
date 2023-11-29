package Concurrent;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

public class LockTest {
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        new Thread(new Worker("A", lock)).start();
        new Thread(new Worker("B", lock)).start();
        new Thread(new Worker("C", lock)).start();
        new Thread(new Worker("D", lock)).start();
        new Thread(new Worker("E", lock)).start();
        new Thread(new Worker("F", lock)).start();
        new Thread(new Worker("G", lock)).start();
    }

    static class Worker implements Runnable{
        private String nome;
        private ReentrantLock reentrantLock;

        public Worker(String nome, ReentrantLock reentrantLock) {
            this.nome = nome;
            this.reentrantLock = reentrantLock;
        }

        @Override
        public void run(){
            reentrantLock.lock();
            try {
                if(reentrantLock.isHeldByCurrentThread()){
                    System.out.printf("Thread %s entrou em uma sessão crítica%n", nome);
                }
                out.printf("%s Threads esperando na fina%n", reentrantLock.getQueueLength());
                out.printf("Thread %s vai trabalhar por 2 segundos%n", nome);
                Thread.sleep(2000);
            }catch (Exception e){
                out.println(e.getMessage());;
            }
            finally {
                reentrantLock.unlock();
            }
        }
    }
}

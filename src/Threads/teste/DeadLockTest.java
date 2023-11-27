package Threads.teste;

public class DeadLockTest {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    private static  class ThreadLock1 extends Thread {
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 1: Segurando lock 1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 1: Esperando pelo lock 2");
                synchronized (lock2){
                    System.out.println("Thread  1 segurando lock 1 e 2");
                }
            }
        }
    }

    private static  class ThreadLock2 extends Thread {
        public void run(){
            synchronized (lock2){

                System.out.println("Thread 2: Segurando lock 2");
                System.out.println("Thread 2: Esperando pelo lock 1");
                synchronized (lock1){
                    System.out.println("Thread  2 segurando lock 1 e 2");
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadLock1().start();
        new ThreadLock2().start();
        System.out.println(Thread.currentThread().getName());

    }
}

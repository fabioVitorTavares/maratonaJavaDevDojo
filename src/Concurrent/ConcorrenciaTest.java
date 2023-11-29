package Concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

class Contador{
    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private Lock lock = new ReentrantLock();
    public  void increment(){
        lock.lock();
        out.println(lock);
        try {
            count++;
            atomicInteger.getAndIncrement();
        }
        finally {
            lock.unlock();
        }
    }

    public int getCount(){
        return this.count;
    }

    public int getAtomic(){
        return atomicInteger.intValue();
    }
}

class IncrementThread extends Thread{
    private  Contador contador;

    public IncrementThread(Contador contador){
        this.contador = contador;
    }

    public void run(){
        for (int i = 0; i < 10000; i++) {
            contador.increment();
        }
    }
}
public class ConcorrenciaTest {
    public static void main(String[] args) {
        try {
            Contador c = new Contador();
            IncrementThread t1 = new IncrementThread(c);
            IncrementThread t2 = new IncrementThread(c);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            out.println(c.getCount());
            out.println(c.getAtomic());
        }catch (Exception e){
            out.println(e.getMessage());

        }
    }
}

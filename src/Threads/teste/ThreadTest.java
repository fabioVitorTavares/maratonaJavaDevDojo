package Threads.teste;


// Threads Daemon
// Threads User

class ThreadExemplo extends  Thread{
    private  char c;

    public ThreadExemplo(char c) {
        this.c = c;
    }

    @Override
    public void run(){
        System.out.println("\n\nThread executando " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++){
            System.out.print(c);
            if(i % 100 == 0){
                System.out.println();
            }
        }
        System.out.println("\n\n");
    };
}

class ThreadRunnable implements Runnable{
    private  char c;

    public ThreadRunnable(char c) {
        this.c = c;
    }

    @Override
    public void run(){
        if(c == 'A'){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("\n\nThread executando " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++){
            System.out.print(c);
            if(i % 100 == 0){
                System.out.println();
            }
        }
        System.out.println("\n\n");
    }


}
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());
//        ThreadExemplo t1 = new ThreadExemplo('A');
//        ThreadExemplo t2 = new ThreadExemplo('B');
//        ThreadExemplo t3 = new ThreadExemplo('C');
//        ThreadExemplo t4 = new ThreadExemplo('D');
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//
            Thread t1 = new Thread(new ThreadRunnable('A'));
            Thread t2 = new Thread(new ThreadRunnable('B'));
            t1.start();
//            t1.join();
            t2.start();

//        Thread.sleep(5000); // Faz a thread dormir por 5s
//        Thread.yield(); // Faz a thread em execução voltar para o estado de runnable
//        for(int i=0; i<1000; i++){
//            System.out.println(i);
//            if(i  % 100 == 0){
//                Thread.sleep(1000);
//            }
//        }
    }
}

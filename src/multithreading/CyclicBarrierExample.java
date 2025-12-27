package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int noOfSubSystem = 4;
        CyclicBarrier barrier = new CyclicBarrier(noOfSubSystem, new Runnable() {
            @Override
            public void run() {
                System.out.println("All sub system are up and running. System startup complete.");
            }
        });


        Thread webServerThread = new Thread(new SubSystem("Web Server", 2000, barrier));
        Thread databaseThread = new Thread(new SubSystem("Database", 4000, barrier));
        Thread cacheThread = new Thread(new SubSystem("Cache", 3000, barrier));
        Thread messagingSeriveThread = new Thread(new SubSystem("Messaging Service", 3500, barrier));

        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingSeriveThread.start();
    }
}
 // search for matrix multiplication cyclic barrier
class SubSystem implements Runnable{

    private String name;
    private int initializationTime;
    private CyclicBarrier barrier;

    SubSystem(String name, int initializationTime, CyclicBarrier barrier){
        this.name = name;
        this.initializationTime = initializationTime;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try{
            System.out.println(name + " initialization started.");
            Thread.sleep(initializationTime);
            System.out.println(name + " initialization time.");
            barrier.await();
        } catch(InterruptedException | BrokenBarrierException e){
            throw new RuntimeException(e);
        }
    }
}

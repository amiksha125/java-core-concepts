package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarierExample {
    public static void main(String[] args) {
        //replace CountDownLatch with CyclicBarier, and there is no countDown() function
        // It does not block main thread
        int services = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(services);
        CyclicBarrier barrier = new CyclicBarrier(services);

        executorService.submit(new DependentService2(barrier));
        executorService.submit(new DependentService2(barrier));
        executorService.submit(new DependentService2(barrier));
        // All these threads will wait at a point(barrier) until last thread comes, all the threads are released
        // You are waiting for your friends on the theatre entrance for the movie

        System.out.println("Main");

        barrier.reset();
        System.out.println(barrier.getParties()); // Returns the number of parties required to trip this barrier.
        // trip means meeting at the barrier point
        executorService.shutdown();
    }
}

class DependentService2 implements Callable<String> {

    private final CyclicBarrier barrier; // final : can be assigned only once

    DependentService2(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        try{;
            System.out.println(Thread.currentThread().getName() + " service started.");
            Thread.sleep(6000);
            System.out.println(Thread.currentThread().getName() + " is waiting at a barrier");
            barrier.await(); // each worker thread waits until the last thread arrives
        } finally {
            System.out.println("finished");
        }
        return "ok";
    }
}

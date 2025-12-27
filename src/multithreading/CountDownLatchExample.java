package multithreading;

import java.util.concurrent.*;

public class CountDownLatchExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        Future<String> submit1 = executorService.submit(new DependentService());
//        Future<String> submit2 = executorService.submit(new DependentService());
//        Future<String> submit3 = executorService.submit(new DependentService());
//
//        submit1.get();
//        submit2.get();
//        submit3.get();

//        System.out.println("All dependent service finished. Starting main service...");
//        executorService.shutdown();

        // This is a tedious task, creating each future and calling get(), we want our main thread to wait,
        // we can user invokeAll() but it is going to be lengthy.
        // Make use of CountDownLatch
//        It is used to make one or more thread wait for completion of some tasks
        //It takes the no of threads we need as input in constructor

        int numberOfService = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfService);
        CountDownLatch latch = new CountDownLatch(numberOfService);
        // latch will maintain a countdown based on no of service and if it becomes 0 then it unlocks main thread
        // latch needs to be passed to DependentService
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        // change the sleep() time to 2 sec, then all te task will be printed after main as they are already finished
        // for 6 sec they will be terminated by shutdownNow after main

        // If runnable used
//        for(int i = 0; i < numberOfService; i++){
//            new Thread(new DependentServiceRun(latch)).start();
//        }
        latch.await(5, TimeUnit.SECONDS); // wait for 5 sec and start main
        // and if you do shotDownNow() it will not wait for worker thread execution after Main thread

        System.out.println("Main");
        executorService.shutdownNow();

        // use countDownLatch when you have to make main thread wait for multiple threads
        // It is not reusable, once the count reaches 0 it cannot be reset to use again
        // to reuse CountDownLatch, use Cyclic Barrier

    }
}

class DependentService implements Callable<String>{

    private final CountDownLatch latch; // final : can be assigned only once

    DependentService(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try{
            Thread.sleep(6000);
            System.out.println(Thread.currentThread().getName() + " service started.");
        } finally {
            latch.countDown();
        }
        return "ok";
    }
}

class DependentServiceRun implements Runnable{

    private final CountDownLatch latch; // final : can be assigned only once

    DependentServiceRun(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(6000);
            System.out.println(Thread.currentThread().getName() + " service started.");
        } catch(Exception e){

        }finally{
            latch.countDown();
        }
    }
}

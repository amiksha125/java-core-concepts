package multithreading.executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) {
        // let us use executor framework for more efficiency
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        // Executors.newSingleThreadExecutor(); for one thread
        for(int i = 1; i < 10; i++){
            int finalI = i;
            executorService.submit( () -> {
                long result = factorial(finalI);
                System.out.println(finalI +" = "+ result);
            });
        }

        executorService.shutdown(); // final time will be printed first, main thread will not wait for executor shutdown to make it :

//        try {
//            // blocks the current main thread execution and waits for 10sec for executor to complete its task.
//            executorService.awaitTermination(10, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        // awaitedTermination returns true if executor terminate , make main thread wait for executor unlimitedly :
        //nd false if the timeout elapsed before termination
        while (true) {
            try {
                if (executorService.awaitTermination(10, TimeUnit.MILLISECONDS)) {
                    break; // executor finished → exit loop
                }
                System.out.println("Waiting..");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime));


    }

    private static long factorial(int n){
        //suppose calculating factorial is very difficult task that it takes 1 sec
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for(int i = 1; i <= n ; i++){
            result *= i;
        }
        return result;
    }
}

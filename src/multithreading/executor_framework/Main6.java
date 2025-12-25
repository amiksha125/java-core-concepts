package multithreading.executor_framework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main6 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
        List<Future<Integer>> futures = executorService.invokeAll(list, 1, TimeUnit.SECONDS);
        // invokeAll waits only 1 second
       // 2 threads execute task1 and task2
       // task3 does not start and gets cancelled due to timeout

        for(Future<Integer> future : futures){
            try{
                System.out.println(future.get());
            } catch(CancellationException e){

            } catch(InterruptedException e){

            } catch(ExecutionException e){

            }
        }
        executorService.shutdown();
        System.out.println("Main");
    }
}

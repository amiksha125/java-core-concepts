package multithreading.executor_framework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main5 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
        List<Future<Integer>> futures = executorService.invokeAll(list);
//        Executes the given tasks, returning a list of Futures holding their status and results when all complete.
    //    Params:
//        tasks – the collection of tasks, accepts list of type Callable
//        Returns:
//        a list of Futures representing the tasks, in the same sequential order as produced by the iterator for the given task list, each of which has completed

        // One special feature of invokeAll() is that it blocks the main thread execution it is running.

        for(Future<Integer> future : futures){
            System.out.println(future.get());
        }
       executorService.shutdown();
        System.out.println("Hello World"); // always printed in the end
//        let us see invokeAll with timeout
    }
}

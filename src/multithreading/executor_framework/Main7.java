package multithreading.executor_framework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main7 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
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
//        Executes the given tasks, returning the result of one that has completed successfully (i. e., without throwing an exception),
//        if any do before the given timeout elapses. Upon normal or exceptional return, tasks that have not completed are cancelled.
//                The results of this method are undefined if the given collection is modified while this operation is in progress.
        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
        Integer i = executorService.invokeAny(list);
        System.out.println(i);
    }
}

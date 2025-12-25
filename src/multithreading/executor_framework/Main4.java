package multithreading.executor_framework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> submit = executorService.submit(() -> 1 + 2);
        //press alt enter and select induce local variable
        Integer i = submit.get();
        System.out.println("sum is " + i);
        executorService.shutdown();
        Thread.sleep(10);
        // if waited for 10ms then isTerminated becomes true as all tasks will be completed
        System.out.println(executorService.isTerminated());
    }
}

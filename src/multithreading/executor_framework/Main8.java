package multithreading.executor_framework;

import java.util.concurrent.*;

public class Main8 {
//    public static void main(String[] args) {
//        //Future Object Methods
//        // 1. get()
//
//        ExecutorService executorsService = Executors.newSingleThreadExecutor();
//        Future<Integer> future = executorsService.submit(() -> 42);
//        Integer i = null;
//        try{
//            i = future.get();
//            System.out.println(i);
//        } catch (InterruptedException | ExecutionException e){
//            System.out.println(("Exception occured: " + e));
//        }
//
//        executorsService.shutdown();
//
//    }

//    public static void main(String[] args) {
//        //Future Object Methods
//        // 1. isDone()
//
//        ExecutorService executorsService = Executors.newSingleThreadExecutor();
//        Future<Integer> future = executorsService.submit(() -> 42); //call method
//        Integer i = null;
//        try{
//            System.out.println(future.isDone());
//            i = future.get();
//            System.out.println(future.isDone());
//            System.out.println(i);
//        } catch (InterruptedException | ExecutionException e){
//            System.out.println(("Exception occured: " + e));
//        }
//
//        executorsService.shutdown();
//    }

//    public static void main(String[] args) {
//        //Future Object Methods
//        // 1. get() with timeout , after timeout get will not wait for result and throw TimeoutExceptio
//
//        ExecutorService executorsService = Executors.newSingleThreadExecutor();
//        Future<Integer> future = executorsService.submit(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                System.out.println(("Exception occured: " + e));
//            }
//            return 42;
//        }); //call method
//        Integer i = null;
//        try{
//            i = future.get(1, TimeUnit.SECONDS); // wait for 1 sec if action is not completed then throw exception
//            System.out.println(i);
//        } catch (InterruptedException | ExecutionException e){
//            System.out.println(("Exception occured: " + e));
//        } catch (TimeoutException e) {
//            System.out.println((" Timeout Exception occured: " + e));
//        }
//
//        executorsService.shutdown();
//    }

    public static void main(String[] args) {
        //Future Object Methods
        // cancel() and isCancelled()

        ExecutorService executorsService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorsService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(("Exception occured: " + e));
            }
            System.out.println("hello");
            return 42;
        }); //call method
        //pause the main thread so that thread could get chance to execute
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        future.cancel(false); // Do not cancel the thread
        //future.cancel(true); // true means whether the task is running or not, cancel it
//        cancel(false) cancels the Future, not the thread,
//        so isCancelled() becomes true even though the task runs.
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());
        executorsService.shutdown();

//        Simple Flow
//
//        Main thread starts
//
//        ExecutorService created (1 worker thread)
//
//        Task submitted
//
//        Worker thread starts
//
//        Worker thread sleeps (2 sec)
//
//        Main thread sleeps (1 sec)
//
//        Main thread calls cancel(false)
//
//        Task continues running
//
//        Future marked cancelled
//
//        Main thread prints
//
//        true
//        true
//
//
//        Worker thread finishes
//
//        Prints hello
//
//        Executor shuts down

    }
}

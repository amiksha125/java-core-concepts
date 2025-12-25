package multithreading.executor_framework;

import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //  ExecutorService is a subclass of Executor , it has submit method while Executor has execute method with limited functions
        // use  ExecutorService
        //Future<?> submit(Runnable task); is also there in ExecutorService
        // let us see Future<?>

        // // press ctrl + alt + enter

//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        for(int i = 1; i < 10; i++){
//            int finalI = i;
//            Future<?> future = executorService.submit( () -> {
//                long result = factorial(finalI);
//                System.out.println(finalI +" = "+ result);
//            });
//        }
      // future is used to check success, it is a status
        // future knows what is to be returned

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //Future<?> future = executorService.submit( () -> System.out.println("Hello"));

        // when passing runnable object in submit:

//        Runnable runnable = () -> "Hello"; error here but no error when SOUT
        //      Runnable runnable = () -> System.out.println("Hello");
        // because there are three types of submit method overloaded, one takes runnable, other takes callable, and another runnable n task.
        // Because when you see the Runnable interface it only has a run method which returns nothing void it is, and we are trying to receive a future
        // , which can only be received when passing a callable.

        // double shift to search for runnable, we can think callable as a brother of runnable, diff can be asked in interview
//        the error is gone if used callable and stored future

        Callable<String> callable = () -> "Hello callable";
        Future<String> future = (Future<String>) executorService.submit(callable);
   // In the below line, if you do not return anything, runnable's method run is used by default check submit
        // It may return future , but get() won't work
        // run() of runnable returns void, but submit(Runnable) that takes runnable returns future
        Future<?> future2 = executorService.submit(() -> System.out.println("runnable"));//submit(Runnable task);
        if(future.isDone()){
            System.out.println("Task is successfully completed !");
        }
        System.out.println(future.get());//Waits if necessary for the computation to complete, and then retrieves its result.
        executorService.shutdown();

        // To conclude , when you want to return something through lambda then use callable else use runnable

    }


}

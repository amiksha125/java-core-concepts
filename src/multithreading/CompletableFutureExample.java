package multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    // It is introduced in Java 8 to handle asynchronous programming
    // Multithreading is used to achieve asynchronous behaviour
    // Non blocking execution
    public static void main(String[] args) {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker thread ");
            } catch (Exception e) {

            }
            return "ok";
        });
//        will not wait for worker thread if get() is not called
        // there is also a getNow() method which will return the absence value
        String s = null;

//        try {
//            s = stringCompletableFuture.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
        s = stringCompletableFuture.getNow("noo"); // not waiting for 5 second
        System.out.println(s);
        System.out.println("Main");
    }

}

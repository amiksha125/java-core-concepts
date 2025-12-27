package multithreading;

import java.util.concurrent.*;

// By default, ComparableFuture tasks often run on daemon threads due to the use of ForkJoinPool.commonPool
// You can control thread type by providing custom execution service, see last part
// The ComparableFuture task itself does not dictate whether its daemon or user thread.

public class CompletableFutureExample2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";

        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";

        }).thenApply(x -> x + x);
        System.out.println(" .thenApply()"+f2.get());

        CompletableFuture<Void> f = CompletableFuture.allOf(f1, f2);//Returns a new CompletableFuture that is completed
// when all of the given CompletableFutures complete.
        f.join();
        System.out.println("Main");

        // orTimeOut() , exceptionally(), and executor

        Executor executor = Executors.newFixedThreadPool(3);
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";
            // This is also part of Java 8
        }, executor).orTimeout(1, TimeUnit.SECONDS).exceptionally(s -> "Timeout Occured");
        System.out.println(f3.get());
    }
}

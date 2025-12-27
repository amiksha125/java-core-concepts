package multithreading.executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main11 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        // Executors.newCachedThreadPool() dynamically adjusts the size of the pool, add or delete threads from the pool as needed
        // It must be used when load is variable
    }
}

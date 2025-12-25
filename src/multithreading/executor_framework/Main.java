package multithreading.executor_framework;

public class Main {
    public static void main(String[] args) {
        // In this each thread will try to find factorial of every number from 1 to 10 simultaneously,total time is 1sec
        // Every thing is created from scratch, no thread reusability
        // let us use executor framework for more efficiency
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];
        for(int i = 1; i < 10; i++){
            int finalI = i;
            threads[i - 1] = new Thread(
                    () -> {
                        long result = factorial(finalI);
                        System.out.println(result);
                    }
            );
           threads[i - 1].start();
        }

        for(Thread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime)); // if main thread is not paused using .join, then this will be printed first
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

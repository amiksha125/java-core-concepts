package multithreading.executor_framework.callable_runnable_signitures;

public class RunnableTask implements Runnable{

    @Override
    public void run() {
        // cannot throw exception in method signature
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

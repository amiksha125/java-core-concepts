package multithreading;

public class WorldRunnable implements Runnable {
    @Override
    public void run() {
        for(; ; ){
            //System.out.println("World");
            System.out.println( Thread.currentThread().getName()); // Thread-0
        }
    }
}

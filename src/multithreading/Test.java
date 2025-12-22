package multithreading;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        // Process finished with exit code 0
        System.out.println( Thread.currentThread().getName()); //main


//        To create a thread, create a new class that extends Thread and override the run() method of Thread.
//        To run it, create the object of the class that extends the Thread in the main method and : className.start()

//        World world = new World(); //NEW STATE
//        world.start(); // RUNNABLE STATE

        WorldRunnable world = new WorldRunnable();
        Thread t1 = new Thread(world);
        t1.start();

        for(; ; ){
           // System.out.println("Hello");
            System.out.println( Thread.currentThread().getName());
        }
    }
}

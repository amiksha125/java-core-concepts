package multithreading.lifecycle;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("RUNNING");
        // can't write throws with overridden method
        // stop t1 execution for 2 sec
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());

        t1.start();
        System.out.println(t1.getState());
        // getState returns a state which is enum, check it
        // There is no running state in enum, In Java RUNNABLE state means thread either executing or ready to execute.

        //System.out.println(Thread.currentThread().getState()); // main thread's state
        // we want to assign CPU time to thread t1, not main
        // We will pause the execution of main thread for some millisec using sleep()

        Thread.sleep(100); // To make JVM execute the run method we, we made main thread to stop its execution for 100ms
        // rather than being on multicore env, we try to behave as if in single core

        // sleep() method throws InterruptedException

        //when t1 is sleeping it is in TIMED_WAITING  state
        System.out.println(t1.getState());
        t1.join(); // main method will wait for t1 to get finished
        //if t1 finished execution then only main will continue

        System.out.println(t1.getState()); // see at output screen main literally waited for 2 sec then printed its state

    }
}

package multithreading.synchronization.Locks;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
public class UnfairLockExample {
    //private final Lock unfairLock = new ReentrantLock();
    private final Lock fairLock = new ReentrantLock(true);
    public void accessResource(){
        fairLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() +  " acquired the lock.");
            Thread.sleep(1000);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            fairLock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock.");
        }
    }

    public static void main(String[] args) {
        UnfairLockExample example = new UnfairLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t3.start();

        //Suppose there are 20 threads , and one of them could not get a change to acquire the lock , this is starvation
        // If fair is made true while creating -  Lock fairLock = new ReentrantLock(true); then there will be fairness
    }
}

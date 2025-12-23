package multithreading.synchronization.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try{
            System.out.println("Outer method");
            innerMethod();
        } finally{
            lock.unlock();
        }
    }

    private void innerMethod() {
        lock.lock(); // we are trying to lock the lock that is already locked
        // waiting for its own lock to be released
        //deadlock: outerMethod waits for innerMethod to get finished and vice-versa

        // But since the lock is reentrant, the inner method will acquire the lock again
        // When reentrant lock is used, a count is maintained the number of times the lock is acquired
        // lock() means +1. unlock() means -1, each lock should be paired with unlock
        try{
            System.out.println("Inner method");
        } finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample reentrantExample = new ReentrantExample();
        reentrantExample.outerMethod();

        //When main() is executed, an object of ReentrantExample is created and outerMethod() is called.
        // Inside outerMethod(), the thread acquires the ReentrantLock, increasing its lock count to 1,
        // and prints "Outer method". It then calls innerMethod(), where the same thread again tries to
        // acquire the same lock. Normally this would cause a deadlock, but since the lock is reentrant,
        // the thread is allowed to acquire it again, increasing the lock count to 2, and "Inner method" is printed.
        // After this, innerMethod() releases the lock once, decreasing the count to 1, and returns to outerMethod(),
        // which finally releases the lock again, bringing the count to 0. Only when the count reaches zero is the lock
        // fully released, allowing other threads to acquire it.
    }
}

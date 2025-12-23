package multithreading.synchronization;

import multithreading.lifecycle.MyThread;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Mythread t1 = new Mythread(counter);
        Mythread t2 = new Mythread(counter);

        t1.start();
        t2.start();
        try{
            t1.join();;
            t2.join();
            // pauses the execution of current thread main until the specified thread completes its execution

        } catch (Exception e){

        }
        // the loop must run 2000 times by both the threads, but here the value of count will be less than 2000
        System.out.println(counter.getCount());
        // One object counter being used by two threads , count variable is a shared data
        //There is a concurrent execution of both threads, both are running simultaneously
        // suppose if count is 101, It may happen that both will read 103 at the same time and increment to 102 by both
        // one count is reduced, and there can be many such

        // The shared resources must be accessed one at a time to overcome such issues

        // Java has a synchronized keyword to ensure that if a thread is executing the increment() function
        // then no other thread will execute it, like a critical section is OS, only one thread can enter and execute

        // we can make method and a block of code synchronized
        // synchronized block : synchronized (this) { } this is the curr object only, only it must execute that block


    }
}

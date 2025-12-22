package multithreading.thread;

public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        // sleep
//        for(int i = 1; i <= 5; i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(i);
//        }

        //join

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        //setPriority

//        for(int i = 0; i < 5; i++){
//
//            System.out.println(Thread.currentThread().getName()+ " Priorty: "+ Thread.currentThread().getPriority());
//
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

        //interrupt

//        try {
//            Thread.sleep(1000);
//            System.out.println("Thread is running..");
//        } catch (InterruptedException e) {
//            System.out.println("Thread Interrupted "+ e);
//        }

        //yield

//        for(int i = 0; i < 5; i++){
//            System.out.println(Thread.currentThread().getName());
//            Thread.yield();//A hint to the scheduler that the current thread is willing to yield its current use of a processor. The scheduler is free to ignore this hint.
//        }

        //setDaemon

        while(true){
            System.out.println("hello World!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        MyThread t1 = new MyThread();
//        t1.start();
//        t1.join();
//
//        System.out.println("Printed after 5 sec as join stops main for t1");

        //setInterval

//        MyThread t1 = new MyThread("Low Priority Thread");
//        MyThread t2 = new MyThread("Medium Priority Thread");
//        MyThread t3 = new MyThread("High Priority Thread");
//
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.NORM_PRIORITY);
//        t3.setPriority(Thread.MAX_PRIORITY);
//
//        t1.start();
//        t2.start();
//        t3.start();

        //interval

//        MyThread t1 = new MyThread("th-1");
//        t1.start();
//        t1.interrupt(); // sleep interrupted

        //yield

//        MyThread t1 = new MyThread("th-1");
//        MyThread t2 = new MyThread("th-2");
//        t1.start();
//        t2.start(); // they both will run alternatively not perfectly

        // op th-1
        //th-2
        //th-1
        //th-2
        //th-1
        //th-2
        //th-1
        //th-2
        //th-1
        //th-2

        //setDaemon : the thread we create is user thread, and daemon thread run in the background
        // Garbage Collection could be a daemon thread
        // In user thread,the JVM waits until the run method finishes its execution, but JVM does not wait for daemon threads in bg
        // even in infinite loop, JVM ignores the daemon thread

        MyThread myThread = new MyThread("daemon");
        myThread.setDaemon(false); // make it true to find difference
        myThread.start();
        System.out.println("Main done");


    }
}

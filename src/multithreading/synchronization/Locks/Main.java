package multithreading.synchronization.Locks;

public class Main {

    public static void main(String[] args) {
//        BankAccount account = new BankAccount();
//
//        //create anonymous
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                account.withdraw(50);
//            }
//        };
//
//        Thread t1 = new Thread(task, "Thread 1");
//        Thread t2 = new Thread(task, "Thread 2");
//        // Two threads withdrawing 50 rs from same bank account simultaneously
//
//        // try running this without making withdraw synchronized, how inconsistent it would be
//
//        t1.start();
//        t2.start();

        //Explicit lock
        BankAccountLock accountLock = new BankAccountLock();
        Runnable task = new Runnable() {
          @Override
          public void run() {
              accountLock.withdraw(50);
          }
        };
        Thread t1 = new Thread(task, "Thread 1");
       Thread t2 = new Thread(task, "Thread 2");

       t1.start();
       t2.start();
    }


}

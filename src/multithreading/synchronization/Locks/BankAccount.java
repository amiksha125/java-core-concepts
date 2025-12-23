package multithreading.synchronization.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to " + amount);
        if(balance >= amount){

            System.out.println(Thread.currentThread().getName() + " proceeding to withdrawal " + amount);
            try{
               Thread.sleep(3000);
            } catch(Exception e){

            }

            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " has completed withdrawal remaining balance " + balance);

        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }
    }
}

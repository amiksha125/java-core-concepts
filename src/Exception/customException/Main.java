package Exception.customException;

import multithreading.synchronization.Locks.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount1 bankAccount = new BankAccount1(10.00);
        try{
            bankAccount.withdraw(11);
        }catch(InsufficientFundsException e){
//            System.out.println(e.getMessage()); // toString is not printed
            System.out.println(e);
            System.out.println(e.getAmount());
        }
    }
}

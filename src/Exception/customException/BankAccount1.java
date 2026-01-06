package Exception.customException;

public class BankAccount1 {

    private double balance;

    public BankAccount1(double amount){
        this.balance = amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount > balance){
            throw new InsufficientFundsException(amount); //Exception("Insufficient balance");
        }
        balance -= amount;
    }
}

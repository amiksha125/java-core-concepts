package Exception.customException;

public class InsufficientFundsException extends Exception{

    private double amount;

    InsufficientFundsException(double amount){
        super("What do you want ? You don't have money"); //toString() can replace this
        // but above is recommended
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "What do you want ? You don't have enough money";
    }
}

package inner_classes.anonymous_inner_class;

public class Test {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart(120);
        //CreditCard creditCard = new CreditCard("4527638");
        //shoppingCart.processPayment(creditCard);

        // without creating CreditCard object, do this on the fly using anonymous class impl.

        shoppingCart.processPayment(new Payment() {
            @Override
            public void pay(double amount) {
                System.out.println("Paid " + amount + " using credit card.");
            }
        });

        shoppingCart.processPayment(new Payment() {
            @Override
            public void pay(double amount) {
                System.out.println("Paid " + amount + " using paypal.");
            }
        });
    }
}

package multithreading.lambda_expressions_threads;

public class LambdaExpression {
    public static void main(String[] args) {
//        Runnable runnable = () -> System.out.println("Hello");
//
//        Thread t1 = new Thread(runnable);
//        t1.start();

        Thread t1 = new Thread(() -> System.out.println("Hello"));
        t1.start();

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.println("Hello World!");
            }
        });
        // wk, integer value can be assigned to int ref
        // Lambda Expression can be assigned to the reference of functional interface

        int a = 1;
        Runnable task = () -> {
            for(int i = 0; i < 10; i++){
                System.out.println("Hello World!");
            }
        };

        t2.start();
    }
}

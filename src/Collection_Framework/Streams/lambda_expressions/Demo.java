package Collection_Framework.Streams.lambda_expressions;

public class Demo {
    public static void main(String[] args) {
        // lambda expression is an anonymous function( no name, no return type, no access modifier)

        Thread t1 = new Thread(new Task());// this Thread() requires runnable
        // we can provide lambda expression instead of new Task()
        // the run() method will be converted into lambda expression

        // remove return type, method name from run() and add -> between () and {} , --> () -> {}
        Thread thread = new Thread(() -> {
            System.out.println("Hello");
        }); // code is minimized

        thread.start();

        // *** LAMBDA EXPRESSIONS ARE USED TO IMPLEMENT FUNCTIONAL INTERFACE ***
        // functional interface is an interface having only one abstract method

        MathOperation sumOperation = (a, b) -> a + b;
        MathOperation subtractOperation = (a, b) -> a - b;
        int res = sumOperation.operate(3, 6);
        System.out.println(res);

        // FUNCTIONAL INTERFACE'S REFERENCE CAN HOLD LAMBDA EXPRESSION
        // LAMBDA EXPRESSION STORED IN A VARIABLE --> FUNCTIONAL PROGRAMMING

    }
}
// annotate --> It is supposed to be functional interface
@FunctionalInterface
interface MathOperation{
    int operate(int a, int b);
}

// without lambda expressions we would have to create its impl class:
// Instead of writing classes for subtract, multiply and divide, use lambda expressions to define the logic of operate
class SumOperation implements MathOperation{

    @Override
    public int operate(int a, int b) {
        return a + b;
    }
}

class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello");
    }
}

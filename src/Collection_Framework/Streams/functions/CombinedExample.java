package Collection_Framework.Streams.functions;
import java.util.function.*;

public class CombinedExample {
    public static void main(String[] args) {
        // I studied -> functions, predicate, supplier and consumer
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){ // test if the value returned by supplier is even
            // if even then pass that value to consumer after doubling it
            // we got a value from supplier after giving nothing
            // we tested that value using predicate
            // we passed it to the consumer to print
//            but after  doubling it through function
            consumer.accept(function.apply(supplier.get()));

            // There are other functional interfaces that take two arguments
            // BiPredicate, BiFunction, BiConsumer

            BiPredicate<Integer, Integer> isSumEven = (x , y) -> (x + y) % 2 == 0;
            System.out.println(isSumEven.test(5, 5));
            BiConsumer<Integer, String> biConsumer = (rollno, name) -> {
                System.out.println("Roll No: " + rollno + " Name: " + name);
            };
            biConsumer.accept(18, "Amiksha");
            // BiFunction<T, U, R> --> T and U are the type parameters that will be accepted and R defines the type to return
            BiFunction<String, String , Integer> biFunction = (x, y) -> (x + y).length();
            System.out.println(biFunction.apply("Amiksha", "Gajbhiye"));

            // When we know the input type and output type are same, then use UnaryOperator
            // UnaryOperator implements Function and accepts one Type Parameter that will be same for both input & output

            UnaryOperator<Integer> unaryOperator = x -> (int) Math.pow(x, 10);
            // similarly we have BinaryOperator for BiFunction
            BinaryOperator<Integer> b = (x, y) -> x + y;


        }

    }
}

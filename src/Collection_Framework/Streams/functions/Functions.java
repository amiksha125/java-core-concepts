package Collection_Framework.Streams.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Functions {
    public static void main(String[] args) {
//        Function --> work for you
        // unlike predicate --> Function will take a value apply some logic and return a value
        // It takes twotype parameter, first type is to be passed in the argument, and second parameter denotes the
        // return type of function

        // interface Function<T, R> ---> R apply(T t);

        Function<Integer, Integer> doubleIt = x -> 2 * x;
        System.out.println(doubleIt.apply(7));

        // andThen

        Function<Integer, Integer> tripleIt = x -> 3 * x;
        Integer apply = doubleIt.andThen(tripleIt).apply(20);
        System.out.println(apply);

        // if you want to execute tripleIt first then use compose
        System.out.println(doubleIt.compose(tripleIt).apply(6));
        System.out.println(tripleIt.andThen(doubleIt).apply(6)); // same

        // there is a static method called identity that return the same that it takes
        Function<Integer, Integer> identity = Function.identity(); // className.func
        System.out.println(identity.apply(7)); // 7


        // # CONSUMER FUNCTIONAL INTERFACE
        // It takes but returns nothing

        Consumer<Integer> consumer = (x) -> System.out.println(x);
        consumer.accept(9); // 9

        List<Integer> list = Arrays.asList(3, 8, 9);
        Consumer<List<Integer>> printList = x -> System.out.println(x);
        printList.accept(list);

        // there is no compose as it returns nothing
        // andThen is there which executes two consumers sequentially



        // # SUPPLIER
        // IT TAKES NOTHING BUT RETURNS SOMETHING
        // Supplier<T> --> T is the type to be returned

        Supplier<String> giveMsg = () -> "Hello World!";
        System.out.println(giveMsg.get());



    }
}

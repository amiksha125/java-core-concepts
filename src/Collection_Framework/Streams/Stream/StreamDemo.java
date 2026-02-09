package Collection_Framework.Streams.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // feature introduced in java 8
        // process collections of data in a functional and declarative manner
        // Simplify Data Processing
        // Embrace Functional Programming
        // Improve Readability and Maintainability
        // Enable Easy Parallelism

        // What is stream ?
        // a sequence of elements supporting functional or declarative programming

        // How to Use Streams ?
        // Source, intermediate operations & termination operation

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // perform declarative or functional programming on Collections
        // convert collection to stream

        Stream<Integer> stream = numbers.stream(); // A sequence of elements supporting sequential and parallel aggregate operations.

        // If we have to find the count of even numbers in the list
        // traditional way to do that:
        int count = 0;
        for(int l: numbers){
            if(l % 2 == 0) count++;
        }

        // This can be simplified using stream
        // we have source, convert source to stream then perform operation using filter(predicate)
        // we will use predicate to hold the condition
        // count() is the termination operation

        System.out.println(numbers.stream().filter(x -> x % 2 == 0).count()); // 2 mast hai ,convert collection to stream then perform operation

        // Creating Streams
        // 1. From collections
        List<Integer> list = Arrays.asList(1, 2, 5, 8, 6);
        Stream<Integer> stream1 = list.stream();
        // 2. From Arrays
        String[] array = { "a", "b", "c" };
        Stream<String> stream2 = Arrays.stream(array);
        // 3. Using Stream.of()
        Stream.of("a", "b");
        // 4. Infinite streams
        Stream<Integer> generate = Stream.generate(() -> 1); // infinite, generate(supplier)
        // set limit
        Stream<Integer> generate1 = Stream.generate(() -> 2).limit(100);
        // Another way to create infinite stream is using Stream.iterate(seed, unaryOperator) seed is starting point
            // UnaryOperator is a function whose parameter and return type is same

        List<Integer> collect = Stream.iterate(0, x -> x + 1).limit(100).collect(Collectors.toList());// infinite
        // To convert stream data to list , use .collect(Collectors.toList())



    }
}

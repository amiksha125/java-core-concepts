package Collection_Framework.Streams.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        // Intermediate operations transform a stream into another stream
        // They are lazy(like me), meaning they don't execute until a terminal operation is invoked.

        List<String> list = Arrays.asList("Akshit", "Ram", "Shyam","Ghanshyam", "Akshit");

        // 1. filter
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("A")); // predicate
        // no filtering at this point

        // terminal operation is collect, count, if these are invoked on stream then only it starts creating stream
        List<String> collect = filteredStream.collect(Collectors.toList());
        //long count = filteredStream.count();

        // 2.map
        Stream<String> stringStream = list.stream().map(x -> x.toUpperCase());// function
        list.stream().map(String::toUpperCase); // method reference --> String::

        // 3. sorted
        Stream<String> sortedStream = list.stream().sorted();
        Stream<String> sortedStreamUsingComparator = list.stream().sorted( (a, b) -> a.length() - b.length());// comparator

        // 4. distinct
        long a = list.stream().filter(x -> x.startsWith("A")).count(); // 2
        // we want distinct, the result of filter was stream which contains 2 Akshit, so apply distinct operation on the resultant stream
        long a1 = list.stream().filter(x -> x.startsWith("A")).distinct().count();

        // 5. limit
        // limits the result generated as stream
        //Stream.iterate(1, x -> x + 1).count(); // program will never stop if you run ,
        // Non-short-circuit operation consumes infinite stream - processing elements from to end - infinite
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count()); // 100
        // limit mans we want first 100 elements from result

        // 6. skip
        System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count()); // its again 100
        // 11 to 110, first 10 are skipped

        // 7. peek
        // this method is similar to terminal operation forEach, but it is intermediate operation
        // Performs an action on each element as it is consumed
        Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println).count();
        // count will make peek execute




    }
}

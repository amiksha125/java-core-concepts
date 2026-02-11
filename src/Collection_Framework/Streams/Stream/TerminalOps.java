package Collection_Framework.Streams.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 6, 3 ,8, 9);

        // 1. collect
        list.stream().skip(1).collect(Collectors.toList()); // collect wants Collectors
        // toList is a part of Collectors that returns Collector by accumulating the input elements into a new list
        Collectors.toSet();
        Collectors.toUnmodifiableList();
        Collectors.toUnmodifiableSet();
//        Collectors.toUnmodifiableMap();
        // In new Java you can directly:
        list.stream().toList();


        // 2. forEach
        list.stream().forEach(x -> System.out.println(x)); // consumer


        // 3. reduce: combines elements to produce a single result
        Optional<Integer> optionalInteger = list.stream().reduce((x, y) -> x + y); // sum of all elements
        // binaryOperator - a BiFunction that takes two input and return an output of same type
        // reduce returns Optional means it may or may not contain value
        System.out.println(optionalInteger.get()); // take value from box
        // reduce(accumulator) just like in JS
        // it takes lambda expression which can be converted into method reference
        list.stream().reduce(Integer::sum);

        // 4. count

        // 5. anyMatch, allMatch, noneMatch
        boolean b = list.stream().anyMatch(x -> x % 2 == 1); // if any element satisfies predicate condition the true
        boolean b1 = list.stream().allMatch(x -> x > 0);// if all match then return true
        list.stream().noneMatch(x -> x < 0); // returns true only when not a single element satisfies predicate
        // all true

        // 6. findFirst, findAny
        System.out.println( list.stream().findFirst().get()); // returns first element
        System.out.println(list.stream().findAny().get()); // returns any element

        // 5 and 6 are short circuit methods means as soon as they find something they stop and return result, do not process all

        // 7. toArray
        Object[] array = Stream.of(1, 2, 3).toArray();

        // 8. min/max
        Optional<Integer> max = Stream.of(2, 44, 69).max(Comparator.naturalOrder());
        System.out.println(max);
        Optional<Integer> min = Stream.of(2, 44, 69).min(Comparator.naturalOrder());
        System.out.println(min);
        Optional<Integer> max2 = Stream.of(2, 44, 69).max((o1, o2) -> o2 - o1);
        System.out.println(max2);

        // 9. flatMap
        // Handle streams of Collections, lists, or arrays where each element is itself a collection
        // Flatten nested structure (eg lists within lists) so that they can be processed as a single sequence of elements
        // Transform and flatten elements at the same time
        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );
        System.out.println(listOfList.get(1).get(0)); // orange
        // we want all the strings in uppercase and flat in a single sequence
        List<String> flatten = listOfList.stream()
                .flatMap(x -> x.stream())
                .map(String::toUpperCase)
                .toList();
        System.out.println(flatten);

        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java steams are powerful",
                "FlatMap is useful"
        );

        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .toList();

        // 10. forEachOrdered
         // when steam is parallel then forEach will run randomly in arbitrary manner
        // if we want  to execute forEach in order, then use forEachOrdered in case of parallelStream
        List<Integer> nums = Arrays.asList(1, 2, 3 , 4, 5, 6, 7, 8, 9, 10);
        System.out.println("using forEach with parallel stream: ");
        nums.parallelStream().forEach(System.out::println); // not printed in order
        System.out.println("using forEachOrdered with parallel stream ");
        nums.parallelStream().forEachOrdered(System.out::println);

        // Example
        // stream cannot be reused after a terminal operation is called

        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        Stream<String> stream = names.stream();
        // forEach is a terminal operation, and shortcut for method reference is soutc
        stream.forEach(System.out::println);
        // stream has already been operated upon or closed
      //  stream.map(String::toUpperCase);

    }
}

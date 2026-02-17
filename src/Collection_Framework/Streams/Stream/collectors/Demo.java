package Collection_Framework.Streams.Stream.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        // Collectors is a utility class
        // provides a set of methods to create common collectors

        // 1. Collecting as a list
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> a = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(a);

        // 2. Collecting as a set
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        Set<Integer> collect = nums.stream().collect(Collectors.toSet()); // unique elements
        System.out.println(collect);

        // 3. Collecting to a Specified Collection, toCollection() which takes supplier
        ArrayDeque<String> collect1 = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        // 4. Joining Strings
        // Concatenates stream elements into a Single String
        String concatinatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(concatinatedNames);

        // 5. Summarizing data
        // Generates statistical summery (count, sum, min, average, max)

        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11);
        // it takes toIntFunction
        IntSummaryStatistics collect2 = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count " + collect2.getCount());
        System.out.println("Sum "+collect2.getSum());
        System.out.println("Min " + collect2.getMin());
        System.out.println("Max " + collect2.getMax());
        System.out.println("Average "+collect2.getAverage());


        // 6. Calculating Averages
        Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average: "+average);

        // 7. Counting elements
        System.out.println(numbers.stream().collect(Collectors.counting()));

        // 8. Grouping Elements
        List<String> words = Arrays.asList("hello", "world", "java", "streams", "collecting");
        Map<Integer, List<String>> collect3 = words.stream().collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(collect3);
        // if uou want to perform something on each group then give collector after
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", "))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap); // its tree map


        // 9. Partitioning Elements
        // Partitions elements into two groups (true and false) based on predicate
        Map<Boolean, List<String>> collect4 = words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5));
        System.out.println(collect4);

        // 10. Mapping and Collecting
        // Applies a mapping function before collecting
        System.out.println(words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));

        // ask gpt to give you questions on collectors then solve , then only we will get it



    }
}

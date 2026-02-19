package Collection_Framework.Streams.Stream.collectors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Questions {
    public static void main(String[] args) {
        // Example 1: Collecting Names by Length
        List<String> names = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
        System.out.println(names.stream().collect(Collectors.groupingBy(String::length)));

        // Example 2: Counting word occurrences
        String sequence = "hello world hello java worls";
        System.out.println(Arrays.stream(sequence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        // Example 3: Partitioning Even and Odd Numbers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));

        // Example 4: Summing Values in a Map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 15);
        System.out.println(items.values().stream().reduce(Integer::sum));
        System.out.println(items.values().stream().collect(Collectors.summingInt(x -> x)));

        // Example 5: Create a Map from Stream Elements
        List<String> list1 = Arrays.asList("Apple", "Banana", "Cherry");
        // mapping -> apply some transformation before collecting elements not needed
        // no partitioning or grouping
        // we want direct key-value mapping without transformation
        // There is another collector called toMap
        // toMap(key, value)
        Map<String, Integer> collect = list1.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length()));
        System.out.println(collect);

        // Example 6 : Count word occurrence using toMap()key, value, merge)
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> collect1 = words.stream().collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x + y));
        // Duplicate key apple (attempted merging values apple and apple): if no merge provided
        // merge is a BinaryOperator , when a duplicate key encounters it will automatically handle it, if it for the first
        // time then the value will be 1, it not then merge will kep summing
        // if apple encounters again , then new apple's count and old apple's count is added and value is updated
        System.out.println(collect1);


    }
}

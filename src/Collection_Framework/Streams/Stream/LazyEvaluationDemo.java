package Collection_Framework.Streams.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");

        Stream<String> stream = names.stream().filter(name -> {
            System.out.println("Filtering: " + name);
            return name.length() > 3;
        }); // this will be printed after the below statement
        // unless the terminal operation is called , this filtering will not perform

        System.out.println("Before terminal operation");

        List<String> result = stream.collect(Collectors.toList());

        System.out.println("After terminal operation");

        System.out.println(result);
    }
}

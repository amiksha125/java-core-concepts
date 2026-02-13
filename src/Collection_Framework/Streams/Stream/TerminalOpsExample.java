package Collection_Framework.Streams.Stream;

import java.util.Arrays;
import java.util.List;

public class TerminalOpsExample {
    public static void main(String[] args) {

        // Example : Filtering and Collecting Names
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        System.out.println(names.stream().filter(x -> x.length() > 3).toList()); // filter conditional filtering

        // Example : Squaring and Sorting Numbers
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(numbers.stream().map( x -> x * x).sorted().toList()); // map -> function

        // Example : Summing values
        System.out.println(numbers.stream().reduce((x , y) -> x + y).stream().toList()); // reduce -> to get single value
        // Or method reference
        System.out.println(numbers.stream().reduce(Integer::sum));

        // Example : Counting Occurrence of a Character
        String sentence = "Hello World!";
        char[] charArray = sentence.toCharArray();
//        Arrays.stream -> it does not accept a char array
        // use chars() method that creates a stream of integer corresponding to each character -> ASCII
        System.out.println(sentence.chars().filter(x -> x == 'l').count()); // 3


        // stateful & stateless
        // stateful if operation is aware about data elements
        // eg map does not know about elements it is just squaring the elements
        // but sorted needs to compare elements , it must know data elements similarly distinct




    }
}

package Collection_Framework.Streams.Stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;

public class PrimitiveStreams {
    public static void main(String[] args) {
        // we were playing with Wrapper Classes till now
        Integer[] nums = {1, 2, 3};
        Stream<Integer> stream = Arrays.stream(nums); // we are familiar

        int[] numbers = {1, 2, 3, 4, 5};
        IntStream stream1 = Arrays.stream(numbers);
        // A sequence of primitive int-valued elements supporting sequential and parallel aggregate operations.

        // There are DoubleStream, LongStream
        DoubleStream doubleStream = stream1.asDoubleStream();
        //LongStream longStream = stream1.asLongStream(); // cannot reuse stream1 - exception
        //Stream<Integer> boxed = stream1.boxed(); // converting to wrapper class stream, so that we can apply toList, collect

        // Stream is generic but IntStream is specific to Integer, you can check out methods of IntStream
        System.out.println(IntStream.range(1, 5).boxed().collect(Collectors.toList()));

        // rangeClosed(s, e) both inclusive
        System.out.println(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));

        IntStream intStream = IntStream.of(3, 4, 8);

        DoubleStream doubles = new Random().doubles(5); // get 5 random double values
        //System.out.println(doubles.boxed().toList());

        IntStream intss = new Random().ints(4);
        System.out.println(intss.boxed().toList());

        //System.out.println(doubles.sum());
//        System.out.println(doubles.average());
//        System.out.println(doubles.count());
//        System.out.println(doubles.max()); stream already closed exception

        // mapToInt
        IntStream intStream1 = doubles.mapToInt(x -> (int) x + 1);
        System.out.println(intStream1.boxed().toList());


    }
}

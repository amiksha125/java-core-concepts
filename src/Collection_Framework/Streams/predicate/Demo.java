package Collection_Framework.Streams.predicate;

import java.util.function.Predicate;

public class Demo {
    // Predicate --> Functional Interface
    public static void main(String[] args) {
        // Predicate<T> has only one abstract method -> boolean test(T t); and rest are default methods after Java 8

        // Predicate is a boolean-valued function
        // Its reference variable accepts a lambda expression of test function
        // A Boolean Values Expression
        // PREDICATE HOLD A CONDITION TO BE EVALUATED
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(6));

        // condition is stored in variable
        // Use predicate if you need to compare or check something rather than writing code just write a single statement

        // predicates can be combined:
        Predicate<String> isWordStartsWithA = x -> x.toUpperCase().startsWith("A");
        Predicate<String> isWordEndsWithA = x -> x.toUpperCase().endsWith("A");
        // use and if you want both predicates to be true
        Predicate<String> and = isWordEndsWithA.and(isWordStartsWithA);

        System.out.println(and.test("Amiksha"));

    }
}

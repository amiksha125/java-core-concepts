package Collection_Framework.Streams.method_reference;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        // Method reference --> use method without invoking and in place of lambda expression

        List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");
        // ye to consumer le raha hai
        // consumer takes something but returns nothing
        students.forEach(x -> System.out.println(x));
        // Lambda can be replaced with method reference
        students.forEach(System.out::println);
        // :: method reference, it means we did not call println each time
        //  WE ARE GIVING METHOD AS PARAMETER
        // LAMBDA FUNCTION ALSO PASSES METHOD AS PARAMETER

        // CONSTRUCTOR REFERENCE
        List<String> names = Arrays.asList("A", "B", "C");
        // names.stream().map(x -> new MobilePhone(x)) instead of new , use Constructor reference
        List<MobilePhone> mobilePhones = names.stream().map(MobilePhone::new).collect(Collectors.toList());
    }

    static class MobilePhone{
        String name;

        MobilePhone(String name){
            this.name = name;
        }
    }
}

package Collection_Framework.Map.ImmutableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        // A map whose content cannot be changed or modified once instantiated
        // no add remove or update

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
        // Returns an unmodifiable view of the specified map.
        //attempts to modify the returned map, whether direct or via its collection views, result in an UnsupportedOperationException.

        System.out.println(map2); // ok
        map2.put("C", 3); // not ok, exception

        // Alternate way to create the same is:
        // this method is introduced in Java 9

        Map<String, Integer> map3 = Map.of("Shubham", 98, "Vivek", 78); // Returns an unmodifiable map
        // Map.of() is limited to create 10 key-value pairs only
        // To create a view of more than 10 entries:
        Map.ofEntries(Map.entry("Akshit", 99), Map.entry("Vivek", 99));

    }
}

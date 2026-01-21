package Collection_Framework.Map.SortedMap.NavigableMap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Demo {
    public static void main(String[] args) {
        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "One");
        // ctrl + shift + pageUp key
        navigableMap.put(5, "Five");
        navigableMap.put(3, "Three");
        System.out.println(navigableMap); // sorted like SortedMap

        System.out.println(navigableMap.lowerEntry(4)); // returns the closest and smaller key-value
        // returns key 3 which is the greatest key strictly less than the given key.
        System.out.println(navigableMap.ceilingKey(4)); // Returns the least key greater than or
        // equal to the given key, or null if there is no such key.


        System.out.println(navigableMap.higherEntry(1));// Returns a key-value mapping associated
        // with the least key strictly greater than the given key, or null if there is no such key.

        System.out.println(navigableMap.descendingMap());

        // Which reference type should I use before initializing TreeMap
        // If you want the closest key then use NavigableMap
        // If you want First key, sub map and last key then use SortedMap
        // If you want to just sort keys and get , put , contains basic operations them simply use Map reference.

    }
}

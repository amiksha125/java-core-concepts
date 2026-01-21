package Collection_Framework.Map.SortedMap;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        // name and marks
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        // We can provide comparator in TreeMap, without this it automatically sorts
        sortedMap.put("Vivek", 91);
        sortedMap.put("Shubham", 99);
        sortedMap.put("Mohit", 78);

        System.out.println(sortedMap); // already sorted in asc order of name
        // sorting based on keys

        // Both String and Integer implements Comparable and sorts in natural ascending order
        // We can do the same without SortedMap using Map, Sortedmap implements Map inteface
        Map<Integer, String> map = new TreeMap<>();
        map.put(91, "Vivek");
        map.put(99, "Shubham");
        map.put(78, "Mohit");
        System.out.println(map); // sorted based on marks using Map, but Sortedmap has some excellent methods

        System.out.println(sortedMap.firstKey()); // mohit
        System.out.println(sortedMap.lastKey()); // vivek
        // headMap() specify key --> till what point you want to get key-value pair
        //System.out.println(sortedMap.headMap("Shubham")); // Shubham is exclusive

        SortedMap<Integer, String> marksMap = new TreeMap<>();
        marksMap.put(91, "Vivek");
        marksMap.put(99, "Shubham");
        marksMap.put(78, "Mohit");
        marksMap.put(77, "Vipul");

        System.out.println(marksMap.headMap(91)); // 77 and 78, till 91 but 91 is exclusive
        System.out.println(marksMap.tailMap(91)); // 91 is inclusive, from 91 key to last key
        System.out.println(marksMap.subMap(78, 91));

        // natural ordering in ascending, we can provide comparator to TreeMap impl class

        SortedMap<Integer, String> descOrder = new TreeMap<>((a, b) -> b - a);
        // If key is a Student class then implement the Comparable interface and specify the ordering
        // logic else define Comparator in the same way
        descOrder.put(91, "Vivek");
        descOrder.put(99, "Shubham");
        descOrder.put(78, "Mohit");
        descOrder.put(77, "Vipul");
//        descOrder.put(null, "Amiksha"); // exception
        System.out.println(descOrder);


    }
}

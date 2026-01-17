package Collection_Framework.Map.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        // It extends HashMap<>
        // HashMap does not maintain Order, LinkedHashMap maintains order
        // change above map to HashMap to see the order
        linkedHashMap.put("Orange", 10);
        linkedHashMap.put("Apple", 20);
        linkedHashMap.put("Guava", 30);

        for(Map.Entry<String, Integer> e: linkedHashMap.entrySet()){
            System.out.println(e.getKey()+ " : "+e.getValue());
            // items are printed in the same order they are inserted
        }

        // LinkedHashMap has a double linked list along with array(bucket) like HashMap
        // This doubly linked list maintains the order of insertion, due to this list overhead it becomes slow
        // It also takes slightly more memory

        // When order of insertion matters use this
        // We can provide initial capacity and load factor, it also has access order parameter

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16, 0.5f, true);
        // accessOrder - the ordering mode - true for access-order, false for insertion-order
        // by default it is false, means we got items in the same order they were inserted

        // 🫵 when accessOrder is true, the element you access will be printed in the end


        map.put("Orange", 10);
        map.put("Apple", 20);
        map.put("Guava", 30);

        map.get("Apple");
        map.get("Orange");
        for(Map.Entry<String, Integer> e : map.entrySet()){
            System.out.println(e.getKey()+ " : "+e.getValue());
        }
        // Orange printed in the end

        // LRU (Least recently used mechanism ): members that are never used or used a very long time ago are at the top
        // means you can remove them if you do not use them

        // If you are tasked to remove least recently used items then use this
        // use LinkedHashMap with accessOrder true


        // It is very effective in caching, removing least recently used items from cache

        // We can create a LinkedHashMap from a HashMap
        HashMap<String, Integer> map1 = new HashMap<>();
        LinkedHashMap linkedHashMap1 = new LinkedHashMap(map1);

        // Some important methods of HashMap

        map1.put("Shubham", 91);
        map1.put("Bob", 89);
        map1.put("Akshit", 78);

        // If the key is not present getOrDefault(key, defaultvalue) will return defaultvalue
        Integer amiksha = map1.getOrDefault("Amiksha", 0);
        System.out.println(amiksha); // 0

        // To avoid overriding the value of key which is already present in the Map use putIfAbsent
        map1.putIfAbsent("Amiksha", 93);
        map1.put("Akshit", 75);

        System.out.println(map1.get("Akshit"));
       // LinkedHashMap is not thread safe just like HashMap

    }
}

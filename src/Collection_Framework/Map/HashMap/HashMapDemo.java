package Collection_Framework.Map.HashMap;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();// raw use of hashMap, give type , two required  <K, V>


        HashMap<Integer, String> map = new HashMap<>();
        // to insert both and key and its associated value together:
        map.put(1,"Anupam");
        map.put(2, "Tara");
        map.put(3, "Shubham");

        System.out.println(map); // key is not stored with " "

        // to access a value using a key
        String student = map.get(3);
        System.out.println(student);
        // if no student exist
        System.out.println(map.get(6)); // null

        // to check if the key 6 is present in the map actually
        System.out.println(map.containsKey(6)); // false

        // We can check if certain value is present in the map
        System.out.println(map.containsValue("Nisha")); // false

        // Looping over map object

        // keySet() method return a set of list, set object is similar to list, but It does not contain duplicates
        Set<Integer> keys = map.keySet();
        for(int k : keys){
            System.out.println(map.get(k));
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        // Map.Entry<Integer, String> this is key and value element type, entrySet() returns a collection of this

        for(Map.Entry<Integer, String> entry: entries){
            // Change all the values to Uppercase
            //System.out.println(entry.getKey() + " : "+ entry.getValue());
            entry.setValue(entry.getValue().toUpperCase());
        }

        System.out.println(map);

        // null entries are allowed
        HashMap<String, Double> scores = new HashMap<>();
        scores.put(null, 2.67);
        scores.put("Jiya", 6.7);
        // if we again put Jiya with a different score, then new duplicate key will never be created it will replace Jiya's score
        scores.put("Jiya", 7.8);
        System.out.println(scores);

        // remove(key) , remove(key, value)
        scores.remove(null);
        System.out.println(scores);
        boolean jiya = scores.remove("Jiya", 5.5);// value is not correct, It won't remove
        System.out.println("Removed Jiya: "+ jiya);

        // Best part is that we get and put in constant time

        List<Integer> list = Arrays.asList(2, 3, 67, 32, 56, 89);
        list.contains(32); // takes O(n) in worst case linear searching
        // Hash takes constant time , how study internal structure of hashmap consisting: Key, Value, Bucket and function

    }
}

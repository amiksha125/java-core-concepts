package Collection_Framework.Map.HashTable;

import java.util.HashMap;
import java.util.Hashtable;

public class Demo {
    public static void main(String[] args) {
        // It has been there even before Collection Framework was introduced, early in JDK 1.0
        // It implements Map
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        // HashTable is synchronized leads to thread safety
        // no null key or value
        // Legacy Class , it is now replaced by ConcurrentHashMap
        // slower than hashmap due to synchronization and overhead
        // After a certain threshold, HashMap uses BST if collision occurs, since it is a legacy class it only uses LL
        // ony linked list in case of collision

        hashtable.put(1, "Apple");
        hashtable.put(2, "Banana");
        hashtable.put(3, "Cherry");

        System.out.println(hashtable);

        System.out.println("Value for key 2 " + hashtable.get(2));
        System.out.println("does key 3 exist "+ hashtable.contains(3));
        hashtable.remove(1);

        // hashtable.put(null, "Null"); // Throws Exception
       // hashtable.put(9, null); // Throws exception

        // Same bucket system is used here

    }
}

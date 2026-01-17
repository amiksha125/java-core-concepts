package Collection_Framework.Map.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    int capacity;
    public LRUCache(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
        // this method is called when pu and putAll methods are called
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);
        // After every 3 elements, the least recently used element should automatically remove
        studentMap.put("Bob", 99);
        studentMap.put("Alice", 89);
        studentMap.put("Ram", 91);
//        studentMap.put("Bob", 26); if you run this then Alice wil remove, bob is used now
        studentMap.put("Amiksha", 89);

        System.out.println(studentMap);

    }
}

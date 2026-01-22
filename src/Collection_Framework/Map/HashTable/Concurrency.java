package Collection_Framework.Map.HashTable;

import java.util.Hashtable;

public class Concurrency {
    // how HashTable is thread safe
    // replace HashMap with HashTable

    public static void main(String[] args) {
        Hashtable<Integer, String> map = new Hashtable<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "thread1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put(i, "thread2");
            }
        });

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Size : "+map.size());
        // All methods are synchronized in HashTable the size will be 200
        // the size is below 2000 in HashTable

        // even read operation is synchronized in HashTable, only one thread can read hash table
        // which is why ConcurrentHashMap came

    }



}

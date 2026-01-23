package Collection_Framework.Map.ConcurrentMap.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class Demo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        // Java 7 --> segment based locking --> 16 segment --> smaller hashmaps
        // Each segment has independent locking
        // We will put and get from a particular segment of map, and the lock will be acquired in that segment
        // ONLY THE SEGMENT BEING WRITTEN TO OR READ IS LOCKED
        // read: do not  require locking unless there is a write operation happening on the same segment
        // write: requires lock
        // no scaling, fixed size segments, if map is huge, segments will be more leading to more waiting
        // cannot update  5 to 6 segments simultaneously

        // Java 8 --> no segmentation
        // USES --> Compare-And-Swap approach --> no locking except resizing or collision
        // Thread A last saw --> x = 42
        // Thread A work --> x to 50
        // In Compare And Swap , While comparing , It checks the value of x last time (last saw), if it is 42
        // is x is still 42, then change it to 50 else don't change and retry
        // no lock is acquired, suppose the value is not 42 during retry it check the value of x again
        // Suppose a thread has changed x from 42 to 35
        // Then it again check if it is 35 if it true then change to 50 else retry
        // The retry loop may run continuously, If CAS is failing over and over then Thread will wait for a while
        // It retrieves the value after Short Random Time


        // In case of HashMap, while putting a value it generates an index it checks if it is empty
        // If it is not empty, It has the value of last saw then If the value is same as last saw then only update else retry

        // Lock will be acquired in case of Resizing or Collision
        // In Collision, we have to modify the linked list, It becomes complex without locking, the lock is acquired at that
        // particular bucket where the collision occurred
        // In Resizing, when load factor or capacity becomes 0.75 then we resize, the resizing process is different in
        // conventional hash map and concurrent hash map, the internal array inside hashmap is immediately doubled when exceeds threshold
        // the storage is not doubled in case of concurrent hash map, there is incremental resizing in concurrent hashmap
        // If the size is full, one more bucket is added, there may happen that two threads try to acquire the same bucket

        // ConcurrentHashMap is thread safe
        // If we have to store key-value in a sorted manner with synchronization
        // MAP --> SORTED + THREAD SAFE --> ConcurrentSkipListMap


//        explore methods


        }
}

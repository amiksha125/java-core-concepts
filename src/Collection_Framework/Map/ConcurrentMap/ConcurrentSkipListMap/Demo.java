package Collection_Framework.Map.ConcurrentMap.ConcurrentSkipListMap;

import java.util.concurrent.ConcurrentSkipListMap;

public class Demo {
    public static void main(String[] args) {
        // The data in stored in a special data structure called skip list.
        // HashMap --> Arrays
        // TreeMap --> RBT
        // the data is stored in sorted manner in ConcurrentSkipListMap with concurrency
        // It is a kind of thread safe TreeMap
        // What is skip List--> This is a probabilistic data structure that allows for efficient search, insertion,
        // and deletion operations.
        // Skip List is similar to a sorted linked list but with multiple layers that "skip" over portions of the list
        // to provide faster access to elements.

        // 1, 2, 3, 4, 5, 6, 7, 8, 9
        // sorted data --> multiple layers --> for faster access
        // at the lowest level, the elements are stored in sorted manner, the level above it will skip some of the elements
        // and again the layer above this will skip some
        //    1 . . . . . . 5. . . . . . 9
        //  1.. 3..5..6..7..9
        // 1 2 3 4 5 6 7 8 9
        // Multiple layers of linked list
        // If we have to search for 2, start with the top layer 5 is < than 2 , go to the second layer
        // after 1 there is 3 , 3 < 2, go to the last level
        // You will find 2

        // The same can be achieved with Red Black Tree in TreeMap, but It requires the complex algorithm for balancing
        // there is less strictness in this, data storage is random and simple to achieve concurrency
        ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();
        // It extends ConcurrentNavigableMap -> a navigable map with concurrency, and NavigableMap
        // ceiling and lower key



        // If you need to sort the pairs use SortedMap, If you want first entry and last entry, closest one then use
        // NavigableMap, If you want Concurrency in hash map then use ConcurrentHashMap, If you want sorted + concurrent
        // then use ConcurrentSkipListMap --> concurrent version of treemap

  // O(log n) time for put, get or remove
        // Instead of bucket it uses sorted linked list with multiple skip levels



    }
}

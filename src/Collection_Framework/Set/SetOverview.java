package Collection_Framework.Set;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetOverview {
    // Set is a collection that cannot contain duplicate elements
    // It is based on HashMap's principal, time to insert, find is O(1)
    // faster operations
    // MAP --> HashMap, LinkedHashMap, TreeMap, EnumMap
    // SET --> HashSet, LinkedHashSet, TreeSet, EnumSet


    // HashSet is an implementation class of Set Interface

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        // We know Map's keySet() method returns the collection of all unique keys
        // Set is map with key only no value. all distinct
        // Methods are similar to list's method

        // Use HashSet() when order of insertion does not matter else use linkedHashSet
        HashSet<Integer> set1 = new LinkedHashSet<>();
        set.add(12);
        set.add(2);
        set.add(2);
        set.add(67);

        set1.add(12);
        set1.add(2);
        set1.add(2);
        set1.add(67);

        System.out.println("Hash Set: "+set);
        System.out.println("Linked Hash Set: "+ set1);
        System.out.println(set.size());
        System.out.println(set.contains(Integer.valueOf(2)));
        System.out.println(set.remove(2));

        // If you want elements in a sorted manner then use TreeSet
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(7);
        System.out.println(treeSet);

        // TreeSet implements Navigable set
        NavigableSet<Integer> st = new TreeSet<>();
        st.add(8);
        st.add(6);
        st.add(1);
        st.add(4);

        System.out.println(st.floor(8)); // eleemnt itself is a floor
        System.out.println(st.ceiling(7)); // ceil of 7 is 8 in the set
        // These are not thread safe

        // for thread safety
        // Collections is a static class
        Set<Integer> integers = Collections.synchronizedSet(st);// it takes a map interface impl class
// it returns a Set which is thread safe
        // synchronizedSet will wrap st into a synchronized block
        // All the methods will be wrapped in a synchronized block
        // All the operations are blocking a thread may not come if any thread is using the map, poor performance
        // TreeSet uses red black tree when collision occur, so this will become more complex as each time the tree gets balanced
        // It is not recommended to use this method


        // The best way is to use ConcurrentSkipListSet
        Set<Integer> set3 = new ConcurrentSkipListSet<>();
        Set<Integer> syncSet = Collections.synchronizedSet(new TreeSet<>());
        // Need to use synchronized block while iterating the syncSet, It is not wrapped
        synchronized (syncSet){
            for(Integer i : syncSet){
                // Safe iteration
                System.out.println(i);
            }
        }

        // similar to unmodifiable map, there can be an unmodifiable set using Set.of()

        Set<Integer> integers1 = Set.of(1, 2, 3);// we can provide any number of entries
        Collections.unmodifiableSet(new HashSet<>(Arrays.asList(2, 4, 6)));

        // There was a SortedMap so
        SortedSet<Integer> stt = new TreeSet<>();



    }
}

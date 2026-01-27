package Collection_Framework.Set;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {

                // All the set implementations are not thread safe
        // if multiple threads try to modify at the same time this will lead to data corruption and
        // concurrent modification exceptions
        // ConcurrentSkipList stores in a sorted manner , this is a requirement when we require range based elements
        // It uses SkipList data structure, but CopyOnWrite uses internal array

        // Thread-Safe
        // Copy-On-Write mechanism - a copy will be created when modifying
        //
        // No Duplicate Elements
        // When loping through set , we are allowed to modify, remeber copy on array list example
        // where there were stable photo we were reading, but a copy was created where the modification was happening
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();

        for(int i = 1; i <= 5; i++){
            copyOnWriteArraySet.add(i);
            concurrentSkipListSet.add(i);
        }

        System.out.println("Initial CopyOnWriteArraySet: "+ copyOnWriteArraySet);
        System.out.println("Initial ConcurrentSkipListSet: "+ concurrentSkipListSet);

        System.out.println("\n Iterating and modifying CopyOnWriteSet: ");
        for(Integer num: copyOnWriteArraySet){
            System.out.println("reading from CopyOnWriteArraySet "+ num);
            // attempting to modify set during iterations
            copyOnWriteArraySet.add(6);
        }
        // It was iterating on a separate copy and It did modify actually

        System.out.println("\n Iterating and modifying CopyOnWriteSet: ");
        for(Integer num: copyOnWriteArraySet){
            System.out.println("reading from CopyOnWriteArraySet "+ num);
            // 6 is added
        }

        // If you do the same with concurrent skip list set then 6 will get added
        // It is weakly consistent set
        // ConcurrentSkipListSet will modify the list while iterating, It may not add 6 sometimes
        System.out.println("\n Iterating and modifying ConcurrentSkipListSet: ");
        for(Integer num: concurrentSkipListSet){
            System.out.println("reading from CopyOnWriteArraySet "+ num);
//            if(num == 5){
//                concurrentSkipListSet.add(6);
//            } not added

            concurrentSkipListSet.add(6); // added


            // If the write heavy operation is performed then CopyOnWrite is not consistent, many copies will
            // be created , more memory consumption
            // Use this in read-intensive operations

            // If frequent read and write is there then use SkipListSet
        }
    }
}

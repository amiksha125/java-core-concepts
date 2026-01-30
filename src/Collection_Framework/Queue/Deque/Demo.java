package Collection_Framework.Queue.Deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {
        // double-ended queue
        // allows insertion and deletion of elements from both ends
        // versatile than regular queues and stacks because they support both the operations of both

        /*
           INSERTION METHODS

           addFirst(E e): Inserts the specified element at the front
           addLast(E e): Insert the specified element at the end.
           offerFirst(E e): Insert the specified elements at the front if possible
           offerLast(E e): Inserts the specified elements at the end if possible.

            */


        /*
           REMOVAL METHODS

           removeFirst(E e): Retrieves and removes the first element.
           removeLast(E e): Retrieves and removes the last element.
           pollFirst(E e): Retrieves and removes the first element, or return null if empty.
           pollLast(E e): Retrieves and removes the last element, or return null if empty.

            */


        /*
           EXAMINATION METHODS

           getFirst(): Retrieves, but does not remove, the first element.
           getLast(): Retrieves but does not remove the last element
           peekFirst(): Retrieves, but does not remove, the first element, or return null if empty.
           peekLast(): Retrieves, but does not remove, the last element, or return null if empty.
         */

        /*

        STACK METHODS

        push(E e): Adds an element at the front (equivalent to addFirst(E e))
        pop(): Removes and returns the first element (equivalent to removeFirst()).
         */
   // This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue
        Deque<Integer> deque1 = new ArrayDeque<>();

        deque1.addFirst(10);
        deque1.addLast(20);
        deque1.offerFirst(5);
        deque1.offerLast(25);
        // 5  10  20  25

        // remove method can throw exception

        System.out.println("First Element: " + deque1.getFirst());
        System.out.println("Last Element: "+ deque1.getLast());

        deque1.removeFirst(); // remove 5
        deque1.pollLast(); // remove 25
        // Current Deque: [10, 20]

        for(int d: deque1){
            System.out.println(d);
        }

        Deque<Integer> deque2 = new LinkedList<>();
        // the same can be done with LinkedList , ArrayDeque is faster because it internally uses array
        // which allows contiguous memory allocation
        // less memory as no need to store pointer to next node
        // no null allowed in ArrayDeque

        // One Note: When we call removeFirst() then ArrayDeque does not perform shifting, It uses circular array
        // there is a head and tail pointer
        // for insert first --> head--
        // for insert last --> tail++

        // if head and tail meet then array is full

        // no need to shift elements, just shift head and tail


        // Use LinkedList when insertion and deletion is priority

    }
}

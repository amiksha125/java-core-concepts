package Collection_Framework.Queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Demo {
    public static void main(String[] args) {
        // LinkedList can act as Queue
        LinkedList<Integer> list = new LinkedList<>();
        // element is inserted at last
        list.addLast(1);
        list.addLast(2);
        list.addLast(3); // enqueue
        // element is removed from front
        list.removeFirst(); // dequeue
        System.out.println(list);
        list.getFirst(); // peek

        // Enqueue: adding element to the queue
        // Dequeue: removing element from front
        // peek: get element at front

        // There is a complexity in using this, addFirst, addLast
        // Java has introduced an interface called Queue
        // it has add() which will add element to the last, and remove() which removes from the front
        // Only necessary methods are there in Queue

        Queue<Integer> queue = new LinkedList<>();
        // LinkedList extends Deque and Deque Implements Queue
        //Queue --> FIFO
        // enqueue --> add at end --> add() / offer()
        // dequeue --> remove head --> remove() / poll()
        // peek --> head --> peek() / element()
        // Queue is an interface, LinkedList and PriorityQueue are implementation classes
        // let us understand difference between such methods

//       System.out.println(queue.remove()); // throws exception if empty
        System.out.println(queue.poll()); // null

        //System.out.println(queue.element()); // throws exception if empty
        System.out.println(queue.peek()); // null

        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2);

        System.out.println(queue2.add(1)); // true
        System.out.println(queue2.offer(2)); // true
        // now capacity is full
        // add() will throw exception and return false
        // offer only returns false but does not interrupt the execution

        System.out.println(queue2.offer(3));
//        System.out.println(queue2.add(3));// exception


    }
}

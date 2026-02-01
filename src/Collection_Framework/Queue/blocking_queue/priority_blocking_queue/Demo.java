package Collection_Framework.Queue.blocking_queue.priority_blocking_queue;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Demo {
    public static void main(String[] args) {
        BlockingQueue<String> queue2 = new PriorityBlockingQueue<>(11, Comparator.reverseOrder());
        // Creates a PriorityBlockingQueue with the default initial capacity (11)
        // that orders its elements according to their natural ordering.

        // Binary heap as array and can grow dynamically
        // head is based on their natural ordering or a provided Comparator like priority queue

        // This is unbounded --> put() wont block

        queue2.add("apple");
        queue2.add("banana");
        queue2.add("mango");
    // mango is head, while apple , banana are in the natural order
        System.out.println(queue2);
    }
}

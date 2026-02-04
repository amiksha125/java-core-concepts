package Collection_Framework.Queue.non_blocking_queue.concurrent_linked_queue;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeDemo {
    public static void main(String[] args) {
        // non-blocking, thread-safe, double ended queue
        // Compare and Swap

        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        deque.add("Element1");
        // as it is double ended queue, use addFirst() and addLast()
        deque.addFirst("Element0");
        deque.addLast("Element3");
        // same methods, excepts it is thread safe, non-blocking
        // create two threads to check if it works with two threads
    }
}

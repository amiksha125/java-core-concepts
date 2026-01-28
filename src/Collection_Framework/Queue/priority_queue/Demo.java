package Collection_Framework.Queue.priority_queue;

import java.util.PriorityQueue;

public class Demo {
    public static void main(String[] args) {
        // part of Queue Interface
        // orders elements based on their natural ordering (for primitives lowest first)
        // custom comparator for customised ordering

        // front element must have the highest priority
        // does not allow null elements

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // stored acc to the natural ordering of integers
        pq.add(50);
        pq.add(10);
        pq.add(30);
        pq.add(5);
        System.out.println(pq.peek()); // 5

        System.out.println(pq); // not sorted

        // get all the element in asc order while popping
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        // internal working
        // PriorityQueue is implemented as a min-heap by default
        // min-heap is binary tree where each internal node's value is less than its children's
        // the smallest element will be at the root, insert at O(log n), remove O(log n), peek O(1)

        // Providing our own order

    }
}

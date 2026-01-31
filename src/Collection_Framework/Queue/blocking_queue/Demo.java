package Collection_Framework.Queue.blocking_queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

class Producer implements Runnable{
    private BlockingQueue<Integer> queue;
    private int value = 0;
    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        while(true){
            System.out.println("Producer produced: " + value);
            try {
                queue.put(value++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(("Producer interrupted"));
            }

        }
    }
}


class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Integer value = queue.take();
                System.out.println("Consumer consumer: " + value);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(("Consumer interrupted"));
            }

        }
    }
}

public class Demo {
    public static void main(String[] args) {
        // thread-safe queue
        // wait for queue to become non-empty / wait for space
        // useful in multithreaded environment
        // eg producer-consumer , producer cannot produce until the queue is empty
        // simplify concurrency problem
        // standard queue --> operations are immediately performed
        // if standard queue is empty --> ( no waiting )
        // if standard queue is full --> add ( no waiting )

        // use blocking queue if it should wait
            // methods -->
            // put --> Blocks if the queue is full until space becomes available
            // take --> Blocks if the queue is empty until an element becomes available
            // offer --> Waits for space to become available, up to the specified timeout


        // A bounded, blocking queue backed by an array
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5); // shared by and  P and C

        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();

        //  as we used put method producer will wait if queue is wait
        // consumer is taking more time 2 sec and producer is waiting for 1 sec
//        If I run , producer produces 0 and consumer ate 0
        // while consumer is taking 2 sec,  producer has producer 2 more values 1 and 2 it is better
        // if queue is full then producer will wait, if queue is empty then consumer will wait
        // great communication

        // There is a another impl class called LinkedBlockingQueue
        BlockingQueue<Integer> queue1 = new LinkedBlockingDeque<>();
        // Creates a LinkedBlockingDeque with a capacity of Integer. MAX_VALUE.
        // optionally bounded
        // out of memory error can come in unbounded queue


    }
}

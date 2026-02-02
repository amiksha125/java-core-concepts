package Collection_Framework.Queue.blocking_queue.synchronous_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Demo {
    public static void main(String[] args) {
        // creates a synchronous queue
       // operations are ordered
        BlockingQueue<String> queue = new SynchronousQueue<>();

        // each insert operation must wait for corresponding remove operation by another thread and vice versa.
        // it cannot store element
        // capacity of atMost one element

        Thread producer = new Thread(() -> {
            try{
                System.out.println("Producer is waiting to transfer...");
                queue.put("hello from producer!");
                System.out.println("Producer has traferred the message.");
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.err.println("Producer was interrupted.");
            }
        });

        Thread consumer = new Thread(() -> {
            try{
                System.out.println("Consumer is waiting to recieve...");
                String message = queue.take();
                System.out.println("Consumer recieved: "+ message);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.err.println("Consumer was interrupted.");
            }
        });

        producer.start();
        consumer.start();

    }
}

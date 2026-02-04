package Collection_Framework.Queue.non_blocking_queue.concurrent_linked_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TaskSubmissionSystem{
    private static ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>();
    // multiple producer are adding to the queue and multiple consumers are processing the data
    // just like Concurrent hash map, Compare and Swap technic  is used
    // In multithreaded environment, it will check where is the tail pointer before adding data,
    // when actually adding check if pointer is at that previous place if yes then add data,
    // if not then another thread has changed something --> retry()
    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            while(true){
                try{
                    taskQueue.add("Task" + System.currentTimeMillis()); // Adds task (will use lock internally)
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while(true){
                try{
                   String task = taskQueue.poll(); // Takes task (will use lock internally)
                    System.out.println("Processing: "+ task);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
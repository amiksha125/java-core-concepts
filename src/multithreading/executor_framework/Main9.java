package multithreading.executor_framework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main9 {
    //Scheduled Executor Service
    public static void main(String[] args) {
        ScheduledExecutorService schedular = Executors.newScheduledThreadPool(1);
//        schedular.schedule(
//                () -> System.out.println("Task executed after 5 second delay !"),
//                3,
//                TimeUnit.SECONDS
//        );
//
        schedular.scheduleAtFixedRate(
                () -> System.out.println("task is executed after 5 second delay.."),
                5,
                5,
                TimeUnit.SECONDS // there is an overlapping here, this will not every task, next will start after 5 sec exactly
        );

        schedular.schedule( () -> {
            System.out.println("Initiating shutdown...");
            schedular.shutdown();
        }, 20, TimeUnit.SECONDS);


        // In schedule(), the task is directly going to queue and schedular waits for it to complete.
        // In scheduleAtFixedRate, task is being performed periodically after a period, they may not get time to get inside queue
        // because of shutdown, let shutdown be handled by schedular after 20 sec
    }
}

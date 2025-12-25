package multithreading.executor_framework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main10 {
    public static void main(String[] args) {
//        Rate = clock based ⏰
//        Delay = rest based 😴
        ScheduledExecutorService schedular = Executors.newScheduledThreadPool(1);
        schedular.scheduleWithFixedDelay(
                () -> System.out.println("task is executed after 5 second delay plus time required for each task.."),
                5,
                5,
                TimeUnit.SECONDS
        );

        schedular.schedule( () -> {
            System.out.println("Initiating shutdown...");
            schedular.shutdown();
        }, 20, TimeUnit.SECONDS);
    }
}

package Collection_Framework.List.Vector;

import java.util.ArrayList;

public class NoThreadsafetyArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //Vector<Integer> list = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });
// the list is being accesses concurrently
        // 500, instant --> size --> 501 instead of 502
        // Change ArrayList to vector to see the change
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
// logically list should have 2000 elements , but it may happen that both t1 access and added at the same time
        // size will always be less than 2000, in this case use Vector
        System.out.println("Size of the list "+ list.size());
    }
}

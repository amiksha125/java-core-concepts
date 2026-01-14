package Collection_Framework.List.CopyOnWriteArrayList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Example {
    public static void main(String[] args) {
        // ArrayList with CopyOnWriteArrayList
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        Thread readerThread = new Thread(() -> {
            try {
                while(true){
                    // Iterate through the list
                    for(String item: list){
                        System.out.println("Reading item: "+item);
                        Thread.sleep(100); // small delay to simulate work
                    }
                }
            }catch (Exception e){
                System.out.println("Exception in reader thread: "+ e);
            }
        });

        Thread writerThread = new Thread(() -> {
            try{
                Thread.sleep(500); // Delay to allow reading to start first
                list.add("Item 4");
                System.out.println("Added item 4 to the list");

                Thread.sleep(500);
                list.remove("Item 1");
                System.out.println("Removed Item 1 frm the list");
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        readerThread.start();
        writerThread.start();

    }
}

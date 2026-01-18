package Collection_Framework.Map.WeakHashMap;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class GC {
    public static void main(String[] args) {
        Phone phone = new Phone("Apple", "16 pro max"); // This is strong reference
        System.out.println(phone);
        phone = null;
        // JVM will find the memory occupied by the object has no corresponding reference
        // I took IIT coaching from an institute, I was lazy and teacher was too, the books I bought had no use,
        // I sold all the books to bhangar , this is garbage collection
        System.gc(); // Don't try to be smarter than the JVM, remove this call to run the garbage collector.
        System.out.println(phone);

        // WeakReference

        WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Nokia", "150"));
        System.out.println(phoneWeakReference.get());
        System.gc();
        try{
            Thread.sleep(10000);
        } catch( Exception ignored){

        }
        System.out.println(phoneWeakReference.get()); // null if we call System.gc()
            }
}

class Phone{
    String brand;

    String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
}

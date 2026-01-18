package Collection_Framework.Map.WeakHashMap;

import java.util.Map;
import java.util.WeakHashMap;

public class Demo {
    // You must know Garbage Collection well

    public static void main(String[] args) {
        // Create a cache of image that is frequently being used
        WeakHashMap<String, Image> imageCache2 = new WeakHashMap<>();
        //An entry in a WeakHashMap will automatically be removed when its key is no longer in ordinary use.
        // More precisely, the presence of a mapping for a given key will not prevent the key from being discarded by the
        // garbage collector, that is, made finalizable, finalized, and then reclaimed.

//        imageCache2.put("img1", new Image("Image 1"));
//        imageCache2.put("img2", new Image("Image 2"));
//        System.out.println(imageCache2);
//        System.gc();
//        simulateApplicationRunning();
//
//        System.out.println("Cache after running (some entries may be cleared): " + imageCache2); // objects are still there
       // WeakHashMap has weak keys , garbage collection will happen only for keys
        // keys are String literals they are stored in String pool, they will become strong referenced throughout the programs
        // even if they are not in use , Java will keep them in memory, that is why they are not removed
        // if img2 is being used 200 times then it would be accessed from same location in pool

        // Create a non-literal keys

//        String key1 = new String("img1");
//        String key2 = new String("img2");
//
//        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
//        imageCache.put(key1, new Image("Image 1 "));
//        imageCache.put(key2, new Image("Image 2"));
//        System.out.println(imageCache);
//        key1 = null;
//        key2 = null;
//        System.gc();
//        simulateApplicationRunning();
//        System.out.println("Cache after running (some entries may be cleared ): " + imageCache); // {} image cache will become null


        // instead of explicitly making null, we should prevent making String key1 literals, directly create instance and prevent
        // creating strong reference
        // if you want you make strong variables , keep it in separate methods loadCache()

        WeakHashMap<String, Image> imageCache1 = new WeakHashMap<>();
        loadCache(imageCache1);
        System.out.println(imageCache1);
        // avoid making keys null
        System.gc(); // key are not strong
        simulateApplicationRunning();
        System.out.println("Cache after running (some entries may be cleared ): " + imageCache1);


    }

    public static void loadCache(Map<String, Image> imageCache){
        String k1 = new String("Image1");
        String k2 = new String("Image 2");
        // these string keys are strongly referenced in this scope only
        imageCache.put(k1, new Image("Image 1"));
        imageCache.put(k2, new Image("Image 2"));

    }
    private static void simulateApplicationRunning() {
        try{
            System.out.println("Simulating application running...");
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

//String literals are strongly referenced by the String Pool, so they are usually not
// garbage-collected, and therefore not removed from a WeakHashMap.

// WeakHashMap stores its keys as weak references.
//If a key object is no longer strongly referenced anywhere else in the application, the Garbage Collector
// can reclaim it, and the corresponding entry is automatically removed from the map.
//Values are strongly referenced, so only keys control removal.
//String literals are stored in the String Constant Pool, which holds strong references for the lifetime
// of the program; therefore, String literals used as keys will not be garbage-collected and their entries
// will remain in a WeakHashMap.
//To allow garbage collection, keys should be non-literal objects (e.g., new String()), and no strong
// reference to them should exist outside the map.
//WeakHashMap is commonly used for memory-sensitive caches, where unused entries should be removed automatically.

class Image{
    private String name;

    public Image(String name){
        this.name = name;
    }


}

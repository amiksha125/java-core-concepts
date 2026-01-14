package Collection_Framework.List.CopyOnWriteArrayList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        // "Copy on Write" means that whenever a write operation
        // like adding or removing element is performed
        // instead of directly modifying the existing list
        // a new copy of the list is created, and the modification is applied to that copy
        // This ensures that other threads reading that list while it's being modified are unaffected.

        // Read Operations: fast and direct, since they happen on a stable list without interference from modification
        // Write Operation: A new copy of the list is created for every modification.
        //                  The reference to the list is then updated so that subsequent reads use this new list.

        // notepad is being used and read by multiple users, if any changes has to be made in the notepad, a notepad-copy
        // is created preventing users from being confused and interrupted

        // CopyOnWriteArrayList is recommended to use in read-intensive tasks
        // read is performed on a snapshot while write is being performed on separate copy, we can perform both
        // reading and writing at same time , but not with ArrayList is gives exception --> ConcurrentModificationException
        // change ArrayList to CopyOnWriteArrayList to see its use, List is parent of both
        // in CopyOnWrite loop is reading different copy and write is perfformed on new copy

        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Bread");
        shoppingList.add("Eggs");
        System.out.println("Initial Shopping List: " + shoppingList);

        for(String item: shoppingList){
            System.out.println(item);
            // Try to modify the list while reading
            if (item.equals("Eggs")){
                shoppingList.add("Butter");
                System.out.println("Added butter while reading");
            }
        }
        // at the end , shoppingList = new List
        System.out.println("Updated Shopping List: " + shoppingList);

    }
}

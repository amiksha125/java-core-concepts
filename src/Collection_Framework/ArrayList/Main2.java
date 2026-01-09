package Collection_Framework.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        // Ways to create an ArrayList

        // Default constructor, creates an empty ArrayList with an initial capacity of 10
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.getClass().getName()); // original ArrayList

        // Creating an ArrayList with the specified initial capacity
        ArrayList<String> listWithCapacity = new ArrayList<>(20);

        // Creating an ArrayList from another collection using Arrays.asList()
        List<String> anotherList = Arrays.asList("Apple", "Mango", "Banana"); // returns List<T>, returns parent of ArrayList
        ArrayList<String> listFromCollection = new ArrayList<>(anotherList);
        System.out.println(anotherList.getClass().getName()); // Not original It is a nested static private class
        // we cannot add or remove elements from anotherList, we can replace only using set()
//        anotherList.add("Orange");
          anotherList.set(2, "Orange");
        System.out.println(anotherList); // asList() returns a fixed size array

        // After java 8, in Java 9, you are allowed to create List using of(), It also returns a fixed List, you cannot even use set
        List<Integer> integers = List.of(1, 2, 3, 4);
//        list.set(2, 5); exception

        // You can make these list modifiable by passing them on ArrayList<>(List Object) constructor, pass collection
        ArrayList<Integer> arrayList = new ArrayList<>(integers);
        arrayList.add(5);
        System.out.println(arrayList);

        String[] array = {"Hui", "Hai", "Keyo"};
        List<String> list1 = Arrays.asList(array);

        // Adding elements
        ArrayList<String> l = new ArrayList<>();

        // Adding elements to the end of the list
        list.add("Apple");
        list.add("Banana");

        // Adding an element at a specific index
        list.add(1, "Orange"); // Orange will be added at index 1, shifting Banana to index 2

        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(0, 0);

        List<Integer> l2 = List.of(3, 4, 5, 6, 7); // immutable

        l1.addAll(l2);
//        l2.addAll(l1); impossible
        System.out.println(l1);

        list1 = new ArrayList<>(list1);
        // Accessing Elements
        String s = list1.get(1);

        // Modifying Elements
        list1.set(1, "Hatori");

        // Remove Elements

        // by index
        list1.remove(0);
        // by value
        list1.remove("Hatori");

        System.out.println(list1);
    }
}

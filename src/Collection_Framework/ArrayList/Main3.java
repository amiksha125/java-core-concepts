package Collection_Framework.ArrayList;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main3 {
    public static void main(String[] args) {
        // remove(index) vs remove(Object o)
        // In case of Integer ArrayZList if removing value by specifying the value , it will by default use remove(index)
        // and remove element at that index
        // remove(Object o) accepts class type so pass

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // I have to remove 1
        //list.remove(1); // wont work, It will remove 2 value (index 1)

        list.remove(Integer.valueOf(1)); // removes first occurrence of 1
        System.out.println(list);

        // Checking for elements using contains()

        boolean hasTwo = list.contains(2);
        System.out.println(hasTwo);

        // Print number of elements in list
        System.out.println(list.size());

        // Converting to Array

        ArrayList<String> metalList = new ArrayList<>();
        metalList.add("Pan");
        metalList.add("Cup");
        metalList.add("Spoon");
        metalList.add("Plate");

        // pass a new array of size 0 as an argument in toArray()
        String[] metals = metalList.toArray(new String[0]);
        System.out.println(Arrays.toString(metals));

        // Sorting an ArrayList using Collections.sort(ArrayList)

        Collections.sort(metalList); // returns void, modifies original list

        System.out.println(metalList);

        // Collections.sort itself uses sort method of list accepting comparator

        list.sort(null); // c is comparator, will work same


    }
}

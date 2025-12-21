package generics.Wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public void printArrayList(ArrayList<?> list){
        for(Object o: list){
            System.out.println(o);
        }
    }
    // Not here
    public <T> T getFirst(ArrayList<T> list){
        return list.get(0);
    }

    public <T> void copy(ArrayList<T> source, ArrayList<T> distination){
        for(T item: source){
            distination.add(item);
        }
    }

    public static void main(String[] args) {
        // You can read any type ?, but cannot add or modify
        //Example

        ArrayList<?> list = new ArrayList<String>();
//        list.add("Hi"); we cant add

        // lower bound is Integer we can add all the values of its upper class
        List< ? super Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.add(1);
        numbers.add(null);

    }
}

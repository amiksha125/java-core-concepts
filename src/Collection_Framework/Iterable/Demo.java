package Collection_Framework.Iterable;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : list){
            System.out.println(i);
        }

        // java internally transform the above code into:

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // Iterator provides removal functionality while accessing
        // ArrayList gives ConcurrentModificationException
        // use CopyOnWriteArrayList

        List<Integer> numbers = new CopyOnWriteArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        for(Integer number : numbers){
            if(number % 2 == 0){
                numbers.remove(number);
            }
            System.out.println(number);
        }

        // after remove
        System.out.println(numbers);

        Iterator<Integer> itr = numbers.iterator();
        while(itr.hasNext()){
            Integer number = itr.next();
            if(number % 2 == 0){
                itr.remove(); // very powerful, iterating and removing
            }
        }

        // There is a listIterator with more advance methods

        List<Integer> nbr= new ArrayList<>(Arrays.asList(1, 2, 3));

        ListIterator<Integer> it = nbr.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set(4);
        }

        System.out.println(nbr);
    }
}

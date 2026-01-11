package Collection_Framework.LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
//        linkedList.add(3);

        Integer i = linkedList.get(2); // O(n)

        // It has special addLast() and addFirst()

        linkedList.addLast(4); // O(1)
        linkedList.add(2, 3);
        linkedList.addFirst(0); // O(1)

        System.out.println(linkedList);

        // getFirst() and getLast()
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        // remove(). remove(index), remove(Object o), removeFirst(), removeLast(), removeFirstOccurrence() last, removeIf()

        // removeIf accepts predicate a lambda expression, use case is to filter based on condition

        linkedList.removeIf(x -> x % 2 == 0);

        System.out.println(linkedList);

        // Collection.removeAll(Collection)
        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "Elephant"));
        LinkedList<String> animalToRemove = new LinkedList<>(Arrays.asList("Dog", "Lion"));

        animals.removeAll(animalToRemove);
        System.out.println(animals);

        // This is behaving as List, It so powerful that it behaves like Stack and Queue


    }
}

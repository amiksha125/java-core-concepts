package Collection_Framework.List.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // push(element), pop()

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        Integer removed = stack.pop();
        System.out.println("Popping top..  " + removed );
        System.out.println(stack);

        // To check the Stack top use peek()

        System.out.println("The top element is now our.. "+stack.peek());

        // isEmpty() and size()
        // search: position of element from stack top
        stack.search(Integer.valueOf(3)); // 1
        // 4 - 0 index
        // 3 - 1 index
        // 2 - 2 index

        // The above is all about Stack Usage in java
        // It follows the Vector Class, so you can insert element at any position , but this may violate Stack's principal


        // Using LinkedList as a Stack

        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3); // push

        list.getLast(); // peek

        list.removeLast(); // pop

        // Use LinkedList as Stack in single threaded environment as Stack is synchronized

        // Using ArrayList as Stack

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(7); // push
        arrayList.get(arrayList.size() - 1); // peek
        arrayList.remove(arrayList.size() - 1); // pop
           // but not preferred to use this
    }
}

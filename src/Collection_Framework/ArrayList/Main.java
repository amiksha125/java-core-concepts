package Collection_Framework.ArrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        // ArrayList is Generic class (type safe)
        // new ArrayList<Integer> is omitted after Java 7

        list.add(1); // 0
        list.add(5); // 1
        list.add(60);// 2
        // 0-based indexing
        System.out.println(list.get(2));
        System.out.println(list.size());

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        // for each loop
        for(int x: list){
            System.out.println(x);
        }

        // to check for existence of element
        System.out.println(list.contains(5));
        System.out.println(list.contains(50));

        // remove(index)
        list.remove(1);
        // toString is also overridden by ArrayList, print the list
        System.out.println(list);

        // add() is overloading in ArrayList with add(index, element)
        list.add(1, 10);
        System.out.println(list);

        //add(index, element) does not replace elements, it shifts the element
        list.add(1, 5);
        System.out.println(list);

        // set(index, element) replaces the element at that position is removed from list
        list.set(1, 20);
        System.out.println(list);

        ArrayList<Integer> arrayList = new ArrayList<>(1000); // less overhead
        System.out.println(arrayList.size()); // 0

    }
}

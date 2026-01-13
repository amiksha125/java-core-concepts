package Collection_Framework.List.Vector;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        // unlike arraylist we can access the internal capacity of vector
        System.out.println(vector.capacity());

        Vector<Integer> vec2 = new Vector<>(14);
        System.out.println(vec2.capacity());
        // the size will double after adding 14 elements

        // We can specify the increment value instead of doubling the size
        Vector<Integer> vec3 = new Vector<>(5, 3);
        vec3.add(1);
        vec3.add(1);
        vec3.add(1);
        vec3.add(1);
        vec3.add(1);
        vec3.add(1);

        System.out.println(vec3.capacity()); // 5 + 8

        Vector<Integer> vector1 = new Vector<>(Arrays.asList(2, 3, 4));
        System.out.println(vector1);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Santoor");
        linkedList.add("Dove");
        Vector<String> strings = new Vector<>(linkedList);

        for(int i = 0; i < strings.size(); i++){
            System.out.println(strings.get(i));
        }
        System.out.println(vector1.size());

        System.out.println(vector1.isEmpty());

        linkedList.clear();

        System.out.println(linkedList);
    }
}

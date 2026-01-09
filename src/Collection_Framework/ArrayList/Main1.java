package Collection_Framework.ArrayList;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // using reflection try to find the capacity

        ArrayList<Integer> list = new ArrayList<>(11);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: "+ elementData.length);

        list.add(1);

        elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: "+ elementData.length); // 16

        list.remove(2);

        elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: "+ elementData.length); // 16

        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);

        elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: "+ elementData.length); // 16

        // the capacity is not shrunk automatically, we can explicitly do that

        list.trimToSize(); // updates internal array's size, shrink that

        elementData = (Object[]) field.get(list);
        System.out.println("ArrayList capacity: "+ elementData.length); // ? ask to gpt now, vid 27.40

    }
}

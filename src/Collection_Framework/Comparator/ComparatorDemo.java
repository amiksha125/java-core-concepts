package Collection_Framework.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String> { // specify type while implementing
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }

    // o1 comes first if compare returns negative, means when s1.length() - s2.length()
    // "ok" "bye" -> return negative for asc order s1 - s2, and for desc return positive (o2 first) s2 - s1
    //  s1   s2


}

class MyComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1; // ascending order
    }

    // negative return -> o1 should come first
    // positive return -> o2 should come first

    // ascending order is our goal
    // 5 6 -> what to do to return negative so that 5 comes first -> o1 - o2
    // 8 4 -> what to do to return positive so that 4 comes first -> o1 - o2

    // descending order
    // 3 6 -> o2 should come first compare must return positive -> o2 - o1
    // 6 3 -> o1 first It must return negative -> o2 - o1


}

public class ComparatorDemo {
    public static void main(String[] args) {
         List<Integer> list = new ArrayList<>();
         list.add(2);
         list.add(1);
         list.add(4);
         list.add(3);

         list.sort(new MyComparator()); // ascending order Comparator
         System.out.println(list); // o1 - o2
        // sort in descending order using comparator impl class
        list.sort(new MyComparator());
        System.out.println(list); // o2 - o1

        // sort the list of String in asc order of their length

        List<String> list1 = Arrays.asList("banana", "apple", "date");
        list1.sort(new StringLengthComparator()); // sort takes Comparator
        System.out.println(list1);

        // use lambda expression to sort in descending order
        list1.sort((a, b) -> b.length() - a.length());
        System.out.println(list1);

    }
}

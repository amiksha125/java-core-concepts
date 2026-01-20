package Collection_Framework.Map.Comparable;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    // To apply a custom sorting logic
    public static void main(String[] args) {
        // sort method requires comparator/comparable
        // if sort(null) then the natural order of sorting is ascending in case of Integers
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(18);
        nums.add(0);
        nums.add(2);
        nums.sort(null);
        System.out.println(nums); // no exception , nums is sorted in asc
        // this list.sort(null) will not work for List of Student and will throw exception
        // to prevent this, the Student class must extend the comparable interface to add custom sorting logic
        List<Student> list = new ArrayList<>();
        list.add(new Student("Charlie", 3.5));
        list.add(new Student("Bob", 3.7));
        list.add(new Student("Alice", 3.5));
        list.add(new Student("Akshit", 3.9));

//        list.sort(null); will throw exception
// We write the compareTo() method in the Class whose object we want to sort, that class has to implement Comparable
        // Comparator has compare method, we can define multiple criteria in Comparator and write a custom logic
        // We write sorting logic inside class in case of comparable, comparable does natural ordering we can pass null, it will call
        // When things needs to be sort along multiple fields then use Comparator.
        // // A way to define natural ordering which is common is through Comparable
        // Attendance is taken based on roll no this is natural ordering , can be done through comparable/
        // And when we write compareTo method in the Class and does list.sort(null) then this logic is called automatically.
        // compare (o1, o2) takes two arguments which is outside class, this.compareTo(o1) takes only one(inside class)

      // man se toh compareTo to one object, method is called by current instance, and compare takes two things to compare


        list.sort(null);
        System.out.println(list);






        // use comparable when there is one natural (default) way to sort the objects.
        // the sorting logic belongs to the class itself
        // eg sort student by roll no or employees by id

        // use comparator when you need multiple sorting logics
        // You cannot modify the class
        // Sorting logic should be outside the class
        // eg Sort students by marks, sort students by name




    }
}

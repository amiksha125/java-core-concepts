package Collection_Framework.Comparator;

import java.util.*;

public class Student {
    private String name;

    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Charlie", 3.5));
        studentList.add(new Student("Bob", 3.7));
        studentList.add(new Student("Alice", 3.5));
        studentList.add(new Student("Aksh", 3.9));

        //studentList.sort(null); // natural ordering asc but on basis of what ? exception

        // create a list, students having maximum gpa will be at top

        // Akshit Bob , Akshit should come before o1 should come before , It must return negative
        //  3.9  3.7 -> 3.7 - 3.9 -> -0.2 -> o2 - o1
        // studentList.sort( (o1, o2) -> (int) (o2.getGpa() - o1.getGpa())); compare should strictly return 1, 0, -1 not in decimal

        // if ans is < 0 then -ve means -1 and > 0 means positive return 1

        studentList.sort((o1, o2) -> {
            if(o2.getGpa() - o1.getGpa() < 0){
                return -1;
            } else if (o2.getGpa() - o1.getGpa() > 0){
                return 1;
            } else {
                return 0;
            }
        });


        for(Student s : studentList){
            System.out.println(s.getName() +": " +s.getGpa());
        }

        // This has simplified in Java 8
        // :: a method reference
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed();// takes method
        studentList.sort(comparator); // in asc
        for(Student s : studentList){
            System.out.println(s.getName() +": " +s.getGpa());
        }

        // in desc -> Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed();

        // if we want the list of students in desc order acc to their gpa and same gpa then asc order based on their name:
        // chaining
        Comparator<Student> studentComparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        studentList.sort(studentComparator);

        for(Student s : studentList){
            System.out.println(s.getName() +": " +s.getGpa());
        }

        // we can do the same in comparator code also
        // if gpa is same then it must return 0 means in the else we will write logic of comparing their names
        // there is compareTo() func to compare two string it is the same
        // -ve means o1 first, and +ve means o2 first
        studentList.sort((o1, o2) -> {
            if(o2.getGpa() - o1.getGpa() < 0){
                return -1;
            } else if (o2.getGpa() - o1.getGpa() > 0){
                return 1;
            } else {
               return o1.getName().compareTo(o2.getName());
        }
    });

        for(Student s : studentList){
            System.out.println(s.getName() +": " +s.getGpa());
        }

        // We can give cComparator in Collection.sort() also
        Collections.sort(studentList, studentComparator);
    }
}

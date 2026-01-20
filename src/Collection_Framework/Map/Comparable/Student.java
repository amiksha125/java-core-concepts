package Collection_Framework.Map.Comparable;

public class Student implements Comparable<Student> {
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


    @Override
    public int compareTo(Student o) {
        // sort based on gpa in desc order
        // 4.compareTo(3) => 4 then 3 o1 then o2 means it has to return negative for this
        // o is o2 here, and the object who is calling is o1, ==> o.gpa - this.gpa
        // when 3 is subtracted from 4 ==> -1
//        return ((int) o.getGpa() - this.getGpa());
        // Double has compare(o1, o2) method
        return Double.compare(o.getGpa(), this.getGpa());
    }

    @Override
    public String toString() {
        return "Student{ " +
                "name = "+ name + '\'' +
                ", gpa = " + gpa +
                '}';
    }
}

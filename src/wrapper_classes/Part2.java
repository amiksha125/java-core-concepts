package wrapper_classes;

public class Part2 {
    public static void main(String[] args) {

        // we can play around these wrapper classes
        // Integer can hold null, but primitives can not
        Integer i = null;
//        int i = null;

        System.out.println(Integer.max(5, 8));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.min(3, 9));
        String str = "123";

        // Casting String to Integer , use valueOf
        Integer strVal = Integer.valueOf(str);
        double v = strVal.doubleValue();
        Double d = v;

        // Very important
        Student x = new Student();
        x.id = 1;
        fun(x);
        // what is the output of x.id
        System.out.println(x.id); // x wil point to the same object

    }

    private static void fun(Student a){
        Student student = new Student();
        student.id = 2;
        a = student; // a and student holds same address, they are reference variable pointing to Student object
        // now a  new object of id 2 is created which is assigned to a, a will point to different object in heap
        // but x still points to student with id attribute 1
        // only reference variable changes , no object changed here

        // but value changes by one reference variable will be reflected to all pointing the object
    }
}

class Student {
    public int id;
}

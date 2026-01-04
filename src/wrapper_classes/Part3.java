package wrapper_classes;

public class Part3 {
    private static void fun(Student1 a) {
        a.id = 2;
        // here the object is changes !
    }

    private static void fun(Integer b){
        b = 2; // b initially stored 1, will now store 2, a won't be changed
    }

    public static void main(String[] args) {
        Student1 student1 = new Student1();
        student1.id = 1;
        fun(student1);
        System.out.println(student1.id);
        // not same in case of wrapper class

        Integer a = 1;
        fun(a);
        System.out.println(a);// not changes

        int x = 2;
        int y = 2;
        // == with primitive types compares actual values
        System.out.println(x == y);

        Integer b = 2;
        Integer c = 2;
        // here b and c store references(memory addresses)
        // so == compares references in case of classes not values
        // Why does this print true : Java uses Integer Caching for values from -128 to 127
        // means both b and c will be pointing to the same cached object, 2 is in the range (-128 to 127)
        // take value out of the range and compare
        System.out.println(b == c);
        b = 200;
        c = 200;
        System.out.println(b == c); // false
        System.out.println(b.equals(c)); // simply compares object values not references

    }

}
class Student1 {
    public int id;
}

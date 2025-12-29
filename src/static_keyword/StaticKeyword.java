package static_keyword;

public class StaticKeyword {
    public static void main(String[] args) {
        // the static keyword in Java is used for memory management primarily.
        // It can be applied to variables, methods, blocks and nested classes.

        // The main concept behind static is that it belongs to the class rather than instances of the class

        // Even if the data member of the class is public, it can only be accessed with the instance via . operator
        // Data members can only be accessed by creating object.

//        static_keyword.Student student = new static_keyword.Student();
//        student.setName("Sham");  // out of the topic
//        System.out.println(student.getName()); hardcoded value will be changed, interview ques

        // If a data member of a class needs to be accessed by the class itself, then make it static.
        // variable name becomes italic
        // the count of the students needs to be increased each time an instance is created.
        // increment count in constructor

        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        Student student5 = new Student();
        Student student6 = new Student();
        // access static member with ClassName.variableName
        System.out.println("Total number of students = "+Student.count);
       // if you create count as a instance member and try to access with object then count will always become 1,each time a new copy of count will be created for each object
        // There will always be a single copy of static member beings hared by all the objects
        // count is not attached to any object and is a common property for all students
        // As there is a single copy of static in memory, the memory is saved

        // main method is static because JVM will directly call main without creating any object of StudentKeyword
        Student.getCount();

        // non-static field like 'age', 'name' cannot be referenced from s static method or context,
        // static method cannot use non-static data members or call non-static method directly
        int c = sum(2, 6);

        // this and super cannot be used in static context

        // static variables are initialized before any instance is created

    }

    public static int sum(int a, int b){
        return a + b;
    }
}

class Student{
    // count of students
    public static int count = 0;

    Student(){
        count++;
    }

    private int id;
    private String name = "Ram";
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // static method
    public static void getCount(){
        System.out.println("Count is "+count);
    }
}

package generics;

public class Box<T> {

    private T value;
    // Object is a super class of all the classes, It can store all wrapper class objects

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    public static void main(String[] args) {
//        Box box = new Box();
//        box.setValue(1);
//        String i = (String) box.getValue();
//        System.out.println(i); //exception without generics

        //Solution is to create Box class a generic type
        // How: Box<T>, declare private T value, accept T and return T
        // T will accept any type

        Box<Integer> box = new Box<>(); // Box is now type safe
        box.setValue(12);
        //String i =  box.getValue(); // 🙂 we are getting compile time alert cool
        Integer i = box.getValue();
        System.out.println(i);

    // Convention style to create a generic type
        // Class<T> you can write single uppercase alphabet no rule as such
        // this placeholder will be replaced during runtime and object creation
        // you can play with any type through generics with type safety at compile time
        // generic class can have multiple parameters, go to Pair
    }
}

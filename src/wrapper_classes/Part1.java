package wrapper_classes;

public class Part1 {
    public static void main(String[] args) {

        String str = "amiksha";
        str.length();
        int a = 1; // data stored in stack
        // a. no methods are suggested for a because It is not an object
        // because int is not a class, it is a primitive data type

        // There are many use cases where it is strictly required to use Objects
        // for example ArrayList of integer can not be made with int data type
        // the type argument cannot be primitive data type
        // Wrapper classes will be used in these cases, they transfer basic data types into objects

        Integer b = 1; // b is a reference variable of class Integer and 1 will be stored in heap (just like instances of class)
        float floatValue = b.floatValue();

        boolean hasGraphicCard = true;
        Boolean isAdult = true;

        Float f = 1.4f;// f in the last
        Double d = 1.45;
        Character c = 'p';
        Byte bb = 1;
        Short s = 2;
        Long l = 6L; // l in the last

        // behind the scenes
        Integer i = Integer.valueOf(1); // Unnecessary boxing , Java automatically does this
        int i1 = i.intValue(); // Unnecessary unboxing
        int i2 = i; // automatic unboxing


    }
}

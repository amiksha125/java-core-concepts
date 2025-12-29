package static_keyword;

public class StaticBlock {
    // Static block is executed when the class is loaded into memory and executed only once!
   // They are used to initialise static member
    // For static initialization one time set up tasks
    static {
        System.out.println("Hello");
        isStudying = true;
    }

    private static boolean isStudying;

    public boolean get(){ // non-static function can access and modify static data member
        return isStudying;
    }

    public static void main(String[] args) {
        StaticBlock block = new StaticBlock();
        System.out.println(block.get() ? "Yes" : "No");
    }

    // static methods can be created in Utility classes, where we use them using className without creating object
}

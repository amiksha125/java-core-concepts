package interfaces;

public interface Animal {

     int MAX_AGE = 150; //by default public static final

    public abstract void eat();// Modifier 'abstract' is redundant for interface methods

    void sleep();

    // Now an interface can have static method, as static members are not attached to object(interface cannot be instantiated)
    // They do not need to be implemented by derived class like the above abstract methods
    // Similarly, these static methods are not accessed by the className that implements this interface
    public static void info(){
        System.out.println("This is an Animal interface.");
    }

    // default method is magic, reducing redundancy
    // suppose there are 100 implementation classes, the abstract classes must be overridden in each of them
    public default void run(){
        this.eat();
        System.out.println("Animal is running..");
    }
}

package interfaces;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("Dog is eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping...");
    }

    // class can have its own methods too
    public void bark(){
        System.out.println("Dog is barking...");
    }
}

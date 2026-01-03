package interfaces;

public class Cat implements Animal{

    @Override
    public void eat() {
        System.out.println("Cat is eating..");
    }

    @Override
    public void sleep() {

    }

    // default method can be overridden, but function will be implemented at interface
    @Override
    public void run() {
        Animal.super.run();
    }
}

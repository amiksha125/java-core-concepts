package inner_classes.member_inner_class;

public class Test {
    public static void main(String[] args) {
        Car car = new Car("Tata safari");
        // inner class is associated with instance of outer class
        // instance of inner class only be created with help of instance of outer class
        Car.Engine engine = car.new Engine();
        // inner class behaves as an member of outer class, methods cannot be called without creating outer class's object
        engine.start();
        engine.stop();
    }
}

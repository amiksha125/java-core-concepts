package generics.BoundedTypeParameters.MultipleBound;

interface Printable{
    void print();
}

class MyNumber extends Number implements Printable{
    private final int value;

    public MyNumber(int value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.println("MyNumber: "+value);
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }
}

// ⭐ class with multiple bound
class Box<T extends Number & Printable>{
    // T ke jagah sirf wo class aa skti hai jo number ko extend kare aur printable ko impement

    private T value;

    public Box(T item){
        this.value = item;
    }
    public T getValue() {
        return value;
    }

    public void display(){
        value.print();
    }
}
public class Test {
    public static void main(String[] args) {
        //MyNumber is perfect, it extends Number and implements Printable

        MyNumber myNumber = new MyNumber(1);
        Box<MyNumber> box = new Box<>(myNumber);
        box.display();

    }
}

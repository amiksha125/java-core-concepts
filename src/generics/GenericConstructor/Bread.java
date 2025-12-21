package generics.GenericConstructor;

public class Bread {
    public <T extends Number> Bread(T data){
    }

    public static void main(String[] args) {
        Bread b = new Bread(2);
    }
}

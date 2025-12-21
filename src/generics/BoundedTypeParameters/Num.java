package generics.BoundedTypeParameters;

public class Num< T extends Number>{
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
       // error String not withing Number Num<String> n = new Num<>();
        Num<Float> n = new Num<>();
        n.setData(5.38f);
        System.out.println(n.getData());

    }
}

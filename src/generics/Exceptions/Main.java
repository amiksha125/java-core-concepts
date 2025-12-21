package generics.Exceptions;

class MyException extends Exception{
    public <T> MyException(T value){
        super("Exception related to value: " + value.toString() +
                " of type: "+ value.getClass().getName());
    }
}
public class Main {
    public static void main(String[] args) {
        try{
           throw new MyException(23);
        } catch(MyException e){
            System.out.println("Caught exception: " + e.getMessage());
        }

        try{
            throw new MyException("String");
        } catch(MyException e){
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}

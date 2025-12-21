package generics.GenericMethod;

public class MethodOverloading {

     public static <T> void display(T element){
         System.out.println("Generic display: "+ element);
     }

     public static void display(Integer element){
         System.out.println("Integer: "+ element);
     }

    public static void main(String[] args) {

         display(1);
         display(1.2);

    }
}

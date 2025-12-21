package generics.GenericMethod;

public class Test {

    public <T> void printArray(T[] array){
       for(T element: array){
           System.out.print(element+ " ");
       }
        System.out.println();
    }
    public static void main(String[] args) {
        Test t = new Test();
        Integer[] intArr = { 1, 2, 3, 4, 5};
        t.printArray(intArr);

        String[] stringAr = {"Hello", "Amiksha", "Namaste"};
        t.printArray(stringAr);
     }
}

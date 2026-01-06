package Exception;

public class Test {
    public static void main(String[] args) {
        int[] num = {10, 200, 30, 40};
        int[] den = {1 ,2 , 0, 5};

        for(int i = 0; i < 10; i++){
            // at i = 2 ArithmeticException: / by zero
            // the execution is disrupted, not preceded for 3 index
           try{
               System.out.println(divide(num[i], den[i]));
           } catch (ArrayIndexOutOfBoundsException | NullPointerException e){
               System.out.println(e);
            }
        }
        System.out.println("Gob done!"); // flow will not react this statement
    }

    private static int divide(int i, int i1) {
        try{
            return i / i1;
        } catch (ArithmeticException e){
            System.out.println(e);
            return -1;
        }
    }
}

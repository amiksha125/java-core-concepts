package Exception;

public class ThrowK {


    public static void func(){
        throw new ArithmeticException(); // unchecked that's why no error by compiler
    }

    public static void func1(){
        // throw new Exception(); // checked that's why  error by compiler
    }

    public static int divide(int a, int b){
        try{
            return a / b;
        } catch(Exception e){
            return -1;
        }finally{
            System.out.println("Hello"); // hello is printed first then -1 is returned and printed, only in case of return
        }

       // System.out.println("Hello"); // no msg can be printed after return statement, But finally makes it possible.
    }

    public static void yo(){
        try{
            System.out.println("Inside try block");
            int result = 7 / 0;
        } catch (Exception e){
            System.out.println("Exception caught: "+e);
        } finally {
            System.out.println("Inside finally block");
        }
    }

    public static void main(String[] args) {
        System.out.println(divide(1, 0));
        yo();
    }
}

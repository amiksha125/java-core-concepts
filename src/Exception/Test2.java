package Exception;

public class Test2 {
    public static void level3(){
        int[] array = new int[5];
        array[5] = 10;
    }

    public static void level2() {
        level3();
    }


    private static void level1() {
        level2();
    }

    public static void main(String[] args) {
        try{
            level1();
        } catch(Exception e){
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                System.out.println(stackTrace[i]); // exception is handles

                // one more
                e.printStackTrace();
            }
        }
    }

    }

// Stack trace that provides detailed information about method calls that leads to exception
// It is a snapshot of call stack from main to level3
//at Exception.Throw.level3(Test2.java:6)
//at Exception.Throw.level2(Test2.java:10)
//at Exception.Throw.level1(Test2.java:18)
//at Exception.Throw.main(Test2.java:14)
package Exception.checkedExceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception{
        method2();
        System.out.println("hello"); // program ended successfully by JVM but did not reach here
    }

    public static void method2() throws IOException {
        method1();
    }

    private static void method1() throws FileNotFoundException{
        FileReader fileReader = new FileReader("a.txt");
    }
}

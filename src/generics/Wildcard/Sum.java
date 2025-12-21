package generics.Wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
public class Sum {

    public static double sum(List<? extends  Number> numbers){
        double sum = 0;
        for(Number o: numbers){
            sum += o.doubleValue();
        }
        return sum;
    }

    public static void printNumber(List<? super Integer> list){
        for(Object obj : list){
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        // AsList() takes comma separated elements and convert then into arrayList
        System.out.println(sum(Arrays.asList(1, 2.2, 33, 23)));
    }
}

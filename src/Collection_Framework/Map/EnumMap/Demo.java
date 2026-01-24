package Collection_Framework.Map.EnumMap;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    // a HashMap where key is enum
    public static void main(String[] args) {
       Map<Day, String> map = new EnumMap<>(Day.class);
       // Convert this Map to an EnumMap.

        // If all the keys in a Map are values from a single enum, It is recommended to use an EnumMap as a
        // specific implementation. An EnumMap which has the advantage of knowing all possible keys in advance,
        // is more efficient compared to other impl. as it can use a simple array as its underlying data structure.

        Map<Color, String> colorMap = new EnumMap<>(Color.class); // Color.class -- specify which enum u r using

        // No need of resizing, It knows all the key in advance
        // In normal hashmap , hashcode and bucket index is generated
        // Each enum instance has an ordinal value which is used to map to a bucket
        // A unique index(ordinal) is automatically generated and no need of hashing
        // no collision and faster access
//        System.out.println(Day.WEDNESDAY.ordinal());
        map.put(Day.TUESDAY, "Gym");
        map.put(Day.MONDAY, "Temple");
        System.out.println(map);
        //  key is ordered here based on ordinal , observe the output

        // array of size same as enum
        // ["Temple" , "Gym", _ , _ , _ , _ , _]
        // no hashing
        // ordinal / index is used
        // FASTER THAN HASHING
        // MEMORY EFFICIENT
    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum Color{
    RED, BLUE, GREEN, YELLOW
}

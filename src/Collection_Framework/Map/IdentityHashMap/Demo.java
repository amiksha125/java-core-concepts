package Collection_Framework.Map.IdentityHashMap;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        String key1 = new String("key");
        String key2 = new String("key");
        // If we do not override hashCode of object, It will internally play with memory address to generate it

        // String class has its own hashCode method that uses its value which is key for both
        // It uses equals() method to check if the key is already present
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 1);
        map.put(key2, 2);
        // It uses equals() method to check if the key is already present
        // if(node.key.equals(key)){
        // // Key matches return the value

        //    return node.value; }
        // key1.equals(key2) is true
        // there fore key1 value is replaced by 2, the output is key = 2 if HashMap is used
        // If used IdentityHashMap : It does not matter if you class has hashCode() or not, IdentityHashMap will always
        // use the memory address to generate the hashCode, hence code will be different and bucket will be different
        // equals will become false, we could preserve both our keys
        // here, IdentityHashMap will ignore the hashCode() of String class, and will use the hashCode() of Object class
        // and based on address of memory it generates the hash code

        // It uses identityHashCode and == ( it does not compare values using equals but compares their memory reference)

        // HashMap says if the class(String) has hashCode() then It will use that and ignore hashCode() of Object class
        // Because key and key strings are same, the hashCode wil be same, that is why hashMap size is 1
        // IdentityHashMap will only use hashCode() of Object class , as we used new keywords, both will be created at
        // different locations in heap, both hash code will be different, two index will be created and map size will be 2
        // In a rear case, if the hashCode comes to be same then also the equals method is not used, == used means the addresses
        //      of both the keys wil be compared, if same address then key1's value replaced otherwise new entry is created in map

        System.out.println(map); // only key2 is present


        System.out.println(System.identityHashCode(key1)); //   memory
        System.out.println(System.identityHashCode(key2)); // memory , both will be different

        System.out.println(key1.hashCode()); // values
        System.out.println(key2.hashCode()); // values, same for both

    }
}

package Collection_Framework.Map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualsMethod {
    public static void main(String[] args) {
        // create a hashmap of a person and its designation
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bob", 2);
        Person p3 = new Person("Alice", 1); // new assigned different memory to p3 even if values are same as p1


        map.put(p1, "Engineer"); // hashcode1 --> index1
        map.put(p2, "Designer"); // hashcode2 --> index2
        map.put(p3, "Manager");  // hashcode3 --> index3 (diff hashcode is generated as memory is different)
        // after overriding, ---> hashCode1 --> index1 --> equals(true) --> replace

        System.out.println("HashMap Size: " + map.size()); // 3 before overriding, now it is 2
        System.out.println("Value for p1: "+ map.get(p1));
        System.out.println("Value for p3: "+ map.get(p3));

        // Now when I override the hashCode method here , It will generate hashCode based on the values of name and id
        // not on the basis of memory reference,
        // therefore p3 will be the key, and It will have same hashCode value as p1 object, equals is used

        // And equals is also overridden, It will check if  both name and id are same, if it is then returns true
        // if equals returns true means p1 key's value will be replaced with Manager now and no entry for p3 is created
        // map size will be 2 only


        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Shubham", 90); // hashcode1 --> index1
        map1.put("Neha", 92); // hashcode2 --> index2
        map1.put("Shubham", 99); // hashcode1 --> index1 --> equals() --> replace

        // System.out.println(map1.get("Shubham"));

    }
}

class Person{
    private String name;

    private int id;

    public Person(String name, int id){
        this.name= name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
       if(this == obj){
           return true;
       }
       if(obj == null){
           return false;
       }

       if(getClass() != obj.getClass()){
           return false;
       }

       Person other = (Person) obj;
       // if name is null then String equals returns exception
        // Objects is a utility class
        return id == other.getId() && Objects.equals(name, other.getName());
    }

    @Override
    public int hashCode() {
      //  return super.hashCode();
// very important how a collision is made how it is solved, replaced and size became 2
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "id: "+id+" name: "+name;
    }
}

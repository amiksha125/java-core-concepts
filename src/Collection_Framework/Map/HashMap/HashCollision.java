package Collection_Framework.Map.HashMap;

public class HashCollision {
    public static void main(String[] args) {
        System.out.println(simpleHash("ABC"));
        System.out.println(simpleHash("CBA")); // collided with same hash
    }

    public static int simpleHash(String key){
        int sum = 0;
        for(char c: key.toCharArray()){
            sum += (int) c;

        }
        return sum % 10;
    }
}

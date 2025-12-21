package generics.GenericsInEnum;


enum Day{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
public class Example {
    public static void main(String[] args) {
        // Enum is already type safe
        Day day = Day.THURSDAY;
        //Day dayy = "Thurday"; // error
    }
}

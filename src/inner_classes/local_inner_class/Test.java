package inner_classes.local_inner_class;

public class Test {
    public static void main(String[] args) {
        // This is literally cool
        Hotel hotel = new Hotel("Sunshine Hotel", 10, 5);
        hotel.reserveRoom("Numi", 5);
        hotel.reserveRoom("Rutum", 2);

        hotel.reserveRoom("", -4);
    }
}

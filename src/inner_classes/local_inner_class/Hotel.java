package inner_classes.local_inner_class;

public class Hotel {
    private String Name;

    private int totalRooms;

    private int reservedRooms;

    public Hotel(String name, int totalRooms, int reservedRooms) {
        Name = name;
        this.totalRooms = totalRooms;
        this.reservedRooms = reservedRooms;
    }

    public void reserveRoom(String guestName, int numOfRooms){
        class Reservationvalidator{

            boolean validate(){
                if(guestName == null || guestName.isBlank()){
                    System.out.println("Guest name cannot be empty !");
                    return false;
                }
                if(numOfRooms < 0){
                    System.out.println("Number of rooms should be positive");
                    return false;
                }
                // this inner class inside the member function of outer class can access the outer class field
                if(reservedRooms + numOfRooms > totalRooms){
                    System.out.println("Not enough rooms available");
                    return false;
                }
                return true;
            }

        }

//        create object of inner class inside function itself
        Reservationvalidator validator = new Reservationvalidator();// local inner class
        if(validator.validate()){
            reservedRooms += numOfRooms;
            System.out.println("Reservation confirmed for "+ guestName + " for "+numOfRooms+" rooms.");
        } else {
            System.out.println("We're sorry, "+guestName+" Reservation failed");
        }
    }
}

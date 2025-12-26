package enumeration;

public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    public void display(){
        System.out.println("Today is "+this.name());
    }
}

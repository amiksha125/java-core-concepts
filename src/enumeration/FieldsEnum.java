package enumeration;

public enum FieldsEnum {
    SUNDAY("Sunday", "Somwar"),
    MONDAY("Monday", "Somwar"),
    TUESDAY("Tuesday", "Somwar"),
    WEDNESDAY("Wednesday", "Somwar"),
    THURSDAY("Thursday", "Somwar"),
    FRIDAY("Friday", "Somwar"),
    SATURDAY("Saturday", "Somwar");

    private String lower;
    private String hindi;

    public String getLower() {
        return lower;
    }

    public String getHindi() {
        return hindi;
    }

    FieldsEnum(String lower, String hindi){
        System.out.println("Constructor called for initializing instance value "+ lower);
        this.lower = lower;
        this.hindi = hindi;
    }
    public void display(){
        System.out.println("Today is "+this.name());
    }
}

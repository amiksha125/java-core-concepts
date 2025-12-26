package enumeration;

import java.sql.SQLOutput;

public class Second {

    // enum inside a class
    //enums are inherently static
    enum Months{
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER

    }



    public static void main(String[] args) {
        System.out.println(Months.JULY.ordinal());
        System.out.println(Months.JANUARY.name());
    }
}

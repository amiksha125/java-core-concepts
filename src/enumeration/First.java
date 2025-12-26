package enumeration;

import java.sql.SQLOutput;

public class First {
    public static void main(String[] args) {
        // when a string is being used multiple times in a program then it suggested to make constant with this value
        // If it is to be reused many times without any mistake in spelling then make a constant

        // Let us make an interface as all the fields in the interface are public static final by default.
       // System.out.println("MONDAY");
//        System.out.println("MONDAY");
//        System.out.println("MONDAY");
//        System.out.println("MONDAY");
//        System.out.println("MONDAY");
//        System.out.println("MONDAY");
//        System.out.println("MONDAY");
//        System.out.println("MONDAY");
//        System.out.println("MONDAY");

//        System.out.println(Days.MONDAY);
//        System.out.println(Days.THURSDAY);

        // Create enum to store all the values to get rid of writing this much code in Class or Interface

        System.out.println(Day.MONDAY);
        Day tuesday = Day.TUESDAY;
        int ordinal = tuesday.ordinal();
        System.out.println(ordinal);
        // Check enum class to explore all its methods
        System.out.println(tuesday.name());
        System.out.println(tuesday.compareTo(Day.MONDAY));
        System.out.println(tuesday.equals(Day.SATURDAY));

        Day monday = Day.valueOf("MONDAY");
        // If given string is present as enum object value then only it is returned by valueOf else we get error
        System.out.println(monday.toString());

        Day[] values = Day.values();
        System.out.println("All days in enum Day...");
        for(Day day: values){
            System.out.println(day);
        }

        // using our own method in enum
        Day.THURSDAY.display();

        //switch case with enum

        String res = switch (tuesday){
            // This switch syntax is installed on Java 12
            // no need of break
            case MONDAY -> "M";
            case TUESDAY -> "T";
            default -> "Weekend";
        };

        System.out.println(res);

    }
}

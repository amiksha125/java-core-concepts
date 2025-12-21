package generics;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Array List is a dynamic array , we do not need to specify size
        ArrayList list = new ArrayList(); // can hold every data types - its object type values
        // Every class in the Java world extends Object class
        list.add(132); //int
        list.add("hello"); //string
        list.add(3.14); // float
        // write list.get(1) & press alt + enter, Its object
        Object o = list.get(0);

        // Try to access as string
        //String s = list.get(1);
        // Error we are storing parent type(Object) to child type(String)
        //Required type was string but object provided, do casting
        String s = (String) list.get(1);

        //what if we mistakenly assume that the first element is String
        String integer = (String) list.get(0);
        //above line is syntactically correct(no compile time error) but will throw exception called
        //java.lang.ClassCastException

        //✏️✏️✏️✏️✏️✏️✏️✏️✏️✏️✏️✏️✏️✏️✏️✏️✏️✏️✏️✏️
        //1. Our arraylist is not type safe, storing anything ad accessing any ways
        // Pipe me daal kuch rahe ho aur nikal kuch aur

        //⚠️⚠️⚠️⚠️
        // Two Issues:
        // 🔴 Type safety issue
        // 🔴 Manual casting
        // 🔴 No compile time checking

        // Java 5 was about to come, this is how Generics are introduced
        // Coder has to specify the type of the list while creating (string, integer etc)
        // Syntax to create object: Class<Type> list = new Class<>();
        // Object will only hold data of type T now
        // No need of manual casting and rid of java.lang.ClassCastException
        // Class ke naam ke aage angular bracket lagakar ham mention kar dete hai ke kis tarah ka
        // type ham store karenge us class ke object me

    }
}

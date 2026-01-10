Comparator is in interface that allows custom ordering

`list.sort(null)` sorts in ascending order, null -> natural order of sorting

Comparator Interface has a compare(T o1, T o2) method that compares object of same type and determines their order
We know Lambda Expression is used in @functionalInterface, Comparator is
We can either create implementation class or use lambda expression

compare(T o1, T o2) -> It tells the sort method the order of sort,
If it returns negative then o1 comes before o2
If it returns 0 o1 and o1 are considered equal in ordering
If it returns positive then o1 comes after o2

You have 5 3 to sort in ascending order, o2 should be first so It must return positive number means o1 - o2
5 - 3 -> 2 positive 
If 3 5 -> 3 - 5 -> -2 -> negative means o1 (3) comes first then o2( 5) , ascending order

You have 8 5 to sort in descending order means it should remain same o1 first then o2 meaning it must return negative
8 5 -> o2 - o1 -> 5 - 8 -> -3 -> negative means o1 (8) comes first then o2 (5) , descending order 
5 8 -> o2 - o1 -> 8 - 5 -> 3 -> positive means o2 (8) comes first then o1(5) , descending order

Comparable has compareTo, and Comparator has compare

sort a list of custom objects (Student) in Java using Comparator, both with lambda expressions and Java 8 utility methods.
Since Student does not implement Comparable, Java does not know any natural ordering, so calling studentList.sort(null)
would throw a ClassCastException. To solve this, we explicitly tell Java how to compare two students. First, the list is 
sorted in descending order of GPA using a lambda comparator that compares o2.getGpa() with o1.getGpa(). 
Because Comparator must return only -1, 0, or 1, the code checks whether the GPA difference is negative, positive, or zero 
and returns values accordingly (instead of returning a decimal). Then the same logic is written in a cleaner Java 8 style 
using Comparator.comparing(Student::getGpa).reversed(), where Student::getGpa is a method reference that tells Java which 
field to compare. After that, comparator chaining is used with thenComparing(Student::getName) so that students are sorted 
first by GPA (descending) and if GPA is equal, by name (ascending). Finally, the same chained sorting logic is rewritten 
using a lambda comparator, where if GPAs are equal, String.compareTo() is used to compare names. The demo also shows that 
sorting can be done using both List.sort() and Collections.sort() with a comparator. 
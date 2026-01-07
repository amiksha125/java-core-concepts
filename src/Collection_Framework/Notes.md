What is a Collection : It is simply an object that represent a group of objects, known as its elements.

What is a Collection Framework:
   It provides a set of interfaces and classes that helps in managing group of resources.

Before the introduction of the Collection Framework in JDK 1.2, Java used to rely on a variety of classes like Vector, Stack,
Hashtable, and arrays to store and manipulate group of objects, before the Java version 2.

However, these classes had several drawbacks:

1. Inconsistency: Each class had a different way of managing collections, leading to confusion and a steep learning curve.
2. Lack of inter-operability: These classes were not designed to work together seamlessly.
3. No common interface: There was no common interface for all these classes, which meant you couldn't write generic algorithms
that could operate on different types of collections.

Each class had its own style of managing objects, no common interface suppose you are writing a generic method where you wrote a
interface to make its implementation class use that method, but this was not possible as all the classes were independent.

To solve these problems, the Collection Framework was introduced in Java 1.2 (version 2).
Collection Framework led to:
  Unified architecture: A consistent set of interfaces for all collections.
  Inter-operability: Collections can be easily interchanged and manipulated.
  Reusability: Generic algorithms can be written that work with any collection.
  Efficiency: The framework provides efficient algorithm for basic operations like searching, sorting and manipulation.
  

Key Interfaces in the collection framework 
The Collection Framework is primarily built around a set of interfaces. The most important ones are:

Collection: The root interface for all the other collection types.

List: An ordered collection that can contain duplicate element(e.g. ArrayList, LinkedList), the order of insertion is maintained

Set: A collection that cannot contain duplicate elements(e.g, HashSet, TreeSet). 

Queue: A collection designed for holding elements prior to processing (e.g, PriorityQueue, LinkedList when used as a queue)

Deque: A double ended queue that allows insertion and deletion from both the ends(e.g, ArrayDeque ).

Map: An interface that represents a collection of key-value pairs (e.g, HashMap, TreeMap).                                              


The Collection interface is the **root interface** of Java Collection Framework. It is the most basic interface that defines a group of objects
known as elements. The Collection interface is a part of the java.util package, and It is a parent interface that is extended by other interfaces like
List, Set, Deque. 
Since Collection is an interface iot cannot be instantiated directly; rather it provides a blueprint of the basic operations that rae common 
to all collections. 
The Collection interface defines a set of core methods that are implemented by all classes that implements the interface. These methods allow
for basic operations such as adding, removing, and checking the existence of elements.

* List Interface in java is a part of the java.util package and is a *sub-interface* of the Collection interface. It provides a way to store 
an *ordered collection of elements* (known as a sequence). List allows for precise control over where elements  are inserted and *can contain 
duplicate elements*. Especially used for storing elements in ordered collection with duplicates. It is implemented by several classes 
such as **ArrayList, LinkedList, Vector, and Stack.**


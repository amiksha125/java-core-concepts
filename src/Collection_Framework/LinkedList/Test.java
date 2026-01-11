package Collection_Framework.LinkedList;

public class Test{
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();

        node2.value = 2;
        node1.value = 1;

        node1.next = node2;
        node2.next = null;

        // LinkedList makes all these easy
    }
}
class Node {
    public int value;

    public Node next; // reference to the next node
}

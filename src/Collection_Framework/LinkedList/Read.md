A LinkedList is a linear data structure where each element is a separate object called node. Each node contains two parts:

Data: The value stored in the node
Pointers: Two pointers, one pointing to the next node(next) and the other pointing to the previous node(previous).

The nodes or data are not stored at contiguous memory locations, we cannot access access elements through index in O(1)
we need to traverse the list,
But removal is easier here as compared to ArrayList where we need to left shift all the elements after node, here we just 
need to connect nodes
insertion is also efficient is linkedList

* **Insertion and Deletion** : LinkedList is better for frequent insertions and deletions in the middle of the list because 
it does not require shifting elements, as in the ArrayList.
* **Random Access** : LinkedList has slower random access(get(index)) as compared to ArrayList because it has to traverse
the list from the beginning to reach the desired the index.
* **Memory Overhead** : LinkedList requires more memory than ArrayList because each node requires extra memory to store
references to the next and previous node.


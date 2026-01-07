An ArrayList is a resizable array implementation of the List interface. Unlike array in java which has a fixed size, an ArrayList *can change 
its size dynamically as elements are added or removed.*

Internal Working: Unlike a regular array, which has a fixed size, an ArrayList can grow and shrink as elements are added
or removed. **This dynamic resizing is achieved by creating a new array(doubling the size) when the current array is full and copying 
the elements to new array.**

Difference Between capacity and Size
When you create an ArrayList, it has an initial capacity (default is 10). The capacity refers to the size of the internal array
that can hold elements before needing to resize.
Size is the number of elements present in the ArrayList object
If you just create a new ArrayList, its size is 0 and capacity is 10

*Adding elements*: When we add en element into ArrayList, the following steps occur

* Check Capacity: Before adding the new element, ArrayList checks if there is enough space in the internal array(elementData)
If the array is full it needs to be resized.

* Resize if necessary: If the internal array is full, the ArrayList will create a new array with a larger capacity(usually 1.5
times the current capacity) and copy the elements from the old array to new array.

* Add the element: The new element is then added to the internal array at appropriate position, and the size is incremented.

Resizing the Array

Initial Capacity: By default, the initial capacity is 10. This means the internal array can hold 10 elements before it needs to grow.
Growth Factor: When the internal array is full, a new array is created with a size 1.5 times the old array. This growth factor balances memory efficiency and resizing cost.
Copying Elements: When resizing occurs, all elements from the old array are copied to the new array, which is an O(n) operation, where n is the number of elements in the ArrayList.

Removing Elements

Check Bounds: The ArrayList first checks if the index is within the valid range.
Remove the Element: The element is removed, and all elements to  the right of the removed element are shifted one position to the left to fill the gap.
Reduce Size: The size is decremented by 1.

There is a overhead of insertion and deletion in ArrayList as it is doubling the internal array and shifting elements when removed.
We can improve performance by specifying the initialSize through constructor if we already know the size of the list will be 1000

ArrayList<Integer> list = new ArrayList<>(1000); // less overhead, resources are saved.
After this the size will be 0 logically and capacity now becomes 1000

We cannot directly access the capacity, but indirectly through reflection.
Problem Statement :
This problem was asked by Google.
 
An XOR linked list is a more memory efficient doubly linked list. 
Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. 
Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.
If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.
 

In an XOR linked your Node class has only one variable for address. 
What you store in the variable is the XOR of the addresses of the previous and next node. 
Since the node in this data structure uses only one field for list traversal (as opposed to two fields, prev and next, in a regular doubly linked list), 
that leads to memory saving.

In Java and C# XOR doubly linked list is not possible because you do not have access to the actual memory address of any object. 
Plus the garbage collector would get rid of these nodes if there is no variable referencing them. 

The same problem is thus solved in C++ and python
In python,we will use get_pointer and dereference_pointer functions that converts between nodes and memory addresses.


Resources :
1. https://tutorialspoint.dev/data-structure/advanced-data-structures/xor-linked-list-a-memory-efficient-doubly-linked-list-set-1
2. https://randomprogrammingstuff.wordpress.com/2016/03/06/xor-doubly-linked-list-made-simple/

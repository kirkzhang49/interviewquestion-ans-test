ArrayList:
1) ArrayList internally uses dynamic array to store the elements.	
2) Manipulation with ArrayList is slow because it internally uses array.
 If any element is removed from the array, all the bits are shifted in memory.
 3) ArrayList class can act as a list only because it implements List only.		
 4) ArrayList is better for storing and accessing data.	
 _________________________________________________________________________________________
 LinkedList:
 1)LinkedList internally uses 
 doubly linked list to store the elements.
 2)Manipulation with Li
 nkedList is faster than ArrayList because it uses doubly 
 linked list so no bit shifting is required in memory.
3)LinkedList class can act as a list and queue both because it implements List and Deque
interfaces.
4)LinkedList is better for manipulating data.
_________________________________________________________________________________________
Array:
1)Arrays are fixed in size and hence once we created an array we are not allowed to increase or 
decrease the size based on our requirement.	
2)Arrays can hold both primitives as well as objects.	
3)Performance point of view arrays faster than collection	
4)Arrays can hold only homogeneous 单种 elements.	
5）Memory point of view arrays are not recommended to use.	
6）For any requirement, there is no ready method available.
_________________________________________________________________________________________
collection
1)Collections are grow-able in nature and hence based on our requirement 
we can increase or decrease the size.
2)Collections can hold only objects but not primitive.
3)Performance point of view collections are slower than array
4)Collections can hold both homogeneous and heterogeneous elements.
5)Memory point of view collections are recommended to use.
6)For every requirement ready made method support is available.


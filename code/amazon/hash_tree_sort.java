what is hashmap
Image result for what is hashmap
In computing, a hash table (hash map) is a data structure used to implement an associative array, 
a structure that can map keys to values. A hash table uses a hash function to compute an index 
into an array of buckets or slots, from which the desired value can be found.

what is hashmap collision?
A collision happens when two different keys happen to have the same hash code, or two keys with different
hash codes happen to map into the same bucket in the underlying array.

How to solove hashmap collision?
1.add a linklist to each buckets in the hashtable 2. increase the table buckets size
LinkList algorithm: can be use to slove hashmap collision

HashMap is implemented as a hash table, and there is no ordering on keys or values. 
TreeMap is implemented based on red-black tree structure, and it is ordered by the key.
 LinkedHashMap preserves the insertion order. Hashtable is synchronized, 
 in contrast to HashMap.

 To create a treemap, one must define a tiling algorithm, that is, a way to divide
  a rectangle into sub-rectangles of specified areas. Ideally, a treemap algorithm 
  would create rectangles with an aspect ratio close to one, furthermore preserve some
sense of the ordering in the input data, and change to reflect changes in the
 underlying data. Unfortunately, these properties have an inverse relationship. 
 As the aspect ratio is optimized, the order of placement becomes less predictable.
  As the order becomes more stable, the aspect ratio is degraded.
To date, six primary rectangular treemap algorithms have been developed:

Treemap algorithms[1] Algorithm 	Order 	Aspect ratios 	Stability
BinaryTree 	partially ordered 	high 	stable
Mixed Treemaps[2] 	ordered 	lowest 	stable
Ordered 	partially ordered 	medium 	medium stability
Slice And Dice 	ordered 	very high 	stable
Squarified[3] 	unordered 	lowest 	medium stability
Strip 	ordered 	medium 	medium stability
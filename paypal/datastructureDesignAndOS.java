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

//context switch 
https://en.wikipedia.org/wiki/Context_switch
 In computing, a context switch is the process of storing and restoring the state (more specifically, 
 the execution context) of a process or thread so that execution can be resumed from the same point at 
 a later time. This enables multiple processes to share a single CPU and is an essential feature of a 
 multitasking operating system.
//design_pattern
 https://www.tutorialspoint.com/design_pattern/observer_pattern.htm

 //mutex sepmsphere spin lock
 Difference
Mutex provides one person to access a single resource at a time, others must wait in a queue. Once this 
person is done, the guy next in the queue acquire the resource.
So access is serial, one guy after other. Too aggressive.

Semaphore are useful if multiple instances (N) of a resource is to be shared among a set of users. 
As soon as all N resources are acquired, any new requester has to wait. Since there is no single lock to hold,
 there is as such no ownership of a semaphore.

Spinlock is an aggressive mutex. In mutex, if you find that resource is locked by someone else, you 
(the thread/process) switch the context and start to wait (non-blocking).
Whereas spinlocks do not switch context and keep spinning. As soon as resource is free, they go and grab it.
 In this process of spinning, they consume many CPU cycles. Also, on a uni-processor machine they are
  useless and perform very badly (do I need to explain that?).
//mutex vs semaphore
//A mutex is really a semaphore with value 1

//Dead lock 
http://www.geeksforgeeks.org/deadlock-prevention/
https://blog.feabhas.com/2009/09/mutex-vs-semaphores-%E2%80%93-part-1-semaphores/


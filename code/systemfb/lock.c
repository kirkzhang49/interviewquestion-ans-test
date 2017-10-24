A lock allows only one thread to enter the part thats locked and the lock is not shared
 with any other processes.
Mutex lock //sleep 
spinlock //busy waiting use the process 
A mutex is the same as a lock but it can be system wide (shared by multiple processes).

//A semaphore does the same as a mutex but allows x number of threads to enter.

You also have read/write locks that allows either unlimited number of readers or 1 writer at any given time.
//////////////////
The point of a mutex is to synchronize two threads. When you have two threads attempting to access 
a single resource, the general pattern is to have the first block of code attempting access to set the 
mutex before entering the code. When the second code block attempts access, it sees the mutex is set and 
waits until the first block of code is complete (and un-sets the mutex), then continues.

Specific details of how this is accomplished obviously varies greatly by programming language.
///////////////
First, remember the goal of these 'synchronizing objects' :

These objects were designed to provide an efficient and coherent use of 'shared data' between more than 
1 thread among 1 process or from different processes.

These objects can be 'acquired' or 'released'.

Now, if it helps to you, let me put my grain of sand:

1) Critical Section= User object used for allowing the execution of just one active thread from many others 
within one process. The other non selected threads are put to sleep.

[No interprocess capability, very primitive object].

2) Mutex Semaphore (aka Mutex)= Kernel object used for allowing the execution of just one active thread 
from many others, within one process or among different processes. The other non selected threads are put 
to sleep. This object supports thread ownership, thread termination notification, recursion (multiple
 'acquire' calls from same thread) and 'priority inversion avoidance'.

[Interprocess capability, very safe to use, a kind of 'high level' synchronization object].

3) Counting Semaphore (aka Semaphore)= Kernel object used for allowing the execution of a group of active
 threads from many others, within one process or among different processes. The other non selected 
 threads are put to sleep.

[Interprocess capability however not very safe to use because it lacks following 'mutex' attributes:
 thread termination notification, recursion?, 'priority inversion avoidance'?, etc].

4) And now, talking about 'spinlocks', first some definitions:

Critical Region= A region of memory shared by 2 or more processes.

Lock= A variable whose value allows or denies the entrance to a 'critical region'. (It could be implemented 
as a simple 'boolean flag').

Busy waiting= Continuosly testing of a variable until some value appears.

Finally:

Spin-lock (aka Spinlock)= A lock which uses busy waiting. (The acquiring of the lock is made by xchg or 
similar atomic operations).

[No thread sleeping, mostly used at kernel level only. Ineffcient for User level code].

As a last comment, I am not sure but I can bet you some big bucks that the above first 3
 synchronizing objects (#1, #2 and #3) make use of this simple beast (#4) as part of their implementation.
 //////////
 Spin Locks vs Atomic Updates
void SLL_push(SLL *head, SLL *element) {
do {
SLL *prev = head->next; element->next = prev;
} while ( CompareAndSwap(&head->next, prev, element) != prev);
}
Mutual Exclusion and Asynchronous Completion }
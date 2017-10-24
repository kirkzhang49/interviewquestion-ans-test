Criteria
   
Mechanism
Mutex
Test for lock.
If available, use the resource
If not, go to wait queue
Spinlock
Test for lock.
If available, use the resource.
If not, loop again and test the lock till you get the lock
When to use
Mutex
Used when putting process is not harmful like user space programs.
Use when there will be considerable time before process gets the lock.
Spinlock
Used when process should not be put to sleep like Interrupt service routines.
Use when lock will be granted in reasonably short time.
Drawbacks
Mutex
Incur process context switch and scheduling cost.
Spinlock
Processor is busy doing nothing till lock is granted, wasting CPU cycles.
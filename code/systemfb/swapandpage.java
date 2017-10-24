http://web.cs.ucla.edu/classes/spring16/cs111/slides/06_vmem.pdf
Memory Management Goals
1. transparency
– process sees only its own virtual address space – process is unaware memory is being shared
2. efficiency
– high effective memory utilization
– low run-time cost for allocation/relocation 3. protection and isolation
– private data will not be corrupted
– private data cannot be seen by other processes
////////
Primary and Secondary Storage
• primary = main (executable) memory
– primary storage is expensive and very limited – only processes in primary storage can be run
• secondary = non-executable (e.g. Disk/SSD)
– blocked processes can be moved to secondary storage – swap out code, data, stack and non-resident context
– make room in primary for other "ready" processes
• returning to primary memory
– process is copied back when it becomes unblocked
///
Why we swap
• make best use of a limited amount of memory – process can only execute if 
it is in memory
– can’t keep all processes in memory all the time
– if it isn't READY, it doesn't need to be in memory – swap it out and make 
room for other processes
• improve CPU utilization
– when there are no READY processes, CPU is idle – CPU idle time means 
reduced system throughput – more READY processes means better utilization
//running -> block (swap out) ->read(swap in,allocate,yeld) ->running(dispatch)
////CPU idle but memory usage a lot did not swap the inactive memory to disk 
Pure Swapping • each segment is contiguous
– in memory, and on secondary storage
– all in memory, or all on swap device
• swapping takes a great deal of time
– transferring entire data (and text) segments • swapping wastes a great deal
 of memory
– processes seldom need the entire segment • variable length memory/disk 
allocation
– complex, expensive, external fragmentation
////

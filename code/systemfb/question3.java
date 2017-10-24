1. Swap 
1.1 What is swap，when will it be used 
Swap space in Linux is used when the amount of physical memory (RAM) is full. 
If the system needs more memory resources and the RAM is full, 
inactive pages in memory are moved to the swap space. 
While swap space can help machines with a small amount of RAM, 
it should not be considered a replacement for more RAM. 
Swap space is located on hard drives, which have a slower access 
time than physical memory.
////////
http://askubuntu.com/questions/157793/why-is-swap-being-used-even-though-i-have-plenty-of-free-ram
////////////
1.2 What s the situation that a process will swap 
/////////
How Linux uses swap (even more simplified)

Once you have used up enough memory that there is not enough left for a smooth-running
 cache, Linux may decide to re-allocate some unused application memory from 
 RAM to swap.
 ///////////////////
Linux starts swapping before the RAM is filled up. This is done to improve 
performance and responsiveness:
Performance is increased because sometimes RAM is better used for disk cache
than to store program memory. So it's better to swap out a program that's 
been inactive for a while, and instead keep often-used files in cache.
Responsiveness is improved by swapping pages out when the system is idle, 
rather than when the memory is full and some program is running and 
requesting more RAM to complete a task.
Swapping does slow the system down, of course — but the alternative to 
swapping isn't not swapping, it's having more RAM or using less RAM.
///////
Having more available memory

Like everyone said, yes swap will help you get rid of unused memory, so it
 can help you having more memory available.

Hibernating
/////////check process swap 
[a] /proc/meminfo - This file reports statistics about memory usage on the 
system. It is used by free to report the amount of free and used memory
 (both physical and swap) on the system as well as the shared memory and 
 buffers used by the kernel. You can also use free, vmstat and other tools 
 to find out the same information.

[b] /proc/${PID}/smaps, /proc/${PID}/status, and /proc/${PID}/stat : Use these files to find information about memory, pages and swap used by each process using its PID.

[c] smem - This command (python script) reports memory usage with shared memory divided proportionally.
//////////
1.3 What s the down side of swap? 
////cons 
There are three disadvantages to using swap space.

1,It doesnt provide access as fast as real memory,
2,puts more burden on the operating system to manage the virtual memory,
3.and has diminishing benefit (at some point the benefit of adding more swap 
space has little effect on performance.
/////
advantage:

Provides overflow space when your memory fills up completely
Can move rarely-needed items away from your high-speed memory
Allows you to hibernate
Disadvantages:

Takes up space on your hard drive as SWAP partitions do not resize dynamically
Can increase wear and tear to your hard drive
Does not necessarily improve performance (see below)
http://www.makeuseof.com/tag/swap-partition/
//////
2. type command `ls -l foo*` 
2.1 what will happened in linux 
2.2 what is fork system call? and what is the common system call? 
2.3 talk about what is the permission, where to get it? What is umask? ... 
2.4 following up with parent and child process ... 
3. Database server, suddenly disk I/O increase. 
3.1 how to proof it? 
http://www.2daygeek.com/monitor-disk-io-activity-using-iotop-iostat-commands-on-linux/
iostat ,iotop
3.2 Whats the situation that may lead to these? Whats the way to defend? 
not in cahce preload 
3.3 How to improve the disk I/O performance? 
(RAID) 
///////
In computer operating systems, paging is a memory management scheme by which a computer stores and retrieves 
data from secondary storage[a] for use in main memory.[1] In this scheme, the operating system retrieves 
data from secondary storage in same-size blocks called pages. Paging is an important part of virtual memory
 implementations in modern operating systems, using secondary storage to let programs exceed the size of 
 available physical memory.

For simplicity, main memory is called "RAM" (abbreviated from "random-access memory") and secondary 
storage is called "disk" (a shorthand for "hard disk drive"), but the concepts do not depend on whether 
these terms apply literally to a specific computer system.
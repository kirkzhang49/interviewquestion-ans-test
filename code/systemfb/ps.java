//ps find memory usage
ps ef -o command,vsize,rss,%mem,size
// sort by cpu usage
ps -Ao user,uid,comm,pid,pcpu,tty --sort=-pcpu | head -n 6


// Given a database with slow I/O, how can we improve it? 

1
▼
Using Cache solutions.
You preload the database to the cache on system startup, and 
make all read and writes to the cache. the cache is responsible 
to update the DB underneath.
One simple solution is using cache or RAID mechanisms (parallelism). 
But anyway there is no correct answer for this questions, it depends of your specific problem or workload.
 How can you find whether a process is I/O bound or CPU   bound? 
-- Look at the code.
-- Close all applications, run the process,
 run top and look at the wait time.

If it's a process that does some stuff and exits, you can run it with "time".
If it spent most time in userspace, it's a CPU bound process
Describe in detail on the kernel level how signals from terminal user reach processes.  
 Explain in detail, down to the machine language what steps   
 are executed after you type in the Linux command "ps" into the terminal. 
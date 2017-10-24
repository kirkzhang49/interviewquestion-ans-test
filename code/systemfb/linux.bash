ps aux --sort -rss
# sort ps by memory usage
#a = show processes for all users
#u = display the process's user/owner
#x = also show processes not attached to a terminal
valgrind --tool=cachegrind ls -l
#cache level miss rate check
 ipcs -a
#show Inter-process Communication.
ipcs -p 
# shared memory
vmstat # display 
vmstat -a # active
vmstat -f # forks
Procs – r: Total number of processes waiting to run
Procs – b: Total number of busy processes
Memory – swpd: Used virtual memory
Memory – free: Free virtual memory
Memory – buff: Memory used as buffers
Memory – cache: Memory used as cache.
Swap – si: Memory swapped from disk (for every second)
Swap – so: Memory swapped to disk (for every second)
IO – bi: Blocks in. i.e blocks received from device (for every second)
IO – bo: Blocks out. i.e blocks sent to the device (for every second)
System – in: Interrupts per second
System – cs: Context switches
CPU – us, sy, id, wa, st: CPU user time, system time, idle time, wait time
# slab info 
vmstat -m
#timestamp 
vmstat -t 
#Display statistics in a table format
vmstat -s
#vmstat – Display disk statistics
vmstat -d ##display IO
vmstat -D # io

#Iostat without any argument displays information about the CPU usage, and I/O statistics about all the partitions on the system as shown below.
iostat 
#the following gives the system CPU statistics 3 times 
sar 1 3
#3. Memory Free and Used (sar -r)
#4. Swap Space Used (sar -S)
#5. Overall I/O Activities (sar -b)
#6. Individual Block Device I/O Activities (sar -d)
#7. Display context switch per second (sar -w)
#8. Reports run queue and load average (sar -q)
#9. Report network statistics (sar -n)
#10. Report Sar Data Using Start Time (sar -s)
# This run shows which processes are accessing all of the files in /usr/bin.
lsof -r 2 +D /usr/bin/
#This tools shows which processes are consuming the most I/O. 
#But it lacks options to show specific file names.
sudo iotop
# transmit and receive statistics of all the network devices in the system.
sar -n DEV 1 2
#we examine the number of open sockets in the system. We can see the total number of open sockets and the TCP, RAW, and UDP sockets
sar -n SOCK 1 2
#count sys call for a process 
ltrace -p 32744 -c
#find where the process executing
ls -l /proc/pid/exe 
#1 : Tell me every step after you input "$ ls -l *" and hit enter in bash.
- what happend before the command executes.
adamf@kid-charlemagne:~/foo$ strace ls
execve("/bin/ls", ["ls"], [/* 30 vars */]) = 0
  int execve(const char *filename, char *const argv[],
                  char *const envp[]);
/////exec(3) ...a family of calls for executing files within a process
想请教一个问题，关于"ls -al *.c"的答案。简单来讲应该是这样:. 
bash finds ls command ------ fork() system call (interrupt/context switch) --
---- child process created ------- exec family system call 
"ls -al *.c"(interrupt/context switch) ------- move disk head to master
//**//imap//**// ------- locate current directory and move diskhead ------- 
read information and print to stdout -- ------ child process terminated 
-------- parent process continue
/////////////
1) fork ()
2) connect pipes
3) look up the command
4) do redirections
5) execve ()
6) If the execve failed, see if the file has executable mode set.
If so, and it isn ot a directory, then execute its contents as
a shell script.
[...]
/////
- how does kernal know what is "ls".
//////////////////
A system call executes in the kernel mode. Every system call has a number
associated with it. This number is passed to the kernel and thats how the
kernel knows which system call was made. When a user program issues a system
call, it is actually calling a library routine. The library routine issues a
trap to the Linux operating system by executing INT 0x80 assembly instruction.
It also passes the system call number to the kernel using the EAX register. The
arguments of the system call are also passed to the kernel using other
registers (EBX, ECX, etc.). The kernel executes the system call and returns the
result to the user program using a register. If the system call needs to supply
the user program with large amounts of data, it will use another mechanism
(e.g., copy_to_user call).
//////////////////
- how does kernal interprete this String.
translate to assembly code objdump
- what system call are called? how do you understand the system call.
///////
A system call is a way for programs to interact with the operating system.
 A computer program makes a system call when it makes a request to the
  operating systems kernel. System calls are used for hardware services, 
  to create or execute a process, and for communicating with kernel services,
   including application and process scheduling.
///////////////////////////////
- system call trap instruction halts normal execution
- push suspended PC/PS onto supervisor stack
- change to PC and supervisor mode PS in appropriate trap vector
- specified trap PC takes us to first level trap handler
In the first level trap handler:
- save all registers onto the stack
- figure out which system call is being called
- call appropriate second level system call handler (which might update user-mode saved registers on the stack)
- restore saved registers
- use privileged instruction to return (restore saved PC/PS)
and return to the instruction after the system call
//////////////////////////////
#2 : what is pipe? ex: ls | grep , what happend when you type this.
 pipe() creates a pipe, a unidirectional data channel that can be used
       for interprocess communication.  The array pipefd is used to return
       two file descriptors referring to the ends of the pipe.  pipefd[0]
       refers to the read end of the pipe.  pipefd[1] refers to the write
       end of the pipe.  Data written to the write end of the pipe is
       buffered by the kernel until it is read from the read end of the
       pipe.  For further details, see pipe(7).
       /////
  cc=fork();
  
		  if (cc>0) //parent process
		  {
			close(to_c_pipe[0]); //close to child pipe(read)
			close(from_c_pipe[1]);//close from child pipe(write)
			char buffer2;
      
			  pthread_t to_child_thread;
			pthread_create(&to_child_thread,NULL,read_from,NULL);
			 while (1)
		   {
		   
			read(0,&buffer2,1);
		if (buffer2== 0x0D || buffer2== 0x0A)
		{
				 write(to_c_pipe[1],linefeed,1);
				 write(1,cr_lf,2);
		}
           }
          }
    
		  else if (cc==0)//child process
		  {
		 
		   close(to_c_pipe[1]);
		   close(from_c_pipe[0]);
		   dup2(to_c_pipe[0],0);
		   dup2(from_c_pipe[1],1);
		   close(to_c_pipe[0]);
		   close(from_c_pipe[1]);
		   char *exec_argv[2] ={"/bin/bash",NULL};
		  
		   if (execvp(exec_argv[0],exec_argv)==-1)
		   {
		   fprintf(stderr,"execvp() failed");
		   exit(1);
		   }
		  
		   }
		   else//cc<0 fork() failed
		  {
			fprintf(stderr,"fork failed");
		   exit(1);
		  }
		}
		  
///////////////////
#4 : when you execute "telnet google.com 80", what happend?
https://www.quora.com/What-are-the-series-of-steps-that-happen-when-an-URL-is-requested-from-the-address-field-of-a-browser
http://igoro.com/archive/what-really-happens-when-you-navigate-to-a-url/
#3 : what is "file description"? (finally, he is examing me the STDIN / STDOUT / ERROR, these
 channels)
 https://en.wikipedia.org/wiki/File_descriptor
 http://unix.stackexchange.com/questions/195057/what-is-an-open-file-description
#5 : Given a situation: The memory is crush and the system reboots due to a highly memory
usage, what would you do?
On some demand-paged virtual memory systems, the operating system refuses to allocate anonymous pages 
(i.e. pages containing data without a filesystem source such as runtime data, program stack etc.) 
unless there is sufficient swap space to swap out the pages in order to free up physical memory. 
This strict accounting has the advantage that each process is guaranteed access to as much virtual 
memory they allocate, but is also means that the amount of virtual memory available is essentially 
limited by the size of the swap space.
// memory usage over limit over swap space +ram 
//Random-access memory expensive than disk but fast 
//In practice, programs tend to allocate more memory than they use. 
For instance, the Java Virtual Machine
 allocates a lot of virtual memory on startup, but does not use it immediately. Memory accounting in the
  Linux kernel attempts to compensate for this by tracking the amount of memory actually in use by processes
  , and overcommits the amount of virtual memory. In other words the amount of virtual memory allocated 
  by the kernel can exceed the amount of physical memory and swap space combined on the system. While this
   leads to better utilization of physical memory and swap space, the downside is that when the amount of 
   of memory in use exceeds the amount of physical memory and swap space available, the kernel must somehow
    free memory resources in order to meet the memory allocation commitment.
- How can you find out which process is causing this problem.
(use "top" try to find the highest I/O requests)
iotop 
- How to find which file is being currently most reading or requesting?
(...). 
//////
1) Whatever device you see in "iostat" output performing more I/O, use it with fuser command as follows:

fuser -uvm device
2) You will get a list of processes with the user name causing more I/O. Select those PIDS and use it in the lsof command as follows:

lsof -p PID | more
3) You will get a list of files/directories along with the user performing maximum I/O.
//////
It seems there is no tools to find out I/O throughput per file other than within process using the file. But there are ways to find out process I/O throughput.

iotop - It is a top/iftop like utility that show process I/O throughput.

After pin pointing which process is having heavy I/O, use following to find out what file is being used

lsof -c <process name>
That should narrow down the scope and help pin point the source.
//////
memo crush?
- You may use "procfile" command.//cat /proc/meminfo
//////////////////////
- How can you avoid this happened? How to avoid the system rebooting due to the
////////////////
(write a monitoring script, if the memory load is high, kill the process which
highly use the memory resource)
- do you know how "memory swap" work? (swap the sleeping process out, and
keep the active ones inside the memo).
Swap space in Linux is used when the amount of physical memory (RAM) is full. 
If the system needs more memory resources and the RAM is full, inactive pages in memory 
are moved to the swap space. While swap space can help machines with a small amount of RAM,
 it should not be considered a replacement for more RAM. Swap space is located on hard drives, 
 which have a slower access time than physical memory.

Swap space can be a dedicated swap partition (recommended), a swap file, or a combination of swap 
partitions and swap files.


#6 : Suppose I have separate DB server for the DB process. If my DB server running slow.
What can you do?
Using Cache solutions.
You preload the database to the cache on system startup, and make all read and writes to the cache.
 the cache is responsible to update the DB underneath.
 (cache is faster but small, read from memory slow read fron disk more slow )
 ////////////////////
(for hardware, you may use RAID to improve read/write performance ... ).
RAID (originally redundant array of inexpensive disks, now commonly array of independent disks) is a data
storage virtualization technology that combines multiple physical disk drive components into a single logical
 unit for the purposes of data redundancy, performance improvement, or both.[1]

Data is distributed across the drives in one of several ways, referred to as RAID levels, depending on 
the required level of redundancy and performance. The different schemas, or data distribution layouts, 
are named by the word RAID followed by a number, for example RAID 0 or RAID 1. Each schema, or RAID level, 
provides a different balance among the key goals: reliability, availability, performance, and capacity. RAID levels greater than RAID 0 provide protection against unrecoverable sector read errors, as well as against failures of whole physical drives.
/////////////
https://en.wikipedia.org/wiki/RAID
///////////
- What RAIN mode you are gonna use?
(RAID 5 or RAID 6)
- What is their difference?
(RAID 5 can have at most 1 disk failure, RAID 6 is two)
(Or scale up, replace with better CPU, memo ... ).
- May be SSD ?
https://en.wikipedia.org/wiki/Solid-state_drive#Memory
(yeh, SSD, or try to have faster spin speed hard disk.)
(for the software, you may replace Relational Database System with NoSQL
database)
///////
Like a memory stick, there are no moving parts to an SSD. Rather, information is stored in microchips. 
Conversely, a hard disk drive uses a mechanical arm with a read/write head to move around and read 
information from the right location on a storage platter. This difference is what makes SSD so much faster.
//////
https://en.wikipedia.org/wiki/NoSQL
In computing, particularly in the context of the Unix operating system 
and its workalikes, fork is an operation whereby a process creates a 
copy of itself. It is usually a system call, implemented in the kernel. 
Fork is the primary (and historically, only) method of process creation 
on Unix-like operating systems.
///////
In computing, a parent process is a process that has created one or 
more child processes.
https://en.wikipedia.org/wiki/Parent_process
//////////
A child process in computing is a process created by another process (the parent process). 
This technique pertains to multitasking operating systems, and is sometimes called a subprocess or 
traditionally a subtask.

There are two major procedures for creating a child process: the fork system call (preferred in Unix-like 
systems and the POSIX standard) and the spawn (preferred in the modern (NT) kernel of Microsoft Windows, 
as well as in some historical operating systems).
A child process inherits most of its attributes, such as file descriptors, from its parent. In Unix,
 a child process is typically created as a copy of the parent, using the fork system call. 
 The child process can then overlay itself with a different program (using exec) as required.

Each process may create many child processes but will have at most one parent process; if a process does
 not have a parent this usually indicates that it was created directly by the kernel. In some systems, 
 including Linux-based systems, the very first process (called init) is started by the kernel at booting 
 time and never terminates (see Linux startup process); other parentless processes may be launched to 
 carry out various daemon tasks in userspace. Another way for a process to end up without a parent is if 
 its parent dies, leaving an orphan process; but in this case it will shortly be adopted by init.

The SIGCHLD signal is sent to the parent of a child process when it exits, is interrupted,
 or resumes after being interrupted. By default the signal is simply ignored.[1]
 When a child process terminates, some information is returned to the parent process.

When a child process terminates before the parent has called wait,
 the kernel retains some information about the process, such as its exit status, 
 to enable its parent to call wait later.[2] Because the child is still consuming system 
 resources but not executing it is known as a zombie process. The wait system call is commonly 
 invoked in the SIGCHLD handler.
 https://en.wikipedia.org/wiki/Child_process
/////////
redirection 
////
There are always three default files [1] open, stdin (the keyboard), stdout (the screen), and stderr 
(error messages output to the screen). These, and any other open files, can be redirected. 
Redirection simply means capturing output from a file, command, program, script, or even code block
 within a script (see Example 3-1 and Example 3-2) and sending it as input to another file, command, 
 program, or script.

Each open file gets assigned a file descriptor.	[2] The file descriptors for stdin, stdout, and stderr 
are 0, 1, and 2, respectively. For opening additional files, there remain descriptors 3 to 9. 
It is sometimes useful to assign one of these additional file descriptors to stdin, stdout, or 
stderr as a temporary duplicate link. [3] This simplifies restoration to normal after complex redirection
 and reshuffling (see Example 20-1).
 ////////
 the child gets a copy of the parent’s data space, heap, and stack. Note that this is a copy for the child; 
 the parent and the child do not share these portions of memory. The parent and the child do share the 
 text segment, however (Section 7.6).

 ///////////
 Signals
10.1 Introduction
Signals are software interrupts. Most nontrivial application programs need to deal with signals. 
Signals provide a way of handling asynchronous events—for example, a user at a terminal typing the 
interrupt key to stop a program or the next program in a pipeline terminating prematurely.
Signals have been provided since the early versions of the UNIX System, but the signal model provided 
with systems such as Version 7 was not reliable. Signals could get lost, and it was difficult for a
 process to turn off selected signals when executing critical regions of code. Both 4.3BSD and SVR3 made
  changes to the signal model, adding what are called reliable signals. But the changes made by Berkeley 
  and AT&T were incompatible. Fortunately, POSIX.1 standardized the reliable-signal routines, and that is 
  what we describe here.
In this chapter, we start with an overview of signals and a description of what each signal is normally
 used for. Then we look at the problems with earlier implementations. It is often important to understand 
 what is wrong with an implementation before seeing how to do things correctly. This chapter contains 
 numerous examples that are not entirely correct and a discussion of the defects.
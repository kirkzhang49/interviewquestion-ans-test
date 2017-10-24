Signals are a limited form of inter-process communication used in Unix, Unix-like, and other POSIX-compliant
 operating systems. A signal is an asynchronous notification sent to a process or to a specific thread 
 within the same process in order to notify it of an event that occurred. Signals originated in 1970s
 Bell Labs Unix and have been more recently specified in the POSIX standard.

When a signal is sent, the operating system interrupts the target process' normal flow of execution to
 deliver the signal. Execution can be interrupted during any non-atomic instruction. If the process has p
 reviously registered a signal handler, that routine is executed. Otherwise, the default signal handler 
 is executed.

The kill(2) system call sends a specified signal to a specified process, if permissions allow. Similarly, 
the kill(1) command allows a user to send signals to processes. The raise(3) library function sends the 
specified signal to the current process.
//'/////////////
Embedded programs may find signals useful for interprocess communications, as the computational and memory
 footprint for signals is small.
 Ctrl-C (in older Unixes, DEL) sends an INT signal ("interrupt", SIGINT); by default, 
 this causes the process to terminate.
Ctrl-Z sends a TSTP signal ("terminal stop", SIGTSTP); by default, this causes the process to 
suspend execution.
Ctrl-\ sends a QUIT signal (SIGQUIT); by default, this causes the process to terminate and dump core.
Ctrl-T (not supported on all UNIXes) sends an INFO signal (SIGINFO); by default, and if supported by the 
command, this causes the operating system to show information about the running command.
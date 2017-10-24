//1. List All Ports (both listening and non listening ports)
 netstat -a | more
//List all tcp ports using netstat -at
# netstat -at
//asks netstat to provide statistics about the UDP traffic that the system has received since boot
netstat -s -u
//. watch clears the screen and updates this information every 10 seconds
watch  -n 10 "ps -o minflt,cmd"
// list of all the libraries that this binary requires and which files in the system are fulfilling those requirements
ldd /bin/ls
//, it displays all the symbols that this library/binary either relies on or provides.
objdump -T 
/'When using performance tools (such as ltrace),
 which display the library functions an application
  calls (but not the libraries themselves), objdump 
  helps locate the shared library each function is
   present in.'/
gdb -p pid
//to see how many system call and time of application
ltrace -c ls
//cache missing rate check  
cachegrind
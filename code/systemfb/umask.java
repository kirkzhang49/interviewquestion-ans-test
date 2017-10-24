
4.8 umask Function
Now that we’ve described the nine permission bits associated with every file, we can describe
 the file mode creation mask that is associated with every process.
The umask function sets the file mode creation mask for the process and returns the previous 
value. (This is one of the few functions that doesn’t have an error return.)
/// set file mode creation mask  set default create 
umask -S 
0400 user-read
0200 user-write
0100 user-execute
0040 group-read 
0020 group-write
0010 group-execute
0004 other-read 
0002 other-write 
0001 other-execute
stat //display file or file system status 
mmap //map or unmap files or devices into memory
     
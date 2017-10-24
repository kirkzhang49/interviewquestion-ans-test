//stat -c "%a %n"  *
//display the permissions 
//mmap
mmap, munmap - map or unmap files or devices into memory
DESCRIPTION        
  void *mmap(void *addr, size_t length, int prot, int flags,
                  int fd, off_t offset);
       int munmap(void *addr, size_t length);
mmap() creates a new mapping in the virtual address space of the
calling process.  The starting address for the new mapping is
specified in addr.  The length argument specifies the length of the
mapping.

If addr is NULL, then the kernel chooses the address at which to
create the mapping; this is the most portable method of creating a
new mapping.  
//////////////////
open = 3 create new file descirption for ld.so.cache//read execute
/////////////////////////////////////
fstat //get the file status
DESCRIPTION
These functions return information about a file. No permissions are required
 on the file itself, but-in the case of stat() and lstat() - execute (search)
 permission is required on all of the directories in path that lead to the
file.
struct stat {
    dev_t     st_dev;     /* ID of device containing file */
    ino_t     st_ino;     /* inode number */
    mode_t    st_mode;    /* protection */
    nlink_t   st_nlink;   /* number of hard links */
    uid_t     st_uid;     /* user ID of owner */
    gid_t     st_gid;     /* group ID of owner */
    dev_t     st_rdev;    /* device ID (if special file) */
    off_t     st_size;    /* total size, in bytes */
    blksize_t st_blksize; /* blocksize for file system I/O */
    blkcnt_t  st_blocks;  /* number of 512B blocks allocated */
    time_t    st_atime;   /* time of last access */
    time_t    st_mtime;   /* time of last modification */
    time_t    st_ctime;   /* time of last status change */
};//use fstat then mmap the data  then mprotect 
////mprotect
mprotect, pkey_mprotect - set protection on a region of memory
       mprotect() changes the access protections for the calling process's
       memory pages containing any part of the address range in the interval
       [addr, addr+len-1].  addr must be aligned to a page boundary.
'//    
//set_tid_address
 - set pointer to thread ID
//get_robust_list, set_robust_list - get/set list of robust futexes
The robust futex implementation needs to maintain per-thread lists of
 robust futexes which are unlocked when the thread exits. These lists are 
 managed in user space; the kernel is only notified about the location of 
 the head of the list.
//sigaction 
- examine and change a signal action
//sigprocmask 
- examine and change blocked signals
//getrlimit,
 setrlimit, prlimit - get/set resource limits
//ioctl
 - control device
  int ioctl(int fd, unsigned long request, ...);
    The ioctl() function manipulates the underlying device parameters of
       special files.  In particular, many operating characteristics of
       character special files (e.g., terminals) may be controlled with
       ioctl() requests.  The argument fd must be an open file descriptor.




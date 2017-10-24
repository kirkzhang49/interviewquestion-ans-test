RAID level 0 – Striping
In a RAID 0 system data are split up in blocks that get written across all 
the drives in the array. By using multiple disks (at least 2) at the same
 time, this offers superior I/O performance. This performance can be 
 enhanced further by using multiple controllers, ideally one controller
 per disk.
 Advantages
RAID 0 offers great performance, both in read and write operations.
There is no overhead caused by parity controls.
All storage capacity is used, there is no overhead.
The technology is easy to implement.
Disadvantages
RAID 0 is not fault-tolerant. If one drive fails, all data in the RAID 0
 array are lost. It should not be used for mission-critical systems.
 /////////////////////////////
 RAID level 1 – Mirroring
 Data are stored twice by writing them to both the data drive
  (or set of data drives) and a mirror drive (or set of drives) . 
  If a drive fails, the controller uses either the data drive or the 
  mirror drive for data recovery and continues operation. 
  You need at least 2 drives for a RAID 1 array.
  ////Advantages
RAID 1 offers excellent read speed and a write-speed 
that is comparable to that of a single drive.///
In case a drive fails, data do not have to be rebuild,
they just have to be copied to the replacement drive.
RAID 1 is a very simple technology.
Disadvantages
The main disadvantage is that the effective storage capacity is only
 half of the total drive capacity because all data get written twice.
 ///
Software RAID 1 solutions do not always allow a hot swap of a failed drive.
That means the failed drive can only be replaced after powering down 
the computer it is attached to. For servers that are used simultaneously
 by many people, this may not be acceptable. Such systems typically use
  hardware controllers that do support hot swapping.//
RAID-1 is ideal for mission critical storage, for instance for
accounting systems. It is also suitable for small servers in 
which only two data drives will be used.
////
RAID level 5 //Striping with prity most common secure RAID level. 
//It requires at least 3 drives but can work with up to 16. Data blocks
//are striped across the drives and on one drive a parity checksum of all 
//the block data is written. 
Advantages
Read data transactions are very fast while write data transactions 
are somewhat slower (due to the parity that has to be calculated).
If a drive fails, you still have access to all data, even while the 
failed drive is being replaced and the storage controller rebuilds the
 data on the new drive.
////
Disadvantages
Drive failures have an effect on throughput, 
although this is still acceptable.
This is complex technology. If one of the disks in an array using 4TB disks
 fails and is replaced, restoring the data (the rebuild time) may take a d
 ay or longer, depending on the load on the array and the speed of the 
 controller. If another disk goes bad during that time, data are lost
  forever
  //RAID 5 is a good all-round system that combines efficient storage with excellent 
  //security and decent performance. 
RAID level 6 – Striping with double parity
RAID 6 is like RAID 5, but the parity data are written to two drives.
 That means it requires at least 4 drives and can withstand 2 drives 
 dying simultaneously. 
Advantages
Like with RAID 5, read data transactions are very fast.
If two drives fail, you still have access to all data, even while 
the failed drives are being replaced. So RAID 6 is more secure than RAID 5.
Disadvantages
Write data transactions are slowed down due to the parity that has to be 
calculated.
Drive failures have an effect on throughput, although this is still
 acceptable.
This is complex technology. Rebuilding an array in which one drive 
failed can take a long time.
///
Ideal use
RAID 6 is a good all-round system that combines efficient storage with 
excellent security and decent performance. It is preferable over RAID 5 
in file and application servers that use many large drives for data storage.
//
RAID level 10 – combining RAID 1 & RAID 0
It is possible to combine the advantages (and disadvantages) of RAID 0 and RAID 1
 in one single system. This is a nested or hybrid RAID configuration. 
 It provides security by mirroring all data on secondary drives while using 
 striping across each set of drives to speed up data transfers.

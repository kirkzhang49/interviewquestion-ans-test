//check for i/o disk 
sar 1 3
//09:25:01 AM     CPU     %user     %nice   %system   %iowait    %steal     %idle
//09:35:01 AM     all      0.11      0.00      0.01      0.00      0.00     99.88
//collect,report or save system activity infomation 
$ iostat -x 1
//Linux 3.5.2-x86_64-linode26 (linode)    11/08/2012      _x86_64_        (4 CPU)

//avg-cpu:  %user   %nice %system %iowait  %steal   %idle
//           0.84    0.00    0.08    1.22    0.07   97.80
//Device:         rrqm/s   wrqm/s     r/s     w/s   rsec/s   wsec/s avgrq-sz avgqu-sz   await  svctm  %util
//xvda              0.09     1.02    2.58    0.49   112.79    12.11    40.74     0.15
iotop //disk ip 
//memory usage of linux 
free -m 
//The free command is the most simple and easy to use command to check 
//memory usage on linux. Here is a quick example
///
cat  /proc/meminfo
//Check the values of MemTotal, MemFree, Buffers, Cached, SwapTotal, SwapFree.
//They indicate same values of memory usage as the free command.
//detail of info 
vmstat //lick meminfo
//top , Htop // Htop is graph one of top , us iotop to check disk io 

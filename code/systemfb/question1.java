1.
2.
 一个 process 突然消耗了大量的内存， 导致其他进程特别慢，top 检测不到。咋办?
 //ps aux
  ps aux --sort -rss
 1.1 如果这个进程是必要的，但是又不想让他吃太多内存导致其他进程变慢怎么办?
   prlimit --rss=400000 --pid <pid>
   //
 1.2 cpu idle, 但是 mem 消耗很大， 会是什么情况?
 Idle, which means it has nothing to do.
Running a user space program, like a command shell, an email server, or a compiler.
Running the kernel, servicing interrupts or managing resources.
Alternately referred to as a processor, central processor, or microprocessor,
///
the CPU (pronounced sea-pea-you) is the Central Processing Unit of the computer. A computer'
s CPU handles all instructions it receives from hardware and software running
 on the computer.'
It's high because that saves effort. It takes effort to make memory free. And if you do that, it just takes 
effort to make it used again. So, to save effort, modern operating systems only make memory free if they have 
absolutely no other choice.

If you're thinking "I want memory free now so I can use it later", banish that thought from your mind.
 Memory does not have to be free now to use it later. It can be used now and also be used later. 
 So there's no painful tradeoff here. Using memory is a pure win.

Whatever your problem is, high memory usage is not it. That's a sign of a normally functioning system.
////// load avg high but cpu usage low there are no relationship between load avg and cpu usage 
////// check io wait  
第二题是一个troubleshooting问题，没有答出那边想要的答案，问的是log in一个系统之后发现load averag非常高，但CPU usage很低，
问是怎么回事？那边给解释了一下load average是指runnable process queue的平均长度，也就是说有很多任务在等待，
但是CPU并没有被占用。期间那边有引导我去分析，我也基本就是把所知道的各种可能问题都说了一边但那边还是不太满意。
最后我大概说是因为kernel在等什么东西，其实这个时候答案已经很接近了，最后那边告诉我是因为有人在
一个mounted filesystem里面运行了什么东西，然后可能是连接fail了之类，kernel就一直在等I/O完成。
virtual memory ballooning
http://searchservervirtualization.techtarget.com/definition/memory-ballooning
Memory leak maybe 
In computer science, a memory leak is a type of resource leak that occurs when a computer program 
incorrectly manages memory allocations[1] in such a way that memory which is no longer needed is not 
released. In object-oriented programming, a memory leak may happen when an object is stored in memory 
but cannot be accessed by the running code.[2] A memory leak has symptoms similar to a number 
of other problems and generally can only be diagnosed by a programmer with access to the program 
s source code.
 1.3 假设可以看到 code, 如何 check?
 http://stackoverflow.com/questions/6261201/how-to-find-memory-leak-in-a-c-code-project
 2. 本来好好的 server, 突然某天早上 11 点 memory 消耗巨大，怎么 check?
 2.1 没有很多程序在运行， 那又会是什么原因?
 http://blog.scoutapp.com/articles/2014/07/31/slow_server_flow_chart
 ps -aux | sort -k4nr | head -n 10
 是服务器被黑了,马上查看进程ps aux,这一看就发现了问题,有个脚本在进程里有很多个产生,马上执行下面命令进行kill掉:
kill -9 $(ps aux | grep 进程名 |grep -v grep| awk '{print $2}')
现在这看内存使用率,内存终于正常了,好了,再观察几分钟,没有问题退出服务器了,继续检查那个脚本的问题.

ps:这里要强调的事,不要根据自己的直觉去随便以为是什么的问题,最好是调查清楚了再去执行,比如我这里就是根据自己的直觉以为是nginx和php-fpm的问题,还好是跟老大打了招呼重启的,不然后果很严重.

再给大家一个查看内存占用最大的进程的命令:
ps aux| grep -v "USER" |sort -n -r -k 4 |awk 'NR==1{ print $0}'
other application use this server 
ps aux --sort -rss
 2.2 各种情况。。。


3. 在你之前，有个人 type ls . 结果卡住了， 按 ctrl + c 没用(你 TM 在逗我。。)
3.1 你看不到路径(我说可能是路径的问题)， 那怎么 check 当前这个 ls 进程在哪个路径
run?  
problem of the path 
//find where the process executing
ps to find ls command pid 
ls -l /proc/pid/exe 
3.2 OK,你通过某些方式看到了(这个是可以做到的)， 且路径在 /mnt/var/xxx 那可能是什么
原因?
very large numbers of files inside this path
use ls -f  //unsort option of ls 
3.3 假设是 AWS 的 EBS， 那可能会是什么原因? 如何解决?
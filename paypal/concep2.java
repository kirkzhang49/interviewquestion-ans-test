C++: new memory allocate in heap, declare in stack
memallcoate connect to low level 


Set not allow duplicate,
List allow duplicate
Another key difference between List and Set is that List is an ordered collection,
 List's contract maintains insertion order or element. Set is an unordered collection, 
 you get no guarantee on which order element will be stored. 

Though some of the Set implementation e.g. LinkedHashSet maintains order. 
Also SortedSet and SortedMap e.g. TreeSet and TreeMap maintain a sorting order, imposed by 
using Comparator or Comparable.

Use situation:
access elements frequently by using the index than List is a way to go

Ordered :List
Unique :Set

store data in form of key and value than Map is the way to go

Read more: http://www.java67.com/2013/01/difference-between-set-list-and-map-in-java.html#ixzz4xmYRD3fv

http://www.geeksforgeeks.org/garbage-collection-java/
//Java GC make  assigning to null GC will do it  on in side of method 
Even though programmer is not responsible to destroy useless objects but it is highly recommended 
to make an object unreachable(thus eligible for GC) if it is no longer required.
There are generally four different ways to make an object eligible for garbage collection.
Nullifying the reference variable
Re-assigning the reference variable
Object created inside method
Island of Isolation
//JVM 
http://www.geeksforgeeks.org/jvm-works-jvm-architecture/
JVM 
A Java virtual machine (JVM) is an abstract computing machine that enables a computer to run a Java program.
 There are three notions of the JVM: specification, implementation, and instance. The specification is a document 
 that formally describes what is required of a JVM implementation. Having a single specification ensures all
  implementations are interoperable. A JVM implementation is a computer program that meets the requirements
 of the JVM specification. An instance of a JVM is an implementation running in a process that executes a 
 computer program compiled into Java bytecode.

Java Runtime Environment (JRE) is a software package that contains what is required to run a Java program. 
It includes a Java Virtual Machine implementation together with an implementation of the Java Class Library.
 The Oracle Corporation, which owns the Java trademark, distributes a Java Runtime environment with their 
 Java Virtual Machine called HotSpot.

Java Development Kit (JDK) is a superset of a JRE and contains tools for Java programmers, e.g. a javac compiler. 
The Java Development Kit is provided free of charge either by Oracle Corporation directly, or by the OpenJDK
 open source project, which is governed by Oracle.

 Java applications are called WORA (Write Once Run Everywhere). This means a programmer can develop Java code on one system and can expect it to run on any other 
 Java enabled system without any adjustment. This is all possible because of JVM.

When we compile a .java file, a .class file(contains byte-code) with the same filename is generated by the Java 
compiler. This .class file goes into various steps when we run it. These steps together describe the whole JVM.

Loading : The Class loader reads the .class file, generate the corresponding binary data and save it in 
method area. For each .class file, JVM stores following information in method area.

Fully qualified name of the loaded class and its immediate parent class.
Whether .class file is related to Class or Interface or Enum
Modifier, Variables and Method information etc.

Linking : Performs verification, preparation, and (optionally) resolution.

Verification : It ensures the correctness of .class file i.e. it check whether this file is properly formatted and generated by valid compiler or not. If verification fails, 
we get run-time exception java.lang.VerifyError.
Preparation : JVM allocates memory for class variables and initializing the memory to default values.
Resolution : It is the process of replacing symbolic references from the type with direct references.
 It is done by searching into method area to locate the referenced entity.
Initialization : In this phase, all static variables are assigned with their values defined in the code 
and static block(if any). This is executed executed from top to bottom in a class and from parent to child
 in class hierarchy.

 Method area :In method area, all class level information like class name, immediate parent class name, methods and variables information etc. are stored, including static variables. There is only one method area per JVM, and it is a shared resource.
Heap area :Information of all objects is stored in heap area. There is also one Heap Area per JVM. It is also a shared resource.

Stack area :For every thread, JVM create one run-time stack which is stored here. Every block of this stack is called activation record/stack frame which store methods calls. All local variables of that method are stored in their corresponding frame. After a thread terminate, it’s run-time stack will be destroyed by JVM. It is not a shared resource.

PC Registers :Store address of current execution instruction of a thread. Obviously each thread has separate PC Registers.

Native method stacks :For every thread, separate native stack is created. It stores native method information.

//C++ pointer and reference difference 
Pointers can point nowhere ( NULL ), whereas reference always refer to an object. 

Pointers: A pointer is a variable that holds memory address of another variable. A pointer needs to be 
dereferenced with * operator to access the memory location it points to.

References : A reference variable is an alias, that is, another name for an already existing variable.
 A reference, like a pointer is also implemented by storing the address of an object.
A reference can be thought of as a constant pointer
//more 
http://www.geeksforgeeks.org/pointers-vs-references-cpp/
//memcached vs redis 
https://stackoverflow.com/questions/10558465/memcached-vs-redis

//Sql vs non Sql
Non-Relational means table-less: NoSQL databases are non-relational, hence, very different from SQL databases.
 This means they are easier to manage and they provide a higher level of flexibility with newer data models
 http://www.monitis.com/blog/cc-in-review-the-key-differences-between-sql-and-nosql-dbs/

//SQL
https://www.toptal.com/sql/interview-questions
//The PRIMARY KEY constraint uniquely identifies each record in a database table. Primary keys must contain UNIQUE values, 
//and cannot contain NULL values. A table can have only one primary key, which may consist of single or multiple fields
//A FOREIGN KEY is a key used to link two tables together.
//A FOREIGN KEY is a field (or collection of fields) in one table that refers to the PRIMARY KEY in another table.
https://www.w3schools.com/sql/sql_primarykey.asp
//relational database 
https://www.ntu.edu.sg/home/ehchua/programming/sql/Relational_Database_Design.html
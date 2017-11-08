//Copy Object in java
Create a copy constructor:

class DummyBean {
  private String dummy;

  public DummyBean(DummyBean another) {
    this.dummy = another.dummy; // you can access  
  }
}
//or another easy way clone
Deletable del = new Deletable();
Deletable delTemp = (Deletable ) del.clone();
http://www.javapractices.com/topic/TopicAction.do?Id=71
// disable clone 
  @Override public final Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }
//deep vs shallow copying one as point one as clone
https://www.cs.utexas.edu/~scottm/cs307/handouts/deepCopying.htm

//final varaible 
A final class cannot be subclassed.
A final method cannot be overridden by subclasses
A final variable can only be initialized once

//static 
Static variables
http://www.geeksforgeeks.org/static-keyword-java/
When a variable is declared as static, then a single copy of variable is created and shared among 
all objects at class level. Static variables are, essentially, global variables. All instances of the 
class share the same static variable.

Static methods

When a method is declared with static keyword, it is known as static method. The most common example of a 
static method is main( ) method.As discussed above, Any static member can be accessed before any objects 
of its class are created, and without reference to any object.Methods declared as static have several 
restrictions:

When to use static variables and methods?

Use the static variable for the property that is common to all objects. For example, in class Student, 
all students shares the same college name. Use static methods for changing static variables.

//java design pattern
https://www.tutorialspoint.com/design_pattern/observer_pattern.htm

//java memory leak detection
visualvm
https://www.toptal.com/java/hunting-memory-leaks-in-java
Performance: usually associated with excessive object creation and deletion, long delays in garbage collection,
 excessive operating system page swapping, and more.
//--------//
Resource constraints: occurs when there’s either to little memory available or your memory is too fragmented to 
allocate a large object—this can be native or, more commonly, Java heap-related.
//----------------------------//
Java heap leaks: the classic memory leak, in which Java objects are continuously created without being released. 
This is usually caused by latent object references.
//------------//
Native memory leaks: associated with any continuously growing memory utilization that is outside the Java heap, such as allocations made by JNI code, drivers or even JVM allocations.
In this post, I’ll focus on Java heaps leaks and outline an approach to detect such leaks based on Java VisualVM reports and utilizing a visual interface for analyzing Java technology-based applications while they’re running.
//---//

//---------Immutable----------------//
Immutable means that once the constructor for an object has completed execution that instance can't be altered.

This is useful as it means you can pass references to the object around, without worrying that someone else 
is going to change its contents. Especially when dealing with concurrency, there are no locking issues with
 objects that never change
 class Foo
{
     private final String myvar;

     public Foo(final String initialValue)
     {
         this.myvar = initialValue;
     }

     public String getValue()
     {
         return this.myvar;
     }
}
The string is Immutable in Java because String objects are cached in String pool. Since cached String 
literals are shared between multiple clients there is always a risk, where one client's 
action would affect all another client. For example, if one client changes the value of String "Test" 
to "TEST", all other clients will also see that value as explained in the first example. 
Read more: http://javarevisited.blogspot.com/2010/10/why-string-is-immutable-or-final-in-java.html#ixzz4xlz11OW5
'
//-----benefit of restful API
One of the most popular types of API is REST or, as they’re sometimes known, RESTful APIs. REST or RESTful APIs were designed to take 
advantage of existing protocols. While REST - or Representational State Transfer - can be used over nearly any protocol, when used for 
web APIs it typically takes advantage of HTTP. This means that developers have no need to install additional software or libraries when 
creating a REST API.

One of the key advantages of REST APIs is that they provide a great deal of flexibility. Data is not tied to resources or methods, 
so REST can handle multiple types of calls, return different data formats and even change structurally with the correct implementation
 of hypermedia. This flexibility allows developers to build an API that meets your needs while also meeting the needs of very diverse 
customers. 
///restful api is stateless
https://stackoverflow.com/questions/34130036/how-to-understand-restful-api-is-stateless
//advantage 
https://bbvaopen4u.com/en/actualidad/rest-api-what-it-and-what-are-its-advantages-project-development

//3 type of webservice 
https://stackoverflow.com/questions/3764681/what-are-wsdl-soap-and-rest

A WSDL is an XML document that describes a web service. It actually stands for Web Services Definition Language.

SOAP is an XML-based protocol that lets you exchange info over a particular protocol (can be HTTP or SMTP, for example) between applications. It stands 
for Simple Object Access Protocol and uses XML for its messaging format to relay the information.

REST is an architectural style of networked systems and stands for Representational State Transfer. Its not a standard itself, 
but does use standards such as HTTP, URL, XML, etc.

//rest vs soap 
Benefits of REST Over SOAP

In addition to using HTTP for simplicity, REST offers a number of other benefits over SOAP:

REST allows a greater variety of data formats, whereas SOAP only allows XML.
Coupled with JSON (which typically works better with data and offers faster parsing), REST is generally considered easier to work with.
Thanks to JSON, REST offers better support for browser clients.
REST provides superior performance, particularly through caching for information that’s not altered and not dynamic.
It is the protocol used most often for major services such as Yahoo, Ebay, Amazon, and even Google.
REST is generally faster and uses less bandwidth. It’s also easier to integrate with existing websites with no need to refactor site
 infrastructure. This enables developers to work faster rather than spend time rewriting a site from scratch. Instead, they can simply 
 add additional functionality.

 Because you can achieve most outcomes using either protocol, it’s sometimes a matter of personal preference. However,
  there are some use cases that SOAP tends to be better-suited for. For instance, if you need more robust security, SOAP’s support
   for WS-Security can come in handy. It offers some additional assurances for data privacy and integrity. It also provides support
    for identity verification through intermediaries rather than just point-to-point, as provided by SSL (which is supported by both 
    SOAP and REST).
//
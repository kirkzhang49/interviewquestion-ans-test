What is the difference between an interface and an abstract class?
Abstract class	: 1) Abstract class can have abstract and non-abstract methods.	
2) Abstract class doesn't support multiple inheritance.	
3) Abstract class can have final, non-final, static and non-static variables.	
4) Abstract class can have static methods, main method and constructor.	
5) Abstract class can provide the implementation of interface.	
6) The abstract keyword is used to declare abstract class.	
________________________________________________________________
Interface :Interface can have only abstract methods.
Interface supports multiple inheritance.
Interface has only static and final variables.
Interface can't have static methods, main method or constructor.
Interface can't provide the implementation of abstract class.
The interface keyword is used to declare interface.
________________________________________________________________
public abstract class Shape{
public abstract void draw();
}
________________________________________________________________
Example:
public interface Drawable{
void draw();
}
________________________________________________________________
S.O.L.I.D STANDS FOR:

When expanded the acronyms might seem complicated, but they are pretty simple to grasp.

S – Single-responsiblity principle
O – Open-closed principle
L – Liskov substitution principle
I – Interface segregation principle
D – Dependency Inversion Principle
________________________________________________________________
1. Encapsulation:
Encapsulation means that the internal representation of an object is generally hidden from view outside 
of the object’s definition. Typically, only the object’s own methods can directly inspect or manipulate
 its fields.
 2. Abstraction
Data abstraction and encapuslation are closely tied together, because a simple definition of data 
abstraction is the development of classes, objects, types in terms of their interfaces and functionality,
 instead of their implementation details. Abstraction denotes a model, a view, or some other focused 
 representation for an actual item.
 ________________________________________________________________
 3. Inheritance
Inheritance is a way to reuse code of existing objects, or to establish a subtype from an 
existing object, or both, depending upon programming language support. In classical inheritance 
where objects are defined by classes, classes can inherit attributes and behavior from pre-existing 
classes called base classes, superclasses, parent classes or ancestor classes. The resulting classes
 are known as derived classes, subclasses or child classes. The relationships of classes through 
 inheritance gives rise to a hierarchy.
 ________________________________________________________________
 4. Polymorphism
Polymorphism means one name, many forms. Polymorphism manifests itself by having multiple methods all
 with the same name, but slightly different functionality.
There are 2 basic types of polymorphism.
Overridding, also called run-time polymorphism. For method overloading, the compiler determines
 which method will be executed, and this decision is made when the code gets compiled.
Overloading, which is referred to as compile-time polymorphism. Method will be used for method
overriding is determined at runtime based on the dynamic type of an object.
________________________________________________________________

Construction can be private example singleton desgin in java

Why construction private 
Some reasons where you may need private constructor: The constructor can only be accessed from static 
factory method inside the class itself. Singleton can also belong to this category. 
A utility class, that only contains static methods. Yes and it is used to prevent instantiation 
and subsequently overriding.
____________________________________________________________________
 the difference between  == and equals -> first compare value second compare object

cat sort unique diff
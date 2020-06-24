# Queues

## What is a queue?
A queue is used to represent a first-in first-out (FIFO) collection of objects.
It should be used for tasks where you need first-in, first-out access of items.

### Usage
A queue should at least contain the methods enqueue and dequeue.

![](images/queue.jpg)

Enqueue is used for adding an item at the end of the queue.

Dequeue removes the beginning element of the queue and returns the value.

In this project we use the methods that are declared by the interface IQueue.

```java
public interface IQueue<T> {

  boolean offer(T obj);

  T poll();

  T remove();

  T peek();

  T element();
}
```

The methods offer and poll respectively are the same as the methods enqueue (offer) and dequeue (poll) described above.

The method peek also returns the head element like poll but it does not delete it.

The methods remove and element offers the same functionality like poll (remove) and peek (element).
The only difference is that remove and element throws a ```NoSuchElementException``` if the queue is empty - poll and peek just returns null in that case.

### Implementation
This project offers two implements for IQueue.

```StringQueue``` offers the previous explained methods for strings only while ```Queue``` can be used with any generic type.

### Generics
Generics can be used to allow to pass the type (Integer, String, user defined types, etc...) like a parameter to methods, classes and interfaces.

< > are used to specify the parameter type. Usually a capital Letter - T in most cases - is used as type placeholder.
When using the interface, class or method the desired type is also written in < >.

For example a simple generic class could look like that:
```java
public class GenericTest<T> 
{ 
    // An object of type T is declared 
    T obj; 
    Test(T obj) {  this.obj = obj;  }  // constructor 
    public T getObject()  { return this.obj; }  // returns the obj
} 

class Main 
{ 
    public static void main (String[] args) 
    { 
        //Instance of Integer type 
        GenericTest<String> iObj = new GenericTest<String>("test"); 
        System.out.println(iObj.getObject()); 
   
        //Instance of String type 
        Test<Integer> sObj = new GenericTest<Integer>(100); 
        System.out.println(sObj.getObject()); 
    } 
}
```

And quite similar on method level:


```java
public class GenericTest
{ 
    // A Generic method example 
    static <T> void genericOutput(T obj) 
    { 
        System.out.println(obj.getClass().getName() + " = " + obj); 
    }

    public static void main(String[] args) 
    { 
         // Calling generic method with Integer argument 
        genericOutput(100); 
   
        // Calling generic method with String argument 
        genericOutput("test"); 
    } 
}
```

## Test a queue?

### Code Coverage
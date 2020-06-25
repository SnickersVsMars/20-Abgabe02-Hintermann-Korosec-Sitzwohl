# Queues

## What is a queue?
A queue is used to represent a first-in first-out (FIFO) collection of objects.
It should be used for tasks where you need first-in, first-out access of items.

### Where to use it?
There are many examples where a queue is the right choice:
- music playlist
- task scheduling
- virtual waiting line for example for ticket sale
- stock management
- any other FIFO related task 

### How to use it?
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
There are several reasonable test cases for a queue:

- Add objects to the queue til max size is reached
    - check if false is returned by the ```offer()``` method, when max size is reached
    - example test with queue size of 1:
  ```java
  @Test
  @DisplayName("Testing offer method with too many offers")
  public void testOfferOverflow() {
      assertTrue(sqSm.offer("SuccessfulTestString"),
              "Expected offer to return true.");
      assertFalse(sqSm.offer("OverflowTestString"),
              "Expected offer to return false due to overflow.");
  }
  ```  
- Add several objects to the queue and check if the are returned in the same order (fifo) by calling ```poll()``` several times 
    - Add Test1 und Test2 to queue and check if the are returned in the same way by calling ```poll()``` two times
 ```java
      @Test
      @DisplayName("Testing that poll returns and removes the head of the queue")
      public void testPollReturnsAndRemovesHead() {
          String testString1 = "Test1";
          String testString2 = "Test2";
  
          sqLg.offer(testString1);
          sqLg.offer(testString2);
  
          String result1 = sqLg.poll();
          String result2 = sqLg.poll();
  
          assertEquals(testString1, result1,
                  "Expected head to be \"" + testString1 + "\" but was " + result1);
          assertEquals(testString2, result2,
                  "Expected head to be \"" + testString2 + "\" but was " + result2);
      }
```

- Add several objects to the queue and check if the last-inserted object is returned by the methods  ```peek()``` or ```element()``` even if the called multiple times
- Try to call the methods ```poll()```/```remove()``` and ```peek()```/```element()``` respectively on an empty queue
    - check if null is returned or if an Exception is thrown depending on the implementation of the method

### Code Coverage
Code coverage (or test coverage) is a measure used to describe the degree to which the source code of a program is executed while running test cases.
A program with high code coverage has had more of its source code executed during testing. As a result of this the program has a lower chance of containing undetected bugs compared to a program with low code coverage.

While a code coverage of 100% is not always possible or even recommended this project has reached it.
This was possible because of the small project size and less code complexity.


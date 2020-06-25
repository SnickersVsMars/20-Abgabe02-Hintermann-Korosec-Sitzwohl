# Queues

## What is a queue

A queue is used to represent a first-in first-out (FIFO) collection of objects.  
It should be used for tasks where you need first-in, first-out access of items.

### Where to use it

There are many examples where a queue is the right choice:

- music playlist
- task scheduling
- a real life waiting line (e.g. for a ticket sale)
- stock management
- any other FIFO related task

### How to use it

A queue should at least contain the methods enqueue and dequeue.

![Image showing enqueue and dequeue](images/queue.jpg)

Enqueue is used to add an item at the end of the queue.

Dequeue removes the first element from the queue and returns the value.

In this project we used the following methods, declared by the interface IQueue:

```java
public interface IQueue<T> {

  boolean offer(T obj);

  T poll();

  T remove();

  T peek();

  T element();
}
```

The methods offer and poll respectively are similar to the methods enqueue (offer) and dequeue (poll) described above.

The method peek also returns the head element like poll but it does not delete it.

The methods remove and element offer the same functionality as poll (remove) and peek (element).
The only difference is that remove as well as element throw a `NoSuchElementException` if the queue is empty - poll and peek just return `null` in that case.

### Implementation

This project offers two implementations for IQueue.

`StringQueue` offers the previous explained methods for strings only, while `Queue` can be used with any generic type.

### Generics

Generics can be used to pass parameters of any type (Integer, String, user defined types, etc...) to methods, classes and interfaces.

The diamond operator `<>` is used to specify the parameter type. Usually a capital Letter - T in most cases - is used as a type placeholder.
When using the interface, class or method the desired type needs to be specified in the diamond operator (e.g. `<String>` to use String type parameters).

A simple generic class could look like this:

```java
public class GenericTest<T>
{
    // An object of type T is declared
    T obj;
    Test(T obj) {  this.obj = obj;  }  // constructor
    public T getObject()  { return this.obj; }  // returns the obj
}

public class Main
{
    public static void main (String[] args)
    {
        //Instance of String type
        GenericTest<String> iObj = new GenericTest<String>("test");
        System.out.println(iObj.getObject());

        //Instance of Integer type
        Test<Integer> sObj = new GenericTest<Integer>(100);
        System.out.println(sObj.getObject());
    }
}
```

Quite similar on method level:

```java
public class GenericTest
{
    // A Generic method example
    private static <T> void genericOutput(T obj)
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

## Test a queue

There are several reasonable test cases for a queue:

- Add objects to the queue until max size is reached, then check if false is returned by the `offer()` method.
    - Example test with a queue size of 1:

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

- Add several objects to the queue and check if they are returned in the intended order (fifo) by calling `poll()` several times.
    - Example with 2 strings: Add "Test1" und "Test2" to the queue, then call `poll()` twice to check whether the strings are returned in the same order as they were added or not

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

- Add several objects to the queue and check if the last-inserted object is returned by the methods `peek()` or `element()`, even if they are called multiple times.
- Try to call the methods `poll()`/`remove()` and `peek()`/`element()` respectively on an empty queue.
    - Depending on the implementation of the method, check if null is returned, or an Exception is thrown.

### Code Coverage

Code coverage (or test coverage) is a measure used to describe the degree to which the source code of a program is executed while running test cases.
A program with high code coverage has had more of its source code executed during testing. As a result of that, the program has a lower chance of containing undetected bugs compared to a program with low code coverage.

While a code coverage of 100% is not always possible or even recommended, this project has reached it.
The complete coverage was reached, due to the small project size, and a rather low degree of code complexity.

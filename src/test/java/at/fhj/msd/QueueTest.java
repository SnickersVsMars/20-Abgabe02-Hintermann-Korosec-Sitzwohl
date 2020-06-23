package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Queue with generics implementation")
public class QueueTest {

    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue(3);
    }

    @Test
    @DisplayName("Testing if maximum works properly")
    void testOfferMaximumReached() {
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        assertEquals(false,queue.offer("four"), "Expected \"false\" but element got added!");
    }

    @Test
    @DisplayName("Testing if adding works properly")
    void testOfferSimpleAdd() {
        queue.offer("one");
        assertEquals(true,queue.offer("two"), "Expected \"true\" but element was not added!");
    }

    @Test
    @DisplayName("Testing if polling an element works properly")
    void testSimplePoll() {
        queue.offer("one");
        queue.offer("two");
        queue.poll();
        assertEquals("two",queue.peek());
    }

    @Test
    @DisplayName("Testing if polling works properly when size 0")
    void testPollButNoElement() {
        assertNull(queue.poll());
    }

    @Test
    @DisplayName("Remove when null to throw NoSuchElementException")
    void testRemoveWhenNull() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.remove();
        });
    }

    @Test
    @DisplayName("Remove element from queue")
    void testRemoveWhenNotNull() {
        queue.offer("one");
        queue.offer("two");
        queue.remove();
        assertEquals("two",queue.peek());
    }

    @Test
    @DisplayName("Testing returned element of remove()")
    void testReturnedRemoveElement() {
        queue.offer("one");
        assertEquals("one",queue.remove());
    }

    @Test
    @DisplayName("Testing peek() with element in queue")
    void testPeekWithElement() {
        queue.offer("one");
        assertEquals("one",queue.peek());
    }

    @Test
    @DisplayName("Testing peek() with no element")
    void testPeekNoElement() {
        assertEquals(null,queue.peek());
    }

    @Test
    @DisplayName("Testing element() with elements in queue")
    void testElementWithElement() {
        queue.offer("one");
        assertEquals("one", queue.element());
    }

    @Test
    @DisplayName("Testing element() with no elements in queue")
    void testElementException() {
            assertThrows(NoSuchElementException.class, () -> {
                queue.element();
            });
    }
}
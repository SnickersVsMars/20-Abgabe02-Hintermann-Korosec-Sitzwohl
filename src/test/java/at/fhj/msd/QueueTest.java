package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

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
        assertEquals(false,queue.offer("four"));
    }

    @Test
    @DisplayName("Testing if adding works properly")
    void testOfferSimpleAdd() {
        queue.offer("one");
        assertEquals(true,queue.offer("two"));
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
    @DisplayName("")
    void testPeek() {
    }

    @Test
    @DisplayName("")
    void testElement() {
    }
}
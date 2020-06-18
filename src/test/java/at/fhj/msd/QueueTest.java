package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue(3);
    }

    @Test
    @DisplayName("Testing if maximum works properly")
    void offerMaximumReached() {
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        assertEquals(false,queue.offer("four"));
    }

    @Test
    @DisplayName("Testing if adding works properly")
    void offerSimpleAdd() {
        queue.offer("one");
        assertEquals(true,queue.offer("two"));
    }

    @Test
    @DisplayName("Testing if polling an element works properly")
    void pollSimpleRemove() {
        queue.offer("one");
        queue.offer("two");
        queue.poll();
        assertEquals("two",queue.peek());
    }

    @Test
    @DisplayName("Testing if polling works properly when size 0")
    void pollRemoveButNoElement() {
        assertNull(queue.poll());
    }

    @Test
    @DisplayName("")
    void remove() {
    }

    @Test
    @DisplayName("")
    void peek() {
    }

    @Test
    @DisplayName("")
    void element() {
    }
}
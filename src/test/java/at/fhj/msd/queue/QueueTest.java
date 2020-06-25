package at.fhj.msd.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class testing the functionalities of the generic Queue class with Strings
 *
 * @author      Tobias Hintermann
 * @version     %I%, %G%
 * @since       1.0
 */
@DisplayName("Testing generic Queue with Strings")
public class QueueTest {

    private Queue<String> queue;

    /**
     * Inits a Queue with maxSize set to three
     */
    @BeforeEach
    void setUp() {
        queue = new Queue<String>(3);
    }

    /**
     * Tests maxSize via adding four Strings to the queue while maxSize is set to three
     */
    @Test
    @DisplayName("Testing if maximum works properly")
    void testOfferMaximumReached() {
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        assertFalse(queue.offer("four"),
                "Expected \"false\" but element got added!");
    }

    /**
     * Tests offer() via adding one String to queue
     */
    @Test
    @DisplayName("Testing if offer()-ing works properly")
    void testOfferSimpleAdd() {
        queue.offer("one");
        assertTrue(queue.offer("two"),
                "Expected \"true\" but element was not added!");
    }

    /**
     * Tests poll() via adding two Strings and poll()-ing one
     */
    @Test
    @DisplayName("Testing if poll()-ing an element works properly")
    void testSimplePoll() {
        queue.offer("one");
        queue.offer("two");
        queue.poll();
        assertEquals("two",queue.peek(),
                "Expected head to be \"two\" but was:" + queue.peek());
    }

    /**
     * Tests poll() via poll()-ing an empty queue
     */
    @Test
    @DisplayName("Testing poll() when queue empty")
    void testPollButNoElement() {
        assertNull(queue.poll(),
                "Expected to be \"null\" but queue was not empty!");
    }

    /**
     * Tests the returned element of poll() via adding one String than poll()-ing it
     */
    @Test
    @DisplayName("Testing returned element of poll()")
    void testReturnedPollElement() {
        queue.offer("one");
        String result = queue.poll();
        assertEquals("one", result,
                "Expected returned element to be \"one\" but was:" + result);
    }

    /**
     * Tests remove() via remove()-ing when queue is empty
     */
    @Test
    @DisplayName("Testing remove() when null, throws NoSuchElementException")
    void testRemoveWhenNull() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.remove();
        },"Expected to throw \"NoSuchElementException\"!");
    }

    /**
     * Tests remove() via adding two Strings and remove()-ing one
     */
    @Test
    @DisplayName("Testing remove() from queue")
    void testRemoveWhenNotNull() {
        queue.offer("one");
        queue.offer("two");
        queue.remove();
        assertEquals("two",queue.peek(),
                "Expected to be \"two\" but was:" + queue.peek());
    }

    /**
     * Tests returned element of remove() via adding one String than remove()-ing it
     */
    @Test
    @DisplayName("Testing returned element of remove()")
    void testReturnedRemoveElement() {
        queue.offer("one");
        String result = queue.remove();
        assertEquals("one",result,
                "Expected returned element to be \"one\" but was:" + result);
    }

    /**
     * Tests peek() via adding one String and comparing it
     */
    @Test
    @DisplayName("Testing peek() with element in queue")
    void testPeekWithElement() {
        queue.offer("one");
        assertEquals("one",queue.peek(),
                "Expected to be \"one\" but was:" + queue.peek());
    }

    /**
     * Tests peek() via peek()-ing an empty queue
     */
    @Test
    @DisplayName("Testing peek() with no element")
    void testPeekNoElement() {
        assertNull(queue.peek(),
                "Expected to be \"null\" but was:" + queue.peek());
    }

    /**
     * Tests element() via adding one String and comparing it to the returned String
     */
    @Test
    @DisplayName("Testing element() with elements in queue")
    void testElementWithElement() {
        queue.offer("one");
        assertEquals("one", queue.element(),
                "Expected to return \"one\" but was:" + queue.element());
    }

    /**
     * Tests element() via an empty queue
     */
    @Test
    @DisplayName("Testing element() with no elements, throws NoSuchElementException")
    void testElementException() {
            assertThrows(NoSuchElementException.class, () -> {
                queue.element();
            },"Expected to throw \"NoSuchElementException\"!");
    }
}
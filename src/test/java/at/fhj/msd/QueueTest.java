package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Queue with generics implementation")
public class QueueTest {

    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<String>(3);
    }

    @Test
    @DisplayName("Testing if maximum works properly")
    void testOfferMaximumReached() {
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        assertFalse(queue.offer("four"),
                "Expected \"false\" but element got added!");
    }

    @Test
    @DisplayName("Testing if offer()-ing works properly")
    void testOfferSimpleAdd() {
        queue.offer("one");
        assertTrue(queue.offer("two"),
                "Expected \"true\" but element was not added!");
    }

    @Test
    @DisplayName("Testing if poll()-ing an element works properly")
    void testSimplePoll() {
        queue.offer("one");
        queue.offer("two");
        queue.poll();
        assertEquals("two",queue.peek(),
                "Expected head to be \"two\" but was:" + queue.peek());
    }

    @Test
    @DisplayName("Testing poll() when queue empty")
    void testPollButNoElement() {
        assertNull(queue.poll(),
                "Expected to be \"null\" but queue was not empty!");
    }

    @Test
    @DisplayName("Testing returned element of poll()")
    void testReturnedPollElement() {
        queue.offer("one");
        String result = (String) queue.poll();
        assertEquals("one", result,
                "Expected returned element to be \"one\" but was:" + result);
    }

    @Test
    @DisplayName("Testing remove() when null, throws NoSuchElementException")
    void testRemoveWhenNull() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.remove();
        },"Expected to throw \"NoSuchElementException\"!");
    }

    @Test
    @DisplayName("Testing remove() from queue")
    void testRemoveWhenNotNull() {
        queue.offer("one");
        queue.offer("two");
        queue.remove();
        assertEquals("two",queue.peek(),
                "Expected to be \"two\" but was:" + queue.peek());
    }

    @Test
    @DisplayName("Testing returned element of remove()")
    void testReturnedRemoveElement() {
        queue.offer("one");
        String result = (String) queue.remove();
        assertEquals("one",result,
                "Expected returned element to be \"one\" but was:" + result);
    }

    @Test
    @DisplayName("Testing peek() with element in queue")
    void testPeekWithElement() {
        queue.offer("one");
        assertEquals("one",queue.peek(),
                "Expected to be \"one\" but was:" + queue.peek());
    }

    @Test
    @DisplayName("Testing peek() with no element")
    void testPeekNoElement() {
        assertNull(queue.peek(),
                "Expected to be \"null\" but was:" + queue.peek());
    }

    @Test
    @DisplayName("Testing element() with elements in queue")
    void testElementWithElement() {
        queue.offer("one");
        assertEquals("one", queue.element(),
                "Expected to return \"one\" but was:" + queue.element());
    }

    @Test
    @DisplayName("Testing element() with no elements, throws NoSuchElementException")
    void testElementException() {
            assertThrows(NoSuchElementException.class, () -> {
                queue.element();
            },"Expected to throw \"NoSuchElementException\"!");
    }
}
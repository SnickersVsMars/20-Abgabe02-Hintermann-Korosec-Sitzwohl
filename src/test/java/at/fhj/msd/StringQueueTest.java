package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Queues with string implementation")
public class StringQueueTest {
    private StringQueue sq;

    @BeforeEach
    public void setup() {
        sq = new StringQueue(1);
    }

    @Test
    @DisplayName("Testing offer method")
    public void testOfferEmptyQueue() {
        assertTrue(sq.offer("Test"),
                "Expected offer to return true.");
    }

    @Test
    @DisplayName("Testing offer method with too many offers")
    public void testOfferOverflow() {
        assertTrue(sq.offer("SuccessfulTestString"),
                "Expected offer to return true.");
        assertFalse(sq.offer("OverflowTestString"),
                "Expected offer to return false due to overflow.");
    }

    @Test
    @DisplayName("Testing that poll returns the head of the queue")
    public void testPollReturnsHead() {
        String testString = "Test";

        sq.offer(testString);
        String result = sq.poll();

        assertEquals(testString, result,
                "Expected head to be \"" + testString + "\" but was " + result);
    }

    @Test
    @DisplayName("Testing that poll returns and removes the head of the queue")
    public void testPollReturnsAndRemovesHead() {
        String testString = "Test";

        sq.offer(testString);
        String result = sq.poll();

        assertEquals(testString, result,
                "Expected head to be \"" + testString + "\" but was " + result);
        assertTrue(sq.getElements().isEmpty(), "Expected list to be empty.");
    }

    @Test
    @DisplayName("Testing poll method with empty queue")
    public void testPollEmptyQueue() {
        String result = sq.poll();

        assertNull(result);
    }

    @Test
    @DisplayName("Testing that remove returns the head of the queue")
    public void testRemoveReturnsHead() {
        String testString = "Test";

        sq.offer(testString);
        String result = sq.remove();

        assertEquals(testString, result,
                "Expected head to be \"" + testString + "\" but was " + result);
    }

    @Test
    @DisplayName("Testing that remove returns and removes the head of the queue")
    public void testRemoveReturnsAndRemovesHead() {
        String testString = "Test";

        sq.offer(testString);
        String result = sq.remove();

        assertEquals(testString, result,
                "Expected head to be \"" + testString + "\" but was " + result);
        assertTrue(sq.getElements().isEmpty(), "Expected list to be empty.");
    }

    @Test
    @DisplayName("Testing remove method with empty queue")
    public void testRemoveEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> {
            sq.remove();
        });
    }
   // TODO Write your own tests
}
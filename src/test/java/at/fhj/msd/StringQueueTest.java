package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Queues with string implementation")
public class StringQueueTest {
    private StringQueue sq;
    private StringQueue sqLarge;

    @BeforeEach
    public void setup() {
        sq = new StringQueue(1);
        sqLarge = new StringQueue(5);
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


    @Test
    @DisplayName("Testing peek method with empty queue")
    public void testPeekEmptyQueue() {
        String element = sq.peek();
        assertNull(element, "Expected head to be null but was " + element);
    }

    @Test
    @DisplayName("Testing peek method multiple times combined with remove")
    public void testPeekWithRemove() {
        sqLarge.offer("1");
        sqLarge.offer("2");
        String result1 = sqLarge.peek();
        String result2 = sqLarge.peek();

        assertEquals("1", result2,
                "Expected head to be \"1\" but was " + result2);

        assertEquals("1", result1,
                "Expected head to be \"1\" but was " + result1);

        sqLarge.remove();

        String result3 = sqLarge.peek();
        String result4 = sqLarge.peek();

        assertEquals("2", result3,
                "Expected head to be \"2\" but was " + result3);

        assertEquals("2", result4,
                "Expected head to be \"2\" but was " + result4);

        sqLarge.remove();

        String element = sqLarge.peek();
        assertNull(element, "Expected head to be null but was " + element);
    }

    @Test
    @DisplayName("Testing element method multiple times combined with remove")
    public void testElementWithRemove() {
       sqLarge.offer("1");
       sqLarge.offer("2");
       String result1 = sqLarge.element();
       String result2 = sqLarge.element();

       assertEquals("1", result2,
               "Expected head to be \"1\" but was " + result2);

       assertEquals("1", result1,
               "Expected head to be \"1\" but was " + result1);

        sqLarge.remove();

        String result3 = sqLarge.element();
        String result4 = sqLarge.element();

        assertEquals("2", result3,
                "Expected head to be \"2\" but was " + result3);

        assertEquals("2", result4,
                "Expected head to be \"2\" but was " + result4);

        sqLarge.remove();
        assertThrows(NoSuchElementException.class, () -> {
            sqLarge.element();
        });
    }
}
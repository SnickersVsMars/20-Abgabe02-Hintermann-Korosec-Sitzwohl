package at.fhj.msd.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class testing the functionalities of the StringQueue class
 *
 * @author      Christian Sitzwohl
 * @author      Marian Korošec
 * @version     %I%, %G%
 * @since       1.1
 */
@DisplayName("Testing StringQueue with string implementation")
public class StringQueueTest {
    private StringQueue sqSm, sqLg;

    /**
     * Inits two StringQueues with maxSize set to one and five
     */
    @BeforeEach
    public void setup() {
        sqSm = new StringQueue(1);
        sqLg = new StringQueue(5);
    }

    /**
     * Tests offer() via offer()-ing a String to an empty queue
     */
    @Test
    @DisplayName("Testing offer method")
    public void testOfferEmptyQueue() {
        assertTrue(sqSm.offer("Test"),
                "Expected offer to return true.");
    }

    /**
     * Tests maxSize via adding too many Strings to queue
     */
    @Test
    @DisplayName("Testing offer method with too many offers")
    public void testOfferOverflow() {
        assertTrue(sqSm.offer("SuccessfulTestString"),
                "Expected offer to return true.");
        assertFalse(sqSm.offer("OverflowTestString"),
                "Expected offer to return false due to overflow.");
    }

    /**
     * Tests poll() and its returned String via adding two Strings, then poll()-ing them
     */
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

    /**
     * Tests poll() via poll()-ing an empty queue
     */
    @Test
    @DisplayName("Testing poll method with empty queue")
    public void testPollEmptyQueue() {
        String result = sqSm.poll();

        assertNull(result, "Expected head of empty queue to be null");
    }

    /**
     * Tests remove() via adding two Strings to queue than remove()-ing them both
     */
    @Test
    @DisplayName("Testing that remove returns and removes the head of the queue")
    public void testRemoveReturnsAndRemovesHead() {
        String testString1 = "Test1";
        String testString2 = "Test2";

        sqLg.offer(testString1);
        sqLg.offer(testString2);

        String result1 = sqLg.remove();
        String result2 = sqLg.remove();

        assertEquals(testString1, result1,
                "Expected head to be \"" + testString1 + "\" but was " + result1);
        assertEquals(testString2, result2,
                "Expected head to be \"" + testString2 + "\" but was " + result2);
    }

    /**
     * Tests remove() via remove()-ing when queue is empty
     */
    @Test
    @DisplayName("Testing remove method with empty queue")
    public void testRemoveEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> {
            sqSm.remove();
        }, "Expected to throw \"NoSuchElementException\"!");
    }

    /**
     * Tests peek() via peek()-ing an empty queue
     */
    @Test
    @DisplayName("Testing peek method with empty queue")
    public void testPeekEmptyQueue() {
        String element = sqSm.peek();
        assertNull(element, "Expected head to be null but was " + element);
    }

    /**
     * Tests peek() via adding two Strings than
     * peek()-ing/remove()-ing one of them prior to comparison
     */
    @Test
    @DisplayName("Testing peek method multiple times combined with remove")
    public void testPeekWithRemove() {
        sqLg.offer("1");
        sqLg.offer("2");
        sqLg.peek(); //should have no effect
        sqLg.remove(); //remove first entry
        String result3 = sqLg.peek(); //get second entry - but should have no effect to queue
        String result4 = sqLg.peek(); //get second entry

        assertEquals("2", result3,
                "Expected head to be \"2\" but was " + result3);

        assertEquals("2", result4,
                "Expected head to be \"2\" but was " + result4);
    }

    /**
     * Tests peek() via adding two Strings than peek()-ing/remove()-ing
     * them until queue is empty
     */
    @Test
    @DisplayName("Testing peek method multiple times combined with multiple remove")
    public void testPeekWithRemoveMultiple() {
        sqLg.offer("1");
        sqLg.offer("2");
        sqLg.peek(); //should have no effect
        sqLg.remove(); //remove first entry
        sqLg.peek(); //should have no effect
        sqLg.remove(); //remove second entry

        String element = sqLg.peek();
        assertNull(element, "Expected head to be null but was " + element);
    }

    /**
     * Tests element() via adding two Strings to queue than remove()-ing
     * one of them and comparing the last one to the returned String of
     * element()
     */
    @Test
    @DisplayName("Testing element method multiple times combined with remove")
    public void testElementWithRemove() {
        sqLg.offer("1");
        sqLg.offer("2");
        sqLg.element(); //should have no effect
        sqLg.remove(); //remove first entry
        String result3 = sqLg.element(); //get second entry - but should have no effect to queue
        String result4 = sqLg.element(); //get second entry

        assertEquals("2", result3,
                "Expected head to be \"2\" but was " + result3);

        assertEquals("2", result4,
                "Expected head to be \"2\" but was " + result4);
    }

    /**
     * Tests element() via adding two Strings than element()-ing/remove()-ing
     * them until queue is empty
     */
    @Test
    @DisplayName("Testing element method multiple times combined with multiple removes")
    public void testElementWithMultipleRemove() {
        sqLg.offer("1");
        sqLg.offer("2");
        sqLg.element(); //should have no effect
        sqLg.remove(); //remove first entry
        sqLg.element(); //should have no effect
        sqLg.remove(); //remove second entry
        assertThrows(NoSuchElementException.class, () -> {
            sqLg.element(); //Queue should be empty
        }, "Expected to throw \"NoSuchElementException\"!");
    }
}
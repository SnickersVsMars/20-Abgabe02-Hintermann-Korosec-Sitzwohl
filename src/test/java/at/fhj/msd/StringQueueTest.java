package at.fhj.msd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Queue with string implementation")
public class StringQueueTest {
    private StringQueue sqSm, sqLg;

    @BeforeEach
    public void setup() {
        sqSm = new StringQueue(1);
        sqLg = new StringQueue(5);
    }

    @Test
    @DisplayName("Testing offer method")
    public void testOfferEmptyQueue() {
        assertTrue(sqSm.offer("Test"),
                "Expected offer to return true.");
    }

    @Test
    @DisplayName("Testing offer method with too many offers")
    public void testOfferOverflow() {
        assertTrue(sqSm.offer("SuccessfulTestString"),
                "Expected offer to return true.");
        assertFalse(sqSm.offer("OverflowTestString"),
                "Expected offer to return false due to overflow.");
    }

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

    @Test
    @DisplayName("Testing poll method with empty queue")
    public void testPollEmptyQueue() {
        String result = sqSm.poll();

        assertNull(result, "Expected head of empty queue to be null");
    }

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

    @Test
    @DisplayName("Testing remove method with empty queue")
    public void testRemoveEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> {
            sqSm.remove();
        }, "Expected to throw \"NoSuchElementException\"!");
    }


    @Test
    @DisplayName("Testing peek method with empty queue")
    public void testPeekEmptyQueue() {
        String element = sqSm.peek();
        assertNull(element, "Expected head to be null but was " + element);
    }

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
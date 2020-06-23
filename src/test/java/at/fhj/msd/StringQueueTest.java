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
        String result = "";
        String testString1 = "Test1";
        String testString2 = "Test2";

        sqLg.offer(testString1);
        sqLg.offer(testString2);

        result = sqLg.poll();
        assertEquals(testString1, result,
                "Expected head to be \"" + testString1 + "\" but was " + result);

        result = sqLg.poll();
        assertEquals(testString2, result,
                "Expected head to be \"" + testString2 + "\" but was " + result);
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
        String result = "";
        String testString1 = "Test1";
        String testString2 = "Test2";

        sqLg.offer(testString1);
        sqLg.offer(testString2);

        result = sqLg.remove();
        assertEquals(testString1, result,
                "Expected head to be \"" + testString1 + "\" but was " + result);

        result = sqLg.remove();
        assertEquals(testString2, result,
                "Expected head to be \"" + testString2 + "\" but was " + result);
    }

    @Test
    @DisplayName("Testing remove method with empty queue")
    public void testRemoveEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> {
            sqSm.remove();
        });
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
        String result1 = sqLg.peek();
        String result2 = sqLg.peek();

        assertEquals("1", result2,
                "Expected head to be \"1\" but was " + result2);

        assertEquals("1", result1,
                "Expected head to be \"1\" but was " + result1);

        sqLg.remove();

        String result3 = sqLg.peek();
        String result4 = sqLg.peek();

        assertEquals("2", result3,
                "Expected head to be \"2\" but was " + result3);

        assertEquals("2", result4,
                "Expected head to be \"2\" but was " + result4);

        sqLg.remove();

        String element = sqLg.peek();
        assertNull(element, "Expected head to be null but was " + element);
    }

    @Test
    @DisplayName("Testing element method multiple times combined with remove")
    public void testElementWithRemove() {
       sqLg.offer("1");
       sqLg.offer("2");
       String result1 = sqLg.element();
       String result2 = sqLg.element();

       assertEquals("1", result2,
               "Expected head to be \"1\" but was " + result2);

       assertEquals("1", result1,
               "Expected head to be \"1\" but was " + result1);

        sqLg.remove();

        String result3 = sqLg.element();
        String result4 = sqLg.element();

        assertEquals("2", result3,
                "Expected head to be \"2\" but was " + result3);

        assertEquals("2", result4,
                "Expected head to be \"2\" but was " + result4);

        sqLg.remove();
        assertThrows(NoSuchElementException.class, () -> {
            sqLg.element();
        });
    }
}
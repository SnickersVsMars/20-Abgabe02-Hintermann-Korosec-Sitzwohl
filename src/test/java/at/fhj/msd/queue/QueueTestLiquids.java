package at.fhj.msd.queue;

import at.fhj.msd.drinks.Liquid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing generic Queue with Liquids")
public class QueueTestLiquids {

    private Queue<Liquid> queue;
    private Liquid water, wine, juice;

    @BeforeEach
    void setUp() {
        queue = new Queue<Liquid>(2);

        water = new Liquid("Water", 0.3, 0);
        wine = new Liquid("Wine", 0.125, 13);
        juice = new Liquid("Juice",1,0);
    }

    @Test
    @DisplayName("Testing if maximum works properly")
    void testOfferMaximumReached() {
        queue.offer(water);
        queue.offer(wine);

        assertFalse(queue.offer(juice),
                "Expected \"false\" but element got added!");
    }

    @Test
    @DisplayName("Testing if offer()-ing works properly")
    void testOfferSimpleAdd() {
        queue.offer(water);

        assertTrue(queue.offer(water),
                "Expected \"true\" but element was not added!");
    }

    @Test
    @DisplayName("Testing if poll()-ing an element works properly")
    void testSimplePoll() {
        queue.offer(water);
        queue.offer(wine);
        queue.poll();

        assertEquals("Wine",queue.peek().getName(),
                "Expected element-name to be \"Wine\" but was:" + queue.peek().getName());
        assertEquals(0.125,queue.peek().getVolume(),
                "Expected volume to be \"0.125\" but was:" + queue.peek().getVolume());
        assertEquals(13,queue.peek().getAlcoholPercent(),
                "Expected alcohol percent to be \"13\" but was:" + queue.peek().getAlcoholPercent());
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
        queue.offer(water);
        Liquid result = queue.poll();

        assertEquals("Water", result.getName(),
                "Expected returned element-name to be \"Water\" but was:" + result.getName());
        assertEquals(0.3,result.getVolume(),
                "Expected returned volume to be \"0.3\" but was:" + result.getVolume());
        assertEquals(0,result.getAlcoholPercent(),
                "Expected returned alcohol percent to be \"0\" but was:" + result.getAlcoholPercent());
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
        queue.offer(water);
        queue.offer(juice);
        queue.remove();

        assertEquals("Juice",queue.peek().getName(),
                "Expected name to be \"Juice\" but was:" + queue.peek().getName());
        assertEquals(1,queue.peek().getVolume(),
                "Expected volume to be \"1\" but was:" + queue.peek().getVolume());
        assertEquals(0,queue.peek().getAlcoholPercent(),
                "Expected alcohol percent to be \"0\" but was:" + queue.peek().getAlcoholPercent());
    }

    @Test
    @DisplayName("Testing returned element of remove()")
    void testReturnedRemoveElement() {
        queue.offer(water);
        Liquid result = queue.remove();

        assertEquals("Water",result.getName(),
                "Expected returned element-name to be \"Water\" but was:" + result.getName());
        assertEquals(0.3,result.getVolume(),
                "Expected returned volume to be \"0.3\" but was:" + result.getVolume());
        assertEquals(0,result.getAlcoholPercent(),
                "Expected returned alcohol percent to be \"0\" but was:" + result.getAlcoholPercent());
    }

    @Test
    @DisplayName("Testing peek() with element in queue")
    void testPeekWithElement() {
        queue.offer(juice);

        assertEquals("Juice",queue.peek().getName(),
                "Expected element-name to be \"Juice\" but was:" + queue.peek().getName());
        assertEquals(1,queue.peek().getVolume(),
                "Expected volume to be \"1\" but was:" + queue.peek().getVolume());
        assertEquals(0,queue.peek().getAlcoholPercent(),
                "Expected alcohol percent to be \"0\" but was:" + queue.peek().getAlcoholPercent());
    }

    @Test
    @DisplayName("Testing peek() with no element")
    void testPeekNoElement() {
        assertNull(queue.peek(),
                "Expected to be \"null\" but was not!");
    }

    @Test
    @DisplayName("Testing element() with elements in queue")
    void testElementWithElement() {
        queue.offer(water);

        assertEquals("Water", queue.element().getName(),
                "Expected returned element-name to be \"Water\" but was:" + queue.element().getName());
        assertEquals(0.3, queue.element().getVolume(),
                "Expected returned volume to be \"0.3\" but was:" + queue.element().getVolume());
        assertEquals(0, queue.element().getAlcoholPercent(),
                "Expected returned alcohol percent to be \"0\" but was:" + queue.element().getAlcoholPercent());
    }

    @Test
    @DisplayName("Testing element() with no elements, throws NoSuchElementException")
    void testElementException() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.element();
        },"Expected to throw \"NoSuchElementException\"!");
    }
}

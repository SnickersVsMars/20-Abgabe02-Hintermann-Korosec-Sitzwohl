package at.fhj.msd.drinks;

import at.fhj.msd.drinks.exceptions.RadlerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Class testing the functionalities of the LongDrink class
 *
 * @author      Marian Korosec
 * @author      Christian Sitzwohl
 * @version     %I%, %G%
 * @since       1.1
 */
@DisplayName("Testing LongDrink implementation")
public class LongDrinkTest {
    private Liquid lA, lN, lN2, lBeer, lNBeer;

    /**
     * inits an alcoholic and nonalcoholic liquid for each test
     */
    @BeforeEach
    public void setup() {
        lN = new Liquid("Coca Cola", 0.3, 0);
        lN2 = new Liquid("Fanta", 0.3, 0);
        lA = new Liquid("Havana White Rum", 0.04, 40);
        lBeer = new Liquid("Heineken Beer", 0.5, 5.1);
        lNBeer = new Liquid("Heineken Beer 0.0%", 0.5, 0.0);
    }

    /**
     * Test valid LongDrink with 1 alcoholic and 1 non-alcoholic liquid
     */
    @Test
    @DisplayName("Testing constructor with valid long drink")
    public void testConstructorAlcoholic() {
        LongDrink longDrink = new LongDrink("Havana Cola", lA, lN);

        assertEquals("Havana Cola", longDrink.name,
                "Expected the name to be \"Havana Cola\", but was " + longDrink.name);
        assertEquals(0.34, longDrink.getVolume(), 0.001,
                "Expected a volume of .34l, but was " + longDrink.getVolume());
        assertEquals(4.705, longDrink.getAlcoholPercent(), 0.001,
                "Expected an alcohol percentage of 4.705, but was " + longDrink.getAlcoholPercent());
        assertTrue(longDrink.isAlcoholic(), "A valid long drink should be alcoholic!");

        assertDoesNotThrow(() -> {
            longDrink.validateLiquids();
        });
    }

    /**
     * Test non-valid LongDrink with 2 non-alcoholic liquids
     */
    @Test
    @DisplayName("Testing constructor with non-valid long drink")
    public void testConstructorNonAlcoholic() {
        LongDrink longDrink = new LongDrink("Spezi", lN, lN2);

        assertEquals("Spezi", longDrink.name,
                "Expected the name to be \"Spezi\", but was " + longDrink.name);
        assertEquals(0.6, longDrink.getVolume(), 0.001,
                "Expected a volume of .6l, but was " + longDrink.getVolume());
        assertEquals(0, longDrink.getAlcoholPercent(), 0.001,
                "Expected an alcohol percentage of 0.0, but was " + longDrink.getAlcoholPercent());

        assertThrows(IllegalArgumentException.class, () -> {
            longDrink.validateLiquids();
        });
    }

    /**
     * Test valid LongDrink for the special case containing beer and another alcoholic liquid
     */
    @Test
    @DisplayName("Testing constructor with special cases containing beer")
    public void testConstructorContainingBeer() {
        LongDrink longDrink = new LongDrink("U-Boot", lBeer, lA);

        assertEquals("U-Boot", longDrink.name,
                "Expected the name to be \"U-Boot\", but was " + longDrink.name);
        assertEquals(0.54, longDrink.getVolume(), 0.001,
                "Expected a volume of .54l, but was " + longDrink.getVolume());
        assertEquals(7.685, longDrink.getAlcoholPercent(), 0.001,
                "Expected an alcohol percentage of 7.685, but was " + longDrink.getAlcoholPercent());
        assertTrue(longDrink.isAlcoholic(), "A valid long drink should be alcoholic!");

        assertDoesNotThrow(() -> {
            longDrink.validateLiquids();
        });
    }

    /**
     * Test invalid LongDrink with 2 alcoholic liquids
     */
    @Test
    @DisplayName("Testing constructor with two alcoholic liquids")
    public void testConstructorDoubleAlcohol() {
        LongDrink longDrink = new LongDrink("Double Rum", lA, lA);

        assertEquals("Double Rum", longDrink.name,
                "Expected the name to be \"Double Rum\", but was " + longDrink.name);
        assertEquals(0.08, longDrink.getVolume(), 0.001,
                "Expected a volume of .08l, but was " + longDrink.getVolume());
        assertEquals(40.0, longDrink.getAlcoholPercent(), 0.001,
                "Expected an alcohol percentage of 40.0, but was " + longDrink.getAlcoholPercent());
        assertTrue(longDrink.isAlcoholic(), "A valid long drink should be alcoholic!");

        assertThrows(IllegalArgumentException.class, () -> {
            longDrink.validateLiquids();
        });
    }

    /**
     * Test invalid LongDrink that throws a RadlerException
     */
    @Test
    @DisplayName("Testing constructor for special case Radler")
    public void testConstructorRadler() {
        LongDrink longDrink = new LongDrink("Radler", lBeer, lN2);

        assertEquals("Radler", longDrink.name,
                "Expected the name to be \"Radler\", but was " + longDrink.name);
        assertEquals(0.8, longDrink.getVolume(), 0.001,
                "Expected a volume of .8l, but was " + longDrink.getVolume());
        assertEquals(3.1875, longDrink.getAlcoholPercent(), 0.001,
                "Expected an alcohol percentage of 3.1875, but was " + longDrink.getAlcoholPercent());
        assertTrue(longDrink.isAlcoholic(), "A valid long drink should be alcoholic!");

        assertThrows(RadlerException.class, () -> {
            longDrink.validateLiquids();
        });
    }

    /**
     * Test valid LongDrink that throws a llegalArgumentException,
     * because of mixing non-alcohlic beer with another non-alcoholic liquid
     */
    @Test
    @DisplayName("Testing constructor for special case non-alcoholic Radler")
    public void testConstructorNonAlcoholicRadler() {
        LongDrink longDrink = new LongDrink("non-alcoholic Radler", lNBeer, lN2);

        assertEquals("non-alcoholic Radler", longDrink.name,
                "Expected the name to be \"non-alcoholic Radler\", but was " + longDrink.name);
        assertEquals(0.8, longDrink.getVolume(), 0.001,
                "Expected a volume of .8l, but was " + longDrink.getVolume());
        assertEquals(0.0, longDrink.getAlcoholPercent(), 0.001,
                "Expected an alcohol percentage of 0.0, but was " + longDrink.getAlcoholPercent());
        assertTrue(longDrink.isAlcoholic(), "A valid long drink should be alcoholic!");

        assertThrows(IllegalArgumentException.class, () -> {
            longDrink.validateLiquids();
        });
    }
}

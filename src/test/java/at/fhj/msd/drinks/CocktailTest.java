package at.fhj.msd.drinks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class testing the functionalities of the Cocktail class
 *
 * @author      Marian Korosec
 * @author      Tobias Hintermann
 * @version     %I%, %G%
 * @since       1.1
 */
@DisplayName("Testing Cocktail implementation")
class CocktailTest {

    private ArrayList<Liquid> liquids1, liquids2;
    private Cocktail cocktail1, cocktail2;

    /**
     * inits an alcoholic liquid List for each cocktail
     * inits a cocktail for each test
     */
    @BeforeEach
    public void setup() {
        liquids1 = new ArrayList<>();
        liquids1.add(new Liquid("Rum", 0.3, 44.4));
        liquids1.add(new Liquid("Wein", 0.2, 11));
        cocktail1 = new Cocktail("Rum-Wein", liquids1);

        liquids2 = new ArrayList<>();
        liquids2.add(new Liquid("Rum", 0.3, 44.4));
        liquids2.add(new Liquid("Wein", 0.2, 11));
        liquids2.add(new Liquid("Tequilla",1,47));
        cocktail2 = new Cocktail("Rum-Wein-Tequilla", liquids2);
    }

    /**
     * Test Constructor for normal sized Cocktail 1
     */
    @Test
    @DisplayName("Testing getCocktailSize for cocktail nr. 1")
    public void testConstructorCocktail1() {
        assertEquals(0.5,cocktail1.getVolume(), 0.001,
                "Expected 0.5, but was " + cocktail1.getVolume());
        assertEquals(31.04, cocktail1.getAlcoholPercent(), 0.001,
                "Expected 31.04, but was " + cocktail1.getAlcoholPercent());
        assertTrue(cocktail1.isAlcoholic(), "Cocktail1 should be alcoholic!");
    }

    /**
     * Test Constructor for party sized Cocktail 2
     */
    @Test
    @DisplayName("Testing getCocktailSize for cocktail nr. 1")
    public void testConstructorCocktail2() {
        assertEquals(1.5,cocktail2.getVolume(), 0.001,
                "Expected 1.5, but was " + cocktail2.getVolume());
        assertEquals(41.68, cocktail2.getAlcoholPercent(), 0.001,
                "Expected 41.68, but was " + cocktail2.getAlcoholPercent());
        assertTrue(cocktail2.isAlcoholic(), "Cocktail2 should be alcoholic!");
    }

    /**
     * Test normal size Cocktail-Size 1
     */
    @Test
    @DisplayName("Testing getCocktailSize for cocktail nr. 1")
    public void testGetCocktailSize1() {
        assertEquals("NormalSize",cocktail1.getCocktailSize(),
                "Expected \"NormalSize\" but was " + cocktail1.getCocktailSize());
    }

    /**
     * Test party size Cocktail-Size 2
     */
    @Test
    @DisplayName("Testing getCocktailSize() for cocktail nr. 2")
    public void testGetCocktailSize2() {
        assertEquals("PartySize",cocktail2.getCocktailSize(),
                "Expected \"PartySize\" but was " + cocktail2.getCocktailSize());
    }

    /**
     * Test Cocktail-Size after manipulating
     */
    @Test
    @DisplayName("Testing cocktail size getter with unspecified volume")
    public void testCocktailSizeGetter1() {
        // manipulate liquid volume, so the cocktail's volume doesn't add up to match any of the sizes
        cocktail1.getLiquids().get(0).setVolume(0.5);
        cocktail2.getLiquids().get(0).setVolume(2);
        assertEquals("neither normal nor partysize", cocktail1.getCocktailSize(),
                "Expected size to be \"neither normal nor partysize\", but was "
                        + cocktail1.getCocktailSize());
        assertEquals("neither normal nor partysize", cocktail2.getCocktailSize(),
                "Expected size to be \"neither normal nor partysize\", but was "
                        + cocktail2.getCocktailSize());
    }


    /**
     * Test add liquid for normal sized Cocktail 1
     */
    @Test
    @DisplayName("Testing addLiquid() for cocktail nr. 1")
    public void testAddLiquid1() {
        cocktail1.addLiquid(new Liquid("Saft",1,0));
        ArrayList<Liquid> testList = new ArrayList<>();
        testList.add(new Liquid("Rum", 0.3, 44.4));
        testList.add(new Liquid("Wein", 0.2, 11));
        testList.add(new Liquid("Saft",1,0));
        // List assertions have issues with references => compare via for-loop
        for (int i = 0; i < cocktail1.getLiquids().size()-1; i++) {
            assertEquals(testList.get(i).getName(),
                    cocktail1.getLiquids().get(i).getName(),
                    "Expected " + testList.get(i).getName()
                            + " but was " + cocktail1.getLiquids().get(i).getName());
            assertEquals(testList.get(i).getVolume(),
                    cocktail1.getLiquids().get(i).getVolume(), 0.001,
                    "Expected " + testList.get(i).getVolume()
                            + " but was " + cocktail1.getLiquids().get(i).getVolume());
            assertEquals(testList.get(i).getAlcoholPercent(),
                    cocktail1.getLiquids().get(i).getAlcoholPercent(), 0.001,
                    "Expected " + testList.get(i).getAlcoholPercent()
                            + " but was " + cocktail1.getLiquids().get(i).getAlcoholPercent());
        }
    }

    /**
     * Test add liquid to party sized Cocktail 2
     */
    @Test
    @DisplayName("Testing addLiquid() for cocktail nr. 2")
    public void testAddLiquid2() {
        cocktail2.addLiquid(new Liquid("Jogurt",1,0));
        ArrayList<Liquid> testList = new ArrayList<>();
        testList.add(new Liquid("Rum", 0.3, 44.4));
        testList.add(new Liquid("Wein", 0.2, 11));
        testList.add(new Liquid("Tequilla",1,47));
        testList.add(new Liquid("Jogurt",1,0));
        for (int i = 0; i < cocktail2.getLiquids().size()-1; i++) {
            assertEquals(testList.get(i).getName(),
                    cocktail2.getLiquids().get(i).getName(),
                    "Expected " + testList.get(i).getName()
                            + " but was " + cocktail2.getLiquids().get(i).getName());
            assertEquals(testList.get(i).getVolume(),
                    cocktail2.getLiquids().get(i).getVolume(), 0.001,
                    "Expected " + testList.get(i).getVolume()
                            + " but was " + cocktail2.getLiquids().get(i).getVolume());
            assertEquals(testList.get(i).getAlcoholPercent(),
                    cocktail2.getLiquids().get(i).getAlcoholPercent(), 0.001,
                    "Expected " + testList.get(i).getAlcoholPercent()
                            + " but was " + cocktail2.getLiquids().get(i).getAlcoholPercent());
        }
    }

}
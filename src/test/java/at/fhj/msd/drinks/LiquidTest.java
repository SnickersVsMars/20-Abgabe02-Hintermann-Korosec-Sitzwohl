package at.fhj.msd.drinks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class testing the functionalities of the Liquid class
 *
 * @author      Marian Korosec
 * @author      Michael Ulm
 * @version     %I%, %G%
 * @since       1.0
 */
@DisplayName("Testing Liquid implementation")
public class LiquidTest {
	private Liquid lN, lA;

	/**
	 * inits an alcoholic and nonalcoholic liquid for EACH test
	 */
	@BeforeEach
	void setup() {
		// SETUP PHASE
		lN = new Liquid("Water", 0.3, 0);
		lA = new Liquid("Wine", 0.125, 13);
	}

	/**
	 * Test constructor of an non-alcoholic liquid
	 */
	@Test
	@DisplayName("Testing constructor non alcoholic")
	public void testConstructorNonAlcoholic(){
		assertEquals("Water", lN.getName(),
				"Expected the name to be \"Water\", but was " + lN.getName());
		assertEquals(0.3, lN.getVolume(), 0.001,
				"Expected a volume of .3l, but was " + lN.getVolume());
		assertEquals(0, lN.getAlcoholPercent(), 0.001,
				"Expected an alcohol percentage of 0, but was " + lN.getAlcoholPercent());
	}

	/**
	 * Test constructor of an alcoholic liquid
	 */
	@Test
	@DisplayName("Testing constructor alcoholic")
	public void testConstructorAlcoholic(){
		assertEquals("Wine", lA.getName(),
				"Expected the name to be \"Wine\", but was " + lA.getName());
		assertEquals(0.125, lA.getVolume(), 0.001,
				"Expected a volume of .125l, but was " + lA.getVolume());
		assertEquals(13, lA.getAlcoholPercent(), 0.001,
				"Expected an alcohol percentage of 13, but was " + lA.getAlcoholPercent());
	}

	/**
	 * Test name setter of a liquid
	 */
	@Test
	@DisplayName("Test name setter")
	public void testNameSetter(){
		lN.setName("Granderwasser");
		assertEquals("Granderwasser", lN.getName(),
				"Expected the name to be \"Granderwasser\", but was " + lN.getName());
	}

	/**
	 * Test volume setter of a liquid
	 */
	@Test
	@DisplayName("Testing volume setter")
	public void testVolumeSetter(){
		lN.setVolume(0.5);
		assertEquals(0.5, lN.getVolume(), 0.001,
				"Expected a volume of .5l, but was " + lN.getVolume());
	}

	/**
	 * Test alcoholPercent setter of a liquid
	 */
	@Test
	@DisplayName("Testing alcoholPercent setters")
	public void testAlcoholPercentSetter(){
		lN.setAlcoholPercent(3.2);
		assertEquals(3.2, lN.getAlcoholPercent(), 0.001,
				"Expected an alcohol percentage of 3.2, but was " + lN.getAlcoholPercent());
	}
}

package at.fhj.msd.drinks;

import at.fhj.msd.drinks.exceptions.RadlerException;

/**
 * Class represents a long drink containing two different
 * liquids - one alcoholic and one non-alcoholic
 *
 * @author      Marian Korosec
 * @author      Christian Sitzwohl
 * @version     %I%, %G%
 * @since       1.1
 */
public class LongDrink extends Drink {

    /**
     * alcoholic liquid of the long drink
     */
    private Liquid alcohol;
    /**
     * non-alcoholic liquid of the long drink
     */
    private Liquid nonAlcohol;

    /**
     * Creates a new LongDrink object consisting of the given
     * name and two content liquids
     *
     * @param name name of the drink
     * @param alcohol alcoholic component of the long drink
     * @param nonAlcohol non-alcoholic component of the long drink
     */
    LongDrink(String name, Liquid alcohol, Liquid nonAlcohol) {
        super(name);
        this.alcohol = alcohol;
        this.nonAlcohol = nonAlcohol;
    }

    /**
     * Checks if the conditions for a long drink are fulfilled
     *
     * @throws IllegalArgumentException    If any of the inputs are
     *                                      invalid (e.g. 2 alcoholic)
     * @throws  RadlerException             If beer is mixed with a
     *                                      non-alcoholic drink
     */
    public void validateLiquids()
    throws IllegalArgumentException, RadlerException {

        // Special case for beer: Beer can't be mixed with a non-alcoholic drink, but mixing
        // beer with another alcoholic drink is allowed
        if (alcohol.getName().toLowerCase().contains("bier")
                || alcohol.getName().toLowerCase().contains("beer"))
        {
            if (alcohol.getAlcoholPercent() <= 0.0)
            {
                throw new IllegalArgumentException(
                        "Why the hell are you trying to use a non-alcoholic beer for a long drink?"
                );
            }

            if (nonAlcohol.getAlcoholPercent() <= 0.0)
            {
                throw new RadlerException("Radler ist kein Alkohol!");
            }
        }
        else
        {
            if (alcohol.getAlcoholPercent() <= 0.0)
            {
                throw new IllegalArgumentException("The alcoholic liquid must contain alcohol!");
            }

            if (nonAlcohol.getAlcoholPercent() > 0.0)
            {
                throw new IllegalArgumentException("The non-alcoholic liquid must be non-alcoholic!");
            }
        }

    }

    // JavaDoc from abstract method will be used here
    @Override
    public double getVolume() {
        return alcohol.getVolume() + nonAlcohol.getVolume();
    }

    // JavaDoc from abstract method will be used here
    @Override
    public double getAlcoholPercent() {
        double totalVolume = alcohol.getVolume() + nonAlcohol.getVolume();
        double alcoholVal = alcohol.getAlcoholPercent() * alcohol.getVolume();
        double nonAlcoholVal = nonAlcohol.getAlcoholPercent() * nonAlcohol.getVolume();
        return (alcoholVal + nonAlcoholVal) / totalVolume;
    }

    // JavaDoc from abstract method will be used here
    // a correct long drink should always return true
    @Override
    public boolean isAlcoholic() {
        return true;
    }
}

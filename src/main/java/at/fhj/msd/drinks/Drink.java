package at.fhj.msd.drinks;

/**
 * Abstract base class for concrete drink classes
 *
 * @author      Michael Ulm
 * @version     %I%, %G%
 * @since       1.0
 */
public abstract class Drink {

    /**
     * name of the drink
     */
    protected String name;

    /**
     * Creates a Drink object with the given name
     *
     * @param name name of the drink
     *
     */
    public Drink(String name) {
        this.name = name;
    }

    /**
     * Calculates and returns the volume of the drink
     *
     * @return the volume of drink in liter
     */
    public abstract double getVolume();

    /**
     * Calculates and returns the alcohol percentage
     *
     * @return alcohol volume in percent (e.g. 50)
     */
    public abstract double getAlcoholPercent();

    /**
     * Returns whether drink is alcoholic or not
     *
     * @return true if alcoholic liquids are present, otherwise false
     */
    public abstract boolean isAlcoholic();
}

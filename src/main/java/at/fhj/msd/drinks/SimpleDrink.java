package at.fhj.msd.drinks;

/**
 * Class represents a simple drink liquid which can be used in
 * drinks
 *
 * @author      Michael Ulm
 * @version     %I%, %G%
 * @since       1.0
 */
public class SimpleDrink extends Drink {

    /**
     * uses only one liquid
     */
    protected Liquid l;

    /**
     * Creates a SimpleDrink object with the given name and
     * liquid
     *
     * @param name name of drink
     * @param l only liquid in drink
     */
    public SimpleDrink(String name, Liquid l){
        super(name);
        this.l = l;
    }

    /**
     * Returns the volume of the liquid l
     *
     * @return the volume of the drink in liter
     */
    @Override
    public double getVolume() {
        return l.getVolume();
    }

    /**
     * Returns the alcohol volume in percent of the liquid l
     *
     * @return alcohol volume in percent
     */
    @Override
    public double getAlcoholPercent() {
        return l.getAlcoholPercent();
    }

    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        if(l.getAlcoholPercent() > 0){
            return true;
        }
        return false;
    }
}

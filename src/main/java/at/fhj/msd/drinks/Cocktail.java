package at.fhj.msd.drinks;

import java.util.ArrayList;

/**
 * Class represents a mixture of liquids resembling a cocktail.
 * Cocktails are limited by volume, depending of the type of cocktail.
 *
 * @author      Tobias Hintermann
 * @author      Marian Korosec
 * @version     %I%, %G%
 * @since       1.1
 */
public class Cocktail extends Drink {

    /**
     * list of liquids contained in the cocktail
     */
    private ArrayList<Liquid> liquids;


    /**
     * Creates a new Cocktail object consisting of the given
     * name and list of liquids
     *
     * @param name name of the drink
     * @param liquids list of liquids in the cocktail
     */
    public Cocktail(String name, ArrayList<Liquid> liquids) {
        super(name);
        this.liquids = liquids;
    }

    /**
     * Checks the cocktail's overall volume and returns
     * the size it matched
     *
     * normal size = 0.5l
     * party size = 1.5l
     *
     * @return String that defines the size of the cocktail
     */
    public String getCocktailSize() {
        if (getVolume() == 0.5) {
            return "NormalSize";
        } else if(getVolume() == 1.5) {
            return "PartySize";
        }
        return "neither normal nor partysize";
    }

    /**
     * Adds a liquid to the cocktail
     *
     * @param l liquid to be added to the cocktail
     */
    public void addLiquid(Liquid l) { liquids.add(l); }

    /**
     * Returns the list of liquids in the cocktail
     *
     * @return the liquids ArrayList
     */
    public ArrayList<Liquid> getLiquids() { return liquids; }

    // JavaDoc from abstract method will be used here
    @Override
    public double getVolume() {
        double volume = 0;
        for (Liquid l: liquids) {
           volume += l.getVolume();
        }
        return volume;
    }

    // JavaDoc from abstract method will be used here
    @Override
    public double getAlcoholPercent() {
        double alcoholPercentage = 0.0;
        for (Liquid l: liquids) {
            alcoholPercentage += l.getVolume() * l.getAlcoholPercent();
        }
        // rounds the percentage to 2 decimals and returns it
        return Math.round((alcoholPercentage / getVolume()) * 100.0) / 100.0;
    }

    // JavaDoc from abstract method will be used here
    @Override
    public boolean isAlcoholic() {
        return getAlcoholPercent() > 0 ? true : false;
    }
}

package at.fhj.msd.drinks.exceptions;

/**
 * Exception that is used when Beer is mixed with a non-alcoholic
 * drink
 *
 *  @author      Marian Korošec
 *  @version     %I%, %G%
 *  @since       1.1
 */
public class RadlerException extends Exception {

    /**
     * Creates a new instance of the RadlerException, containing
     * the given error message
     *
     * @param errorMessage message of the exception
     */
    public RadlerException(String errorMessage) {
        super(errorMessage);
    }
}

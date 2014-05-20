
package es.unileon.springapp.domain;


public class InvalidBuyableException extends Exception {
    public InvalidBuyableException(String parameter, String comparison, double value) {
        super(parameter + " must be " + comparison + " than " + value);
    }
}

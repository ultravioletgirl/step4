
package es.unileon.springapp.domain;


public class InvalidBuyableException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public InvalidBuyableException(String parameter, String comparison, double value) {
        super(parameter + " must be " + comparison + " than " + value);
    }
}

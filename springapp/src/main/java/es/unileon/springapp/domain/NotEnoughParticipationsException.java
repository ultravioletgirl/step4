
package es.unileon.springapp.domain;


public class NotEnoughParticipationsException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotEnoughParticipationsException() {
		super("There are not enough participations available.");
	}
}

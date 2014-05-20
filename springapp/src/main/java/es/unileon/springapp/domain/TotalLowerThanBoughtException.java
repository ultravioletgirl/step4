package es.unileon.springapp.domain;

public class TotalLowerThanBoughtException extends Exception {

	private static final long serialVersionUID = 1L;

	public TotalLowerThanBoughtException() {
		super(
				"Total of participations cannot be lower than bought participations.");
	}
}

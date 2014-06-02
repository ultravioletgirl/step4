package es.unileon.springapp.domain.fee;

/**
 * Simple fee that applies a minimum plus a percentage of the given amount.
 * @author roobre
 */
public class LinearFee implements FeeStrategy {

    /**
     * Fee to be applied as amount multiplicator, THUS ONE (a 2% fee is storead
     * as 0.02).
     */
    private double fee;

    /**
     * Minimum value which is always paid.
     */
    private double minimum;

    public LinearFee(){
    	
    }


	public LinearFee(double fee, double minimum) throws InvalidFeeException {
        if (fee < 0 || minimum < 0) {
            throw new InvalidFeeException();
        }
        
        this.fee = fee;
        this.minimum = minimum;
    }

    public double getFee(double value) {
        double total=this.fee * value;
        if(total <this.minimum) {
            total = this.minimum;
        }
        
        return total;
    
    }

    public double getFee() {
		return fee;
	}

	public double getMinimum() {
		return minimum;
	}
	
	public void setFee(double fee) {
			this.fee= fee;
		}

	public void setMinimum(double minimum) {
			this.minimum= minimum;
	}
	
	public String toString(){
		return this.fee +"/"+this.minimum;
	}
}

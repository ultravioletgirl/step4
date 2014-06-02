package es.unileon.springapp.domain;

import es.unileon.springapp.domain.Pack;
import es.unileon.springapp.domain.fee.FeeStrategy;
import es.unileon.springapp.domain.handler.*;;


public abstract class Buyable {

    protected Handler id;
    
	protected int amount;
    protected int purchasedAmount;
    protected double totalPrice;

    protected  FeeStrategy fee, cancellationFee;
    
    public FeeStrategy getFee() {
		return fee;
	}
	public void setFee(FeeStrategy fee) {
		this.fee = fee;
	}
	public FeeStrategy getCancellationFee() {
		return cancellationFee;
	}
	public void setCancellationFee(FeeStrategy cancellationFee) {
		this.cancellationFee = cancellationFee;
	}
	public Buyable(){
    	
    }
    public Buyable(Handler id, int amount, double totalPrice,  FeeStrategy fee, FeeStrategy cancellationFee) throws InvalidBuyableException {
        if (totalPrice < 0) {
            throw new InvalidBuyableException("Price", "greater", 0);
        }

        if (amount < 0) {
            throw new InvalidBuyableException("Participations", "greater", 0);
        }

        this.id = id;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.purchasedAmount = 0;
        this.fee = fee;
        this.cancellationFee = cancellationFee;
        
    }
    public Handler getId() {
		return id;
	}

	public void setId(Handler id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPurchasedAmount() {
		return purchasedAmount;
	}

	public void setPurchasedAmount(int purchasedAmount) {
		this.purchasedAmount = purchasedAmount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


   

    public double getPPP() {
        return this.totalPrice / this.amount;
    }

    /*public void setPPP(double ppp, int participations) {
        this.totalPrice = ppp * participations;
    }

    public void setPPP(double ppp, double totalPrice) throws InvalidNumberOfParticipationsException, TotalLowerThanBoughtException {
        if (totalPrice % ppp != 0) {
            throw new InvalidNumberOfParticipationsException(totalPrice, ppp);
        } else if ((int) (totalPrice / ppp) < this.purchasedAmount) {
            throw new TotalLowerThanBoughtException();
        }
        this.amount = (int) (totalPrice / ppp);
    }*/

    /**
     * @return the fundID
     */
   /* public Handler getId() {
        return id;
    }
*/
    /**
     * @return the participations
     */
    
    public int getParticipations() {
        return amount;
    }

    /**
     * @return the totalPrice
     */
    public double getPrice() {
        return totalPrice;
    }

    public int getBuyableParticipations() {
        return this.amount - this.purchasedAmount;
    }

    public abstract Pack buy(int amount) throws NotEnoughParticipationsException;
}

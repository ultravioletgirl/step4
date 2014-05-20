package es.unileon.springapp.domain;

import java.io.Serializable;

import es.unileon.springapp.domain.Buyable;
import es.unileon.springapp.domain.InvalidBuyableException;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.domain.TotalLowerThanBoughtException;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.fee.FeeStrategy;
import es.unileon.springapp.domain.fee.LinearFee;
import es.unileon.springapp.domain.handler.Handler;

public class InvestmentFund extends Buyable implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private double profitability;
    private FeeStrategy fee, cancellationFee;



	public InvestmentFund(){
    	super();
    }
    
    public InvestmentFund(Handler id, int amount, double totalPrice, LinearFee fee, LinearFee cancellationFee, double profitability) throws InvalidBuyableException {
        super(id, amount, totalPrice);


        if (profitability < 1) {
            throw new InvalidBuyableException("Profitability", "greater", 1);
        }

        this.fee = fee;
        this.cancellationFee = cancellationFee;
        this.profitability = profitability;
    }

    public int getParticipations(){
    	return this.amount;
    }

    public int getPurchasedAmount(){
    	return this.purchasedAmount;
    }
    /**
     * @param participations the participations to set
     * @throws es.unileon.ulebank.brokerage.buyable.TotalLowerThanBoughtException
     */
    public void setParticipations(int participations) throws TotalLowerThanBoughtException {
        if (participations < this.purchasedAmount) {
            throw new TotalLowerThanBoughtException();
        }

        this.amount = participations;
    }

    /**
     * @return the fee
     */
    public FeeStrategy getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(LinearFee fee) {
        this.fee = fee;
    }

    public FeeStrategy getCancellationFee() {
		return cancellationFee;
	}

	public void setCancellationFee(FeeStrategy cancellationFee) {
		this.cancellationFee = cancellationFee;
	}
	
    /**
     * @return the profitability
     */
    public double getProfitability() {
        return profitability;
    }

    /**
     * @param profitability the profitability to set
     */
    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    @Override
    public InvestmentFundPack buy(int amount) throws NotEnoughParticipationsException {
        if (amount > (this.amount - this.purchasedAmount)) {
            throw new NotEnoughParticipationsException();
        }

        this.purchasedAmount += amount;
        //this.purchasedAmount -= amount;

        return new InvestmentFundPack(this, amount);
    }

	
}

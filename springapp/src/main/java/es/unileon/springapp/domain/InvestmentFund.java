package es.unileon.springapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import es.unileon.springapp.domain.Buyable;
import es.unileon.springapp.domain.InvalidBuyableException;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.domain.TotalLowerThanBoughtException;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.fee.FeeStrategy;
import es.unileon.springapp.domain.fee.LinearFee;
import es.unileon.springapp.domain.handler.FundsHandler;
import es.unileon.springapp.domain.handler.Handler;

@Entity
@Table(name="investmentfund") 
public class InvestmentFund extends Buyable implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDB;
	
	public int getIdDB() {
		return idDB;
	}


	public void setIdDB(int idDB) {
		this.idDB = idDB;
	}

	@Column(name = "idInvestmentFund")
	private String idInvestmentFund;

	@Column(name = "IF_Amount" ,nullable=false)
	private Integer amountDB;
	
	@Column(name = "IF_TotalPrice" ,nullable=false)
	private double totalPriceDB;
	
	@Column(name = "IF_fee" ,nullable=false)
	private String feeDB;
	
	@Column(name = "IF_cancellationFee" ,nullable=false)
	private String feeCancelDB;
	
	@Column(name = "IF_profitability" ,nullable=false)
	private double profitability;

	@Column(name = "IF_PurchasedAmount" ,nullable=false)
	private Integer purchaseAmount;
	


	public InvestmentFund(){
    	super();
    }
    

    public InvestmentFund(Handler id, int amount, double totalPrice, LinearFee fee, LinearFee cancellationFee, double profitability) throws InvalidBuyableException {
        super(id, amount, totalPrice, fee, cancellationFee);


        if (profitability < 1) {
            throw new InvalidBuyableException("Profitability", "greater", 1);
        }

        this.fee = fee;
        this.cancellationFee = cancellationFee;
        this.profitability = profitability;
    }

    public String getidInvestmentFund() {
		return idInvestmentFund;
	}

	public void setIdInvestmentFund(String idInvestmentFund) {
		this.idInvestmentFund = idInvestmentFund;
	}

	public Integer getAmountDB() {
		return amountDB;
	}

	public void setAmountDB(Integer amountDB) {
		this.amountDB = amountDB;
	}

	public double getTotalPriceDB() {
		return totalPriceDB;
	}

	public void setTotalPriceDB(double totalPriceDB) {
		this.totalPriceDB = totalPriceDB;
	}

	public String getFeeDB() {
		return feeDB;
	}

	public void setFeeDB(String feeDB) {
		this.feeDB = feeDB;
	}

	public String getFeeCancelDB() {
		return feeCancelDB;
	}

	public void setFeeCancelDB(String feeCancelDB) {
		this.feeCancelDB = feeCancelDB;
	}

	public Integer getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(Integer purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    public int getParticipations(){
    	return this.amount;
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

        return new InvestmentFundPack(this, amount);
    }

    public void stringToHandler(){
    	String[] dataFund = this.idInvestmentFund.split("/");
		FundsHandler handler = new FundsHandler();
        for (int i = 0; i < dataFund.length; i++) {
	        	switch(i) {
	        	 case 0: 
	        	     handler.setFundName(dataFund[0]);
	        	     break;
	        	 case 1: 
	        	     handler.setFundManager(dataFund[1]);
	        	     break;
	        	 case 2: 
	        	     handler.setFundType(dataFund[2]);
	        	     break;
	        	 case 3: 
	        		 Integer share = Integer.parseInt(dataFund[3]);
	        	     handler.setFundShare(share);
	        	     break;
	        	 case 4: 
	        	     handler.setStockMarket(dataFund[4]);
	        	     break;
	        	}
        	
        }
        this.id = handler;
    }
	
    public void stringToFee(){
    	String[] dataFund = this.feeDB.split("/");
		LinearFee fee = new LinearFee();
        for (int i = 0; i < dataFund.length; i++) {
        	switch(i) {
		       	 case 0: 
		       	     fee.setFee(Double.parseDouble(dataFund[i]));
		       	     break;
		       	 case 1: 
		       	     fee.setMinimum(Double.parseDouble(dataFund[i]));
		       	     break;
        	}
        }
        this.setFee(fee);
    }
    
    public void stringToFeeCancel(){
    	String[] dataFund = this.feeCancelDB.split("/");
		LinearFee fee = new LinearFee();
        for (int i = 0; i < dataFund.length; i++) {
        	switch(i) {
		       	 case 0: 
		       	     fee.setFee(Double.parseDouble(dataFund[0]));
		       	     break;
		       	 case 1: 
		       	     fee.setMinimum(Double.parseDouble(dataFund[0]));
		       	     break;
        	}
        }
        this.setCancellationFee(fee);

    }
}

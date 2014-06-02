package es.unileon.springapp.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import es.unileon.springapp.domain.fee.LinearFee;
import es.unileon.springapp.domain.handler.FundsHandler;

@Entity
@Table(name="investmentfundpack") 
public class InvestmentFundPack extends Pack {

	private static final long serialVersionUID = 1L;


	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String idInvestmentFundPack;
	
	//private String idClient;
	
	private Integer amountDB;
	
	@ManyToOne
    @JoinColumn(name="idClient", insertable=false, updatable=false)
	private Client client;
	
    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getIdInvestmentFundPack() {
		return idInvestmentFundPack;
	}

	public void setIdInvestmentFundPack(String idInvestmentFundPack) {
		this.idInvestmentFundPack = idInvestmentFundPack;
	}	

	public Integer getAmountDB() {
		return amountDB;
	}

	public void setAmountDB(Integer amount) {
		this.amountDB = amount;
	}

	/*public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}*/

	public InvestmentFundPack(){
		
	}
		
    public InvestmentFundPack(InvestmentFund product, Integer amount) {
        super(product, amount);

    	investmentToString(product);
    }
    
    
    public void investmentToString(InvestmentFund fundP){
    	InvestmentFund fund = fundP;
    	String fin = ""+fund.getId().toString()+"/ /"+fund.getAmount()+"/ /"+fund.getTotalPrice()+"/ /"+fund.getFeeDB()+"/ /"
    				   +fund.getFeeCancelDB()+"/ /"+fund.getProfitability()+"/ /"+fund.getPurchaseAmount();
  
    	this.idInvestmentFundPack = fin;
    	//setIdInvestmentFundPack (fin);
        
    }
    
    public void stringToBuyable(){
    	InvestmentFund fund = new InvestmentFund();
    	FundsHandler handler = new FundsHandler();
    	String[] dataFund = this.idInvestmentFundPack.split("/");
		LinearFee fee = new LinearFee();
		LinearFee cancelFee = new LinearFee();

        for (int i = 0; i < dataFund.length; i++) {
        	System.out.println(i);
        	switch(i) {
		       	 case 0: 
		       	     handler.setFundName(dataFund[i]);
		       	     break;
		       	 case 1: 
		       	     handler.setFundManager(dataFund[i]);
		       	     break;
		       	 case 2: 
		       	     handler.setFundType(dataFund[i]);
		       	     break;
		       	 case 3: 
		       	     handler.setFundShare(Integer.parseInt(dataFund[i]));
		       	     break;
		       	 case 4: 
		       	     handler.setStockMarket(dataFund[i]);
		       	     break;
		       	 case 5: 
		       	     break;
		       	 case 6: 
		       	     fund.setAmount(Integer.parseInt(dataFund[i]));
		       	     break;
		       	 case 7:
		       		 break;
		       	 case 8:
		       		 fund.setTotalPrice(Double.parseDouble(dataFund[i]));
		       	 case 9:
		       	     break;
		       	 case 10:
		       		 fee.setFee(Double.parseDouble(dataFund[i]));
		       		 break;
		       	 case 11:
		       		 fee.setMinimum(Double.parseDouble(dataFund[i]));
		       		 break;
		       	 case 12:
		       	     break;
		       	 case 13:
		       		 cancelFee.setFee(Double.parseDouble(dataFund[i]));
		       		 break;
		       	 case 14:
		       		 cancelFee.setMinimum(Double.parseDouble(dataFund[i]));
		       		 break;
		       	 case 15:
		       	     break;
		       	 case 16:
		       		 fund.setProfitability(Double.parseDouble(dataFund[i]));
		       		 break;
		       	 case 17:
		       	     break;
		       	 case 18:
		       		fund.setPurchaseAmount(Integer.parseInt(dataFund[i]));
		       		break;
        	}
        }
        fund.setId(handler);
        fund.setFee(cancelFee);
        fund.setCancellationFee(cancelFee);
        this.setProduct(fund);
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

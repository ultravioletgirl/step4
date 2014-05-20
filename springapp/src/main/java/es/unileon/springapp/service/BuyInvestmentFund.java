package es.unileon.springapp.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 


public class BuyInvestmentFund {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    
    private int packs;
    //private InvestmentFund fund;
    private String fundName;
  

    /*public InvestmentFund getFund() {
		return fund;
	}

	public void setFund(InvestmentFund fund) {
		this.fund = fund;
	}*/

	public void setPacks(int i) {
        packs = i;
        logger.info("Buy Packs: "+i);
    }

    public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public int getPacks() {
        return packs;
    }



	


}

package es.unileon.springapp.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.domain.handler.Handler;

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

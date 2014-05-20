package es.unileon.springapp.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;

public class BuyInvestmentFund implements ClientManager{
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    
    private int packs;
    private InvestmentFund fund;
    
    

    public InvestmentFund getFund() {
		return fund;
	}

	public void setFund(InvestmentFund fund) {
		this.fund = fund;
	}

	public void setPacks(int i) {
        packs = i;
        logger.info("Buy Packs: "+i);
    }

    public int getPacks() {
        return packs;
    }

	public InvestmentFundPack buyFundPack(InvestmentFund fund, int amount) throws NotEnoughParticipationsException{
		InvestmentFundPack fundPack = fund.buy(amount);
		return fundPack;
	}

	public List<InvestmentFundPack> getInvestmentFunds() {
		// TODO Auto-generated method stub
		return null;
	}

}

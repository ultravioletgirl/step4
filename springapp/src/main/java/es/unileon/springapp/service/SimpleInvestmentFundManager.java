package es.unileon.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.domain.handler.FundsHandler;

public class SimpleInvestmentFundManager implements InvestmentFundManager{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private ClientManager client;
    
	public void setClient(ClientManager client) {
		this.client = client;
	}

	private List<InvestmentFund> funds;

	
	/*public InvestmentFundPack buyFundPack(InvestmentFund fund, int amount) throws NotEnoughParticipationsException {
		InvestmentFundPack fundPack = fund.buy(amount);
		return fundPack;
	}*/

	public List<InvestmentFund> getInvestmentFunds() {
		return funds;
	}
	
	public void setInvestmentFunds(List<InvestmentFund> fund) {
		this.funds = fund;
	}

	public void buyPack(String id, int amount) throws NotEnoughParticipationsException{
		for(InvestmentFund investment :funds ){
			FundsHandler han = (FundsHandler) investment.getId();

			if(han.getFundName().equals(id)){

				if (amount > (investment.getAmount() - investment.getPurchasedAmount())) {
		            throw new NotEnoughParticipationsException();
		        }
				InvestmentFundPack newPack = new InvestmentFundPack(investment, amount);
		        investment.setPurchasedAmount(investment.getPurchasedAmount() + amount);
				client.addFund(newPack);
			}
		}
	}


}

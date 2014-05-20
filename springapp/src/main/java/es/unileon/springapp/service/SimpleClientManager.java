package es.unileon.springapp.service;

import java.util.List;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;

public class SimpleClientManager implements ClientManager {

	private List<InvestmentFundPack> funds;

	public List<InvestmentFundPack> getFunds() {
		return funds;
	}

	public void setFunds(List<InvestmentFundPack> funds) {
		this.funds = funds;
	}

	public InvestmentFundPack buyFundPack(InvestmentFund fund, int amount) throws NotEnoughParticipationsException{
		InvestmentFundPack fundPack = fund.buy(amount);
		return fundPack;
	}

	public List<InvestmentFundPack> getInvestmentFunds() {
		return funds;

	}
	
	

}

package es.unileon.springapp.service;

import java.util.List;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;

public class SimpleInvestmentFundManager implements InvestmentFundManager{

	private List<InvestmentFund> funds;

	
	public InvestmentFundPack buyFundPack(InvestmentFund fund, int amount) throws NotEnoughParticipationsException {
		InvestmentFundPack fundPack = fund.buy(amount);
		return fundPack;
	}

	public List<InvestmentFund> getInvestmentFunds() {
		return funds;
	}
	
	public void setInvestmentFunds(List<InvestmentFund> fund) {
		this.funds = fund;
	}




}

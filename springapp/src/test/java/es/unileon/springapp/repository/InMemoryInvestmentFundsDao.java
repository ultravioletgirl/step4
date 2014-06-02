package es.unileon.springapp.repository;

import java.util.List;

import es.unileon.springapp.domain.InvestmentFund;

public class InMemoryInvestmentFundsDao implements InvestmentFundDao {

	private List<InvestmentFund> investmentFundList;
	
	public InMemoryInvestmentFundsDao ( List<InvestmentFund> investmentFunds){
		this.investmentFundList = investmentFunds;
	}
	
	public List<InvestmentFund> getInvestmentFundList() {
		return this.investmentFundList;
	}

	public void saveInvestmentFund(InvestmentFund InvestmentFund) {		
	}

}

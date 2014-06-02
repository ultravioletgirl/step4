package es.unileon.springapp.repository;

import java.util.List;

import es.unileon.springapp.domain.InvestmentFundPack;

public class InMemoryInvestmentFundsPackDao implements InvestmentFundPackDao{


	private List<InvestmentFundPack> investmentFundPackList;
	
	public InMemoryInvestmentFundsPackDao ( List<InvestmentFundPack> investmentFundsPack){
		this.investmentFundPackList = investmentFundsPack;
	}
	
	public List<InvestmentFundPack> getInvestmentFundList() {
		return this.investmentFundPackList;
	}

	public void saveInvestmentFund(InvestmentFundPack InvestmentFundPack) {
		
	}

	public List<InvestmentFundPack> getInvestmentFundListWithID(String id) {
		
		return null;
	}

    
}

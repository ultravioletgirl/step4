package es.unileon.springapp.repository;

import java.util.List;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;

public interface InvestmentFundPackDao {

	public List<InvestmentFundPack> getInvestmentFundList();
    public void saveInvestmentFund(InvestmentFundPack InvestmentFundPack);
	//public InvestmentFundPack create(InvestmentFund investmentFund, int amount);
    public List<InvestmentFundPack> getInvestmentFundListWithID(String id);
}

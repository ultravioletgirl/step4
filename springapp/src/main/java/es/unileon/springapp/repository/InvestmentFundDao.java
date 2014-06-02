package es.unileon.springapp.repository;

import java.util.List;
import es.unileon.springapp.domain.InvestmentFund;


public interface InvestmentFundDao {
	
	public List<InvestmentFund> getInvestmentFundList();
    public void saveInvestmentFund(InvestmentFund InvestmentFund);

}

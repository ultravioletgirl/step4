package es.unileon.springapp.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.repository.InvestmentFundDao;
import es.unileon.springapp.repository.InvestmentFundPackDao;

public interface InvestmentFundManager extends Serializable {

    //public InvestmentFundPack buyFundPack(InvestmentFund fund,int amount) throws NotEnoughParticipationsException ;
    
	public void setInvestmentFundDao(InvestmentFundDao investmentFundDao);
	
	public void setInvestmentFundPackDao(InvestmentFundPackDao investmentFundPackDao);
	
	List<InvestmentFund> getInvestmentFunds();

	public void buyPack(String id, int amount, String idClient) throws NotEnoughParticipationsException;


}

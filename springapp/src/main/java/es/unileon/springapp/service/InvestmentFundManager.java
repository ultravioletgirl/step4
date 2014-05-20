package es.unileon.springapp.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;

public interface InvestmentFundManager extends Serializable {

    public InvestmentFundPack buyFundPack(InvestmentFund fund,int amount) throws NotEnoughParticipationsException ;
    
    public List<InvestmentFund> getInvestmentFunds();
    
    public void setInvestmentFunds(List<InvestmentFund> fund);

}
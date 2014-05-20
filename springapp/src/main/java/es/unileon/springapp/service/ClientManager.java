package es.unileon.springapp.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.springapp.domain.InvestmentFundPack;

public interface ClientManager extends Serializable {

    
    public List<InvestmentFundPack> getInvestmentFunds();

    public void addFund(InvestmentFundPack pack);

}

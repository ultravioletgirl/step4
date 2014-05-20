package es.unileon.springapp.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.domain.handler.Handler;

public interface ClientManager extends Serializable {

    
    public List<InvestmentFundPack> getInvestmentFunds();

    public void addFund(InvestmentFundPack pack);

}

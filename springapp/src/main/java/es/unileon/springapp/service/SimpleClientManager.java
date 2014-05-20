package es.unileon.springapp.service;

import java.util.List;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.domain.handler.Handler;

public class SimpleClientManager implements ClientManager {

	
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<InvestmentFundPack> getInvestmentFunds() {
		return client.getFunds();
	}

	public void addFund(InvestmentFundPack pack) {
		client.addFundToList(pack);
		
	}
	
	


	
	
	

}

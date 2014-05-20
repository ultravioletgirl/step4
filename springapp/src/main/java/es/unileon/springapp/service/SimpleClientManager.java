package es.unileon.springapp.service;

import java.util.List;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFundPack;

public class SimpleClientManager implements ClientManager {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

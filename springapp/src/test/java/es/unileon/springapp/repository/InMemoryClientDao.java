package es.unileon.springapp.repository;


import java.util.List;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFundPack;


public class InMemoryClientDao implements ClientDao{

	private List<Client> clients;
	private List<InvestmentFundPack> pack;
	

	public InMemoryClientDao(List<Client> list, List<InvestmentFundPack> pack) {
		this.clients = list;
	}

	public List<InvestmentFundPack> getPack() {
		return pack;
	}
	
	public List<Client> getClients() {
		return clients;
	}

	public void addClient(Client client) {
	}

	public List<InvestmentFundPack> getPacks(String id) {
		return null;
	}

	public void save(Client d1) {		
	}

}

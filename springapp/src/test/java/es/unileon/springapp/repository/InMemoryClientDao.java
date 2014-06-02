package es.unileon.springapp.repository;

import java.util.List;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFundPack;


public class InMemoryClientDao implements ClientDao{

	private List<Client> clients;
	public InMemoryClientDao(List<Client> list) {
		this.clients = list;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public List<InvestmentFundPack> getPacks(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Client d1) {
		// TODO Auto-generated method stub
		
	}

}

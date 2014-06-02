package es.unileon.springapp.repository;

import java.util.List;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFundPack;

public interface ClientDao {

	public List<InvestmentFundPack> getPacks(String id);
	public  List<Client> getClients();
	public void addClient(Client client);
	public void save(Client d1);
}

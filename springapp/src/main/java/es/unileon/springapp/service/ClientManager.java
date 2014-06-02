package es.unileon.springapp.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.repository.ClientDao;

public interface ClientManager extends Serializable {

    
	public void setClientDao(ClientDao clientDao);

	public List<Client> getClient();
	
	public List<InvestmentFundPack> getPacks(String id);

}

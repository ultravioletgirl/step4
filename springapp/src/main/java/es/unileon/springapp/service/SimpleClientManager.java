package es.unileon.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.repository.ClientDao;

@Component
public class SimpleClientManager implements ClientManager {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientDao clientDao;

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public List<Client> getClient() {
		return clientDao.getClients();
	}

	public List<InvestmentFundPack> getPacks(String id) {
		List<InvestmentFundPack> funds = clientDao.getPacks(id);

		for(int i =0; i<funds.size();i++){
			InvestmentFundPack fund = funds.get(i);
			fund.stringToBuyable();
			funds.set(i, fund);
		}
		return funds;
	}

	/*public void addFund(InvestmentFundPack pack) {
		client.addFundToList(pack);
	}*/
	

}

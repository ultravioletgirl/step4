package es.unileon.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.domain.handler.FundsHandler;
import es.unileon.springapp.repository.ClientDao;
import es.unileon.springapp.repository.InvestmentFundDao;
import es.unileon.springapp.repository.InvestmentFundPackDao;

@Component
public class SimpleInvestmentFundManager implements InvestmentFundManager{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Autowired
    private InvestmentFundDao investmentFundDao;
	
	@Autowired
    private InvestmentFundPackDao investmentFundPackDao;
	
	@Autowired
    private ClientDao clientDao;

    public InvestmentFundPackDao getInvestmentFundPackDao() {
		return investmentFundPackDao;
	}

	public void setInvestmentFundDao(InvestmentFundDao investmentFundDao) {
        this.investmentFundDao = investmentFundDao;
    }
    
    public void setInvestmentFundPackDao(InvestmentFundPackDao investmentFundPackDao){
    	this.investmentFundPackDao = investmentFundPackDao;
    }
  

	public List<InvestmentFund> getInvestmentFunds() {
		List<InvestmentFund> funds = investmentFundDao.getInvestmentFundList();
		for(int i =0; i<funds.size();i++){
			InvestmentFund fund = funds.get(i);
			fund.stringToFee();
			fund.stringToFeeCancel();
			fund.stringToHandler();
			fund.setTotalPrice(funds.get(i).getTotalPriceDB());
			fund.setAmount(funds.get(i).getAmountDB());
			funds.set(i, fund);
		}
		return funds;
	}

	public void buyPack(String id, int amount, String idClient) throws NotEnoughParticipationsException{
		List<InvestmentFund> funds = investmentFundDao.getInvestmentFundList();
		for(InvestmentFund investment :funds ){

			if (investment.getId() == null){
					investment.stringToHandler();
			}
			FundsHandler han = (FundsHandler) investment.getId();

			if(han.getFundName().equals(id)){

				if (amount > (investment.getAmountDB() - investment.getPurchaseAmount())) {
		            throw new NotEnoughParticipationsException();
		        }
		    
				InvestmentFundPack newPack = new InvestmentFundPack(investment, amount);
		        investment.setPurchaseAmount(investment.getPurchaseAmount() + amount);

		        Client client = new Client();
		        client.setId(idClient);
		        newPack.setClient(client);
		        newPack.investmentToString(investment);
		        newPack.setAmountDB(amount);
		        
		        investmentFundDao.saveInvestmentFund(investment);
		        System.out.println("Antes de meterlo a la bbdd"+newPack.getIdInvestmentFundPack());
		        List<InvestmentFundPack> packs = new ArrayList<InvestmentFundPack>();
		        packs.add(newPack);
		        client.setFunds(packs);
		        clientDao.save(client);
		        //investmentFundPackDao.saveInvestmentFund(newPack);
			}
		}
	}

}

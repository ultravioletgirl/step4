package es.unileon.springapp.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.domain.fee.LinearFee;
import es.unileon.springapp.domain.handler.FundsHandler;
import es.unileon.springapp.repository.ClientDao;
import es.unileon.springapp.repository.InMemoryClientDao;
import es.unileon.springapp.repository.InMemoryInvestmentFundsDao;
import es.unileon.springapp.repository.InMemoryInvestmentFundsPackDao;
import es.unileon.springapp.repository.InvestmentFundDao;
import es.unileon.springapp.repository.InvestmentFundPackDao;


public class SimpleInvestmentFundManagerTests {

	
	private SimpleInvestmentFundManager investmentFundManager;
	private InvestmentFund investmentFund,investmentFund1;
	private FundsHandler han;
	private List<InvestmentFund> funds;
	private FundsHandler invF, invF1;
	private int countFunds = 2;
	private Client client1;
	
    @Before
    public void setUp() throws Exception {
    	
    	String id = "71463171D";
        client1 = new Client(id);

    	invF = new FundsHandler("Santander Global", "Banco Santander", "nosenosenose", 20000020, "Santanderrrr");
    	invF1 = new FundsHandler("Herrero Global", "Banco Herrero", "nosenosenose", 20000020, "Herreroooo");
    	LinearFee fee = new LinearFee(1.5,1.5);
    	
    	investmentFundManager = new SimpleInvestmentFundManager();
        
    	investmentFund = new InvestmentFund(invF, 10, 200.27, fee, fee, 1.5);
 		investmentFund1 = new InvestmentFund(invF1, 5, 200.27, fee, fee, 1.5);
 		investmentFund.setPurchaseAmount(0);
 		investmentFund1.setPurchaseAmount(0);
 		investmentFund1.setAmountDB(investmentFund1.getAmount());
 		investmentFund.setAmountDB(investmentFund.getAmount());

		funds = new ArrayList<InvestmentFund>();
		
		funds.add(investmentFund);
		funds.add(investmentFund1);
		
		InvestmentFundDao investmentFundDao = new InMemoryInvestmentFundsDao(funds);
        investmentFundManager.setInvestmentFundDao(investmentFundDao);
        
        List<InvestmentFundPack> packs = new ArrayList<InvestmentFundPack>();
        InvestmentFundPackDao investmentFundPackDao = new InMemoryInvestmentFundsPackDao(packs);
        investmentFundManager.setInvestmentFundPackDao(investmentFundPackDao);
		
    }

    @Test
    public void testGetFundsWithNoFunds() {
    	investmentFundManager = new SimpleInvestmentFundManager();
    	investmentFundManager.setInvestmentFundDao(new InMemoryInvestmentFundsDao(null));
        assertNull(investmentFundManager.getInvestmentFunds());
    }
    
    
    @Test
    public void testGetFunds() {
    	 List<InvestmentFund> fundsList = investmentFundManager.getInvestmentFunds();
         assertNotNull(fundsList);        
         assertEquals(countFunds, investmentFundManager.getInvestmentFunds().size());
     
         InvestmentFund investmentFund2 = fundsList.get(0);
         assertEquals(10, investmentFund2.getParticipations());
         
         investmentFund2 = fundsList.get(1);
         assertEquals(5, investmentFund2.getParticipations());
    }
    
    
	@Test
	public void buyFundPackTestOk() throws NotEnoughParticipationsException {
		ClientManager clientManager = new SimpleClientManager();
		String id = "71463171D";
	    client1 = new Client(id);
	    List<Client> list = new ArrayList<Client>();
	    list.add(client1);
	    ClientDao clientDao = new InMemoryClientDao(list,null);         
	    clientManager.setClientDao(clientDao);
	    investmentFundManager.setClientDao(clientDao);
	    
		List<InvestmentFund> fundsList = investmentFundManager.getInvestmentFunds();
		han = (FundsHandler) fundsList.get(0).getId();
		investmentFundManager.buyPack(han.getFundName(), 10, client1.getId());
		int result = fundsList.get(0).getPurchaseAmount();
    	Assert.assertEquals(10, result );
    	Assert.assertEquals(10, fundsList.get(0).getParticipations());
	}
	
	@Test (expected=NotEnoughParticipationsException.class)
	public void buyFundPackTestNotOk() throws NotEnoughParticipationsException {
		List<InvestmentFund> fundsList = investmentFundManager.getInvestmentFunds();

		han = (FundsHandler) fundsList.get(1).getId();
		investmentFundManager.buyPack(han.getFundName(), 10,client1.getId());
    	
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void buyEmptyFundPackTest() throws NotEnoughParticipationsException {
		List<InvestmentFund> fundsList= new ArrayList<InvestmentFund>();
    	investmentFundManager.setInvestmentFundDao(new InMemoryInvestmentFundsDao(null));

		han = (FundsHandler) fundsList.get(0).getId();
		investmentFundManager.buyPack(han.getFundName(), 10,client1.getId());
		
	}


}

package es.unileon.springapp.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.domain.handler.FundsHandler;

public class SimpleInvestmentFundManagerTests {

	
	private SimpleInvestmentFundManager investmentFundManager;
	private InvestmentFund investmentFund,investmentFund1;
	private List<InvestmentFund> funds;
	private FundsHandler invF, invF1;
	private int countFunds = 2;
	
	//TO-DO mirar cuales son nuestros tipos de fondo y fund share??
    @Before
    public void setUp() throws Exception {
    	invF = new FundsHandler("Santander Global", "Banco Santander", "nosenosenose", 20000020, "Santanderrrr");
    	invF1 = new FundsHandler("Herrero Global", "Banco Herrero", "nosenosenose", 20000020, "Herreroooo");
    	
    	investmentFundManager = new SimpleInvestmentFundManager();
        
        investmentFund = new InvestmentFund(invF, 10, 200.27, null, null, 1.5);
		investmentFund1 = new InvestmentFund(invF1, 5, 200.27, null, null, 1.5);
   
		funds = new ArrayList<InvestmentFund>();
		
		funds.add(investmentFund);
		funds.add(investmentFund1);
		
		investmentFundManager.setInvestmentFunds(funds);
		
    }

    @Test
    public void testGetFundsWithNoFunds() {
    	investmentFundManager = new SimpleInvestmentFundManager();
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
		List<InvestmentFund> fundsList = investmentFundManager.getInvestmentFunds();

		InvestmentFundPack buyPack = investmentFundManager.buyFundPack(fundsList.get(0), 10);
		
    	Assert.assertEquals(10, fundsList.get(0).getPurchasedAmount());
    	Assert.assertEquals(10, fundsList.get(0).getParticipations());
	}
	
	@Test (expected=NotEnoughParticipationsException.class)
	public void buyFundPackTestNotOk() throws NotEnoughParticipationsException {
		List<InvestmentFund> fundsList = investmentFundManager.getInvestmentFunds();

		InvestmentFundPack buyPack = investmentFundManager.buyFundPack(fundsList.get(1), 10);
		
    	
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void buyEmptyFundPackTest() throws NotEnoughParticipationsException {
		List<InvestmentFund> fundsList= new ArrayList<InvestmentFund>();
		InvestmentFundPack buyPack = investmentFundManager.buyFundPack(fundsList.get(0), 10);
		
    	Assert.assertEquals(10, fundsList.get(0).getPurchasedAmount());
    	Assert.assertEquals(10, fundsList.get(0).getParticipations());
	}


}

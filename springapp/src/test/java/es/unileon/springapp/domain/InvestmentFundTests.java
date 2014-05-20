package es.unileon.springapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InvestmentFundTests {

	private InvestmentFund investmentFund,investmentFund1;
	
	//public InvestmentFund(Handler id, int amount, double totalPrice, FeeStrategy fee, FeeStrategy cancellationFee, double profitability) throws InvalidBuyableException {

	@Before
    public void setUp() throws InvalidBuyableException {
		investmentFund = new InvestmentFund(null, 10, 200.27, null, null, 1.5);
		investmentFund1 = new InvestmentFund(null, 5, 200.27, null, null, 1.5);
    }

   /* @Test
    public void testInvestmentFund() throws InvalidBuyableException {
//        invesFundTest1 = new InvestmentFund(null, 10, 200.27, null, null, 0.03);
    }*/


    @Test
    public void testBuyInvestmentFundOk() throws InvalidBuyableException, NotEnoughParticipationsException {
    	InvestmentFundPack buyPack = investmentFund.buy(10);
    	Assert.assertEquals(10, buyPack.amount);
    	Assert.assertEquals(10, investmentFund.getParticipations());
    	Assert.assertEquals(10, investmentFund.getPurchasedAmount());
    }
    
    @Test(expected=NotEnoughParticipationsException.class)
    public void testBuyInvestmentFundNotOk() throws InvalidBuyableException, NotEnoughParticipationsException {
    	InvestmentFundPack buyPack = investmentFund1.buy(10);
    	
    }
}

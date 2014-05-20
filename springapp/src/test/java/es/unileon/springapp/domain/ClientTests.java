package es.unileon.springapp.domain;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.springapp.domain.handler.FundsHandler;

public class ClientTests {

	private List<InvestmentFund> fundsList;
	private List<InvestmentFundPack> fundsPackList;

	private Client client1;
	private InvestmentFund investmentFund,investmentFund1;
	private InvestmentFundPack pack1, pack2;
	private FundsHandler invF, invF1;
	//private int countFunds = 2;
	
	@Before
    public void setUp() throws Exception  {

		fundsList = new ArrayList<InvestmentFund>();
		fundsPackList = new ArrayList<InvestmentFundPack>();

		invF = new FundsHandler("Santander Global", "Banco Santander", "nosenosenose", 20000020, "Santanderrrr");
    	invF1 = new FundsHandler("Herrero Global", "Banco Herrero", "nosenosenose", 20000020, "Herreroooo");
    	        
        investmentFund = new InvestmentFund(invF, 10, 200.27, null, null, 1.5);
		investmentFund1 = new InvestmentFund(invF1, 5, 200.27, null, null, 1.5);
		fundsList.add(investmentFund);
		fundsList.add(investmentFund1);
		
    }



	@Test
	public void emptyClientTest(){
		client1=new Client();
        assertTrue(client1.getFunds().isEmpty());
	}
 
	@Test
	public void addFoundTest(){
		pack1= new InvestmentFundPack(investmentFund, 10);
		client1 = new Client(pack1);	
		assertEquals(1, client1.getFunds().size());
	}
	
	@Test
	public void addListTest(){
		pack1= new InvestmentFundPack(investmentFund, 10);
		pack2= new InvestmentFundPack(investmentFund1, 4);

		fundsPackList.add(pack1);
		fundsPackList.add(pack2);
		client1 = new Client();
		
		client1.addFundToList(pack1);
		client1.addFundToList(pack2);
		assertEquals(2, fundsPackList.size());
		assertEquals(2, client1.getFunds().size());
	}
	
	@Test
	public void addFoundInListTest(){
		pack1= new InvestmentFundPack(investmentFund, 10);
		pack2= new InvestmentFundPack(investmentFund1, 4);

		fundsPackList.add(pack1);
		fundsPackList.add(pack2);
		client1 = new Client(fundsPackList);	
		assertEquals(2, client1.getFunds().size());
	
	}

}

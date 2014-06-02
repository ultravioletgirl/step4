package es.unileon.springapp.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.fee.LinearFee;
import es.unileon.springapp.domain.handler.FundsHandler;


public class JPAInvestmentFundPackTests {

	private ApplicationContext context;
    private InvestmentFundPackDao investmentFundPackDao;
    private FundsHandler invF;
    private InvestmentFund investmentFund;
    private ClientDao clientDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        investmentFundPackDao = (InvestmentFundPackDao) context.getBean("investmentFundPackDao");
        clientDao = (ClientDao) context.getBean("clientDao");
    	invF = new FundsHandler("Santander Global", "Banco Santander", "nosenosenose", 20000020, "Santanderrrr");
    	LinearFee fee = new LinearFee(1.5,1.5);
        investmentFund = new InvestmentFund(invF, 10, 200.27, fee, fee, 1.5);

    }

    @Test
    public void testGetInvestmentFundPackList() {
        List<InvestmentFundPack> packs = investmentFundPackDao.getInvestmentFundList();
        assertEquals(packs.size(), 2, 0);	   
    }
    

    @Test
    public void testClient() {
    	InvestmentFundPack pack = new InvestmentFundPack();
    	//pack.setIdClient("71463171D");
    	//pack.setAmountDB(1);
    	/*pack.investmentToString(investmentFund);

    	investmentFundPackDao.saveInvestmentFund(pack);
        List<InvestmentFundPack> packs = investmentFundPackDao.getInvestmentFundList();
        assertEquals(packs.size(),3, 0);*/
        
        // Now let us create Department
        Client d1 = new Client();
        d1.setId("71463171D");

        // Now let us some employees
        List<InvestmentFundPack> empList = new ArrayList<InvestmentFundPack>();
        InvestmentFundPack e1 = new InvestmentFundPack();

        pack.setClient(d1);
    	pack.setAmountDB(1);
    	pack.investmentToString(investmentFund);
    	System.out.println(pack.getIdInvestmentFundPack());
        empList.add(pack);
        System.out.println(pack.getClient().getId());
        
        System.out.println(empList.get(0).getAmountDB());

        d1.setFunds(empList);
        clientDao.save(d1);
    }

}

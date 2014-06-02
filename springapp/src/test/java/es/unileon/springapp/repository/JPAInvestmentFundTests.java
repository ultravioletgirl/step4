package es.unileon.springapp.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.InvestmentFundPack;
import es.unileon.springapp.domain.fee.LinearFee;
import es.unileon.springapp.domain.handler.FundsHandler;

public class JPAInvestmentFundTests {

	private ApplicationContext context;
    private InvestmentFundDao investmentFundDao;
    private FundsHandler invF;
    private InvestmentFund fund;
    
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        investmentFundDao = (InvestmentFundDao) context.getBean("investmentFundDao");
    	invF = new FundsHandler("sdjfgskjfsl", "dhfssldfsksd", "nosenosenose", 20000020, "Santanderrrr");
    	LinearFee fee = new LinearFee(1.5,1.5);
    	 fund = new InvestmentFund(invF, 10, 30, fee, fee, 1.5);

    }

    @Test
    public void testGetInvestmentFundPackList() {
        List<InvestmentFund> funds = investmentFundDao.getInvestmentFundList();
        assertEquals(funds.size(), 2, 0);	   
    }
    
   
    

    @Test
    public void testSaveProduct() {

	investmentFundDao.saveInvestmentFund(fund);
    List<InvestmentFund> packs = investmentFundDao.getInvestmentFundList();
    assertEquals(packs.size(),3, 0);	
    }


}

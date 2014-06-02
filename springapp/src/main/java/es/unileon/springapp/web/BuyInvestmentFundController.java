package es.unileon.springapp.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.service.BuyInvestmentFund;
import es.unileon.springapp.service.InvestmentFundManager;


@Controller
@RequestMapping(value="/fundsList.htm")
public class BuyInvestmentFundController {

	 /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    
    @Autowired
    private InvestmentFundManager investmentFundManager;
    
    
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid  BuyInvestmentFund buy, BindingResult result) throws NotEnoughParticipationsException
    {
		 if (result.hasErrors()) {
	         return "buy";
	     }

		 int numberOfPacks = buy.getPacks();
	     logger.info("Buying packs " + numberOfPacks+".");
	     
	     String fin;
	     try{
	    	 fin = "redirect:/client.htm";
	    	 investmentFundManager.buyPack(buy.getFundName(), numberOfPacks, "71463171D");
	     }catch(NotEnoughParticipationsException exception){
	    	fin = "redirect:/error.htm";
	    	 
	     }

	     return fin;
    }

    
	public void setClientManager(InvestmentFundManager investmentFundManager) {
        this.investmentFundManager = investmentFundManager;
		
	}
    
    
}

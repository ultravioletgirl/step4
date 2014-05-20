package es.unileon.springapp.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFund;
import es.unileon.springapp.domain.NotEnoughParticipationsException;
import es.unileon.springapp.service.BuyInvestmentFund;
import es.unileon.springapp.service.ClientManager;
import es.unileon.springapp.service.InvestmentFundManager;
import es.unileon.springapp.service.SimpleInvestmentFundManager;

@Controller
@RequestMapping(value="/fundsList.htm")
public class BuyInvestmentFundController {

	 /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private ClientController client;
    @Autowired
    private InvestmentFundManager investmentFundManager;
    

    @RequestMapping(value="/fundsList.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("funds", this.investmentFundManager.getInvestmentFunds());

        return new ModelAndView("fundsList", "model", myModel);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid InvestmentFund fund, BuyInvestmentFund buy, BindingResult result) throws NotEnoughParticipationsException
    {
	 if (result.hasErrors()) {
         return "buy";
     }
		
     int numberOfPacks = buy.getPacks();
     logger.info("Buying packs " + numberOfPacks+".");

     BuyInvestmentFund clientManager = new BuyInvestmentFund();
	 client.onSubmit(fund, buy, result);

     return "redirect:/client.htm";
 }



	public void setClientManager(InvestmentFundManager investmentFundManager) {
        this.investmentFundManager = investmentFundManager;
		
	}
    
    
}

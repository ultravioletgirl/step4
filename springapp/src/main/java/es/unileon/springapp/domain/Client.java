package es.unileon.springapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable{
	
	private List<InvestmentFundPack> funds;
	
	public Client(){
		funds= new ArrayList<InvestmentFundPack>();
		
	}
	
	public Client(InvestmentFundPack fund){
		funds= new ArrayList<InvestmentFundPack>();

		funds.add(fund);
		
	}
	
	public Client(List<InvestmentFundPack> fundsL){
		funds= new ArrayList<InvestmentFundPack>();

		funds.addAll(fundsL);
		
	}

	public List<InvestmentFundPack> getFundsList() {
		return funds;
	}

	public void setFundsList(List<InvestmentFundPack> fundsList) {
		this.funds = fundsList;
	}
	
	public void addFundToList(InvestmentFundPack fund){
		funds.add(fund);

	}
}
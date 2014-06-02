package es.unileon.springapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client") 
public class Client implements Serializable{
	
	@Id
    @Column(name = "idClient")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

	@OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="idClient",  nullable = false) //we need to duplicate the physical information
    List<InvestmentFundPack> funds;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Client(){
		
	}
	public Client(String idP){
		this.id = idP;
		funds= new ArrayList<InvestmentFundPack>();
		
	}
	
	public Client(String idP,InvestmentFundPack fund){
		this.id = idP;
		funds= new ArrayList<InvestmentFundPack>();

		funds.add(fund);
		
	}
	
	public Client(String idP, List<InvestmentFundPack> fundsL){
		this.id = idP;
		funds= new ArrayList<InvestmentFundPack>();

		funds.addAll(fundsL);
		
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<InvestmentFundPack> getFunds() {
		return funds;
	}

	public void setFunds(List<InvestmentFundPack> fundsList) {
		this.funds = fundsList;
	}
	
	public void addFundToList(InvestmentFundPack fund){
		funds.add(fund);

	}
}

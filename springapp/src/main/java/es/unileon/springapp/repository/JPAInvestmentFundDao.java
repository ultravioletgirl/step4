package es.unileon.springapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.springapp.domain.InvestmentFund;

@Repository(value = "investmentFundDao")
public class JPAInvestmentFundDao implements InvestmentFundDao{

	private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<InvestmentFund> getInvestmentFundList() {
    	return em.createQuery("select i from InvestmentFund i order by i.id").getResultList();

	}

    @Transactional(readOnly = false)
	public void saveInvestmentFund(InvestmentFund InvestmentFund) {
        em.merge(InvestmentFund);		
	}
	
	

}

package es.unileon.springapp.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.springapp.domain.InvestmentFundPack;

@Repository(value = "investmentFundPackDao")
public class JPAInvestmentFundPackDao implements InvestmentFundPackDao{

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
	public List<InvestmentFundPack> getInvestmentFundList() {
    	return em.createQuery("select i from InvestmentFundPack i order by i.idInvestmentFundPack").getResultList();

	}

    @Transactional(readOnly = false)
	public void saveInvestmentFund(InvestmentFundPack investmentFundPack) {
        em.merge(investmentFundPack);
	}

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<InvestmentFundPack> getInvestmentFundListWithID(String id) {
    	//return em.createQuery("select i from InvestmentFundPack where i.idClient like : custIdClient").setParameter("custIdClient", 71463171D).getResultList();
    	return em.createQuery("select i from InvestmentFundPack i order by i.idInvestmentFundPack").getResultList();
	}

}

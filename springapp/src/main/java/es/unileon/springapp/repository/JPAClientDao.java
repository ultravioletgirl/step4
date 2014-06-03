package es.unileon.springapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.springapp.domain.Client;
import es.unileon.springapp.domain.InvestmentFundPack;


@Repository(value = "clientDao")
public class JPAClientDao implements ClientDao{

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
	public  List<Client> getClients() {
    	return em.createQuery("select c from Client c order by c.id").getResultList();
	}
    
    @Transactional(readOnly = false)
	public void addClient(Client client) {
        em.merge(client);
	}

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<InvestmentFundPack> getPacks(String id) {
    	return em.createQuery("select i from InvestmentFundPack i order by i.idInvestmentFundPack").getResultList();
    	//return em.createQuery("select i from InvestmentFundPack i where i.amountDB like :idCliente").setParameter("idCliente", 6).getResultList();
		//InvestmentFundPackDao dao = new JPAInvestmentFundPackDao();
		//return dao.getInvestmentFundListWithID(id);
	}

    @Transactional(readOnly = false)
	public void save(Client d1) {
    	em.merge(d1);
	}
	
	

}

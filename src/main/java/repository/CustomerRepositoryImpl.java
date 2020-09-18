package repository;

import model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CustomerRepositoryImpl implements ICustomerRepository<Customer> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("select c from Customer as c",Customer.class);
        return query.getResultList();

    }

    @Override
    public Customer findById(long id) {
//        TypedQuery<Customer> query = em.createQuery("select c from Customer as c where c.id = ?1",Customer.class);
//        query.setParameter(1,id);
//        try {
//            return query.getSingleResult();
//        } catch (NoResultException e){
//            return null;
//        }
        return em.find(Customer.class,id);
    }

    @Override
    public void save(Customer model) {
        if (findById(model.getId()) == null){
            System.out.println("persist");
            em.persist(model);
        } else {
            System.out.println("merge");
            em.merge(model);
        }
    }


    @Override
    public void remove(long id) {
        em.remove(findById(id));
    }
}

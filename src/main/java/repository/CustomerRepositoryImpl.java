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
    public Customer select(long id) {
        return null;
    }

    @Override
    public boolean save(Customer model) {
        return false;
    }

    @Override
    public boolean update(Customer model) {
        return false;
    }

    @Override
    public boolean remove(long id) {
        return false;
    }
}

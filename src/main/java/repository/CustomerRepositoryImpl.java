package repository;

import model.Customer;

import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository<Customer> {
    @Override
    public List<Customer> findAll() {
        return null;
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

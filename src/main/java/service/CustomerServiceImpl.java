package service;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ICustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService<Customer>{
    @Autowired
    ICustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
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

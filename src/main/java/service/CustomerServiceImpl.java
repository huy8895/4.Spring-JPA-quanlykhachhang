package service;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ICustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService<Customer>{
    @Autowired
    ICustomerRepository<Customer> customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer model) {
        customerRepository.save(model);
    }

    @Override
    public void remove(long id) {
        customerRepository.remove(id);
    }
}

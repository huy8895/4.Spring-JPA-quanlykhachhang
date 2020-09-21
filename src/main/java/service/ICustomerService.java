package service;

import model.Customer;
import model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Customer findById(long id);

    void save(Customer model);

    void remove(long id);

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);

    Iterable<Customer> findAllByProvince(Province province);

}

package service;

import model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService<T> {
    Iterable<Customer> findAll();

    T findById(long id);

    void save(T model);

    void remove(long id);

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);

}

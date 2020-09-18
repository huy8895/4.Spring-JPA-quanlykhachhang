package service;

import model.Customer;

import java.util.List;

public interface ICustomerService<T> {
    List<T> findAll();

    T select(long id);

    boolean save(T model);

    boolean update(T model);

    boolean remove(long id);
}

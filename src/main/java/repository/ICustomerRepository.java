package repository;

import java.util.List;

public interface ICustomerRepository<T> {
    List<T> findAll();

    T select(long id);

    boolean save(T model);

    boolean update(T model);

    boolean remove(long id);
}

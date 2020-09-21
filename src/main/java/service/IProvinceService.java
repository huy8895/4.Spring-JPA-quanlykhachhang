package service;

import model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceService  {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}

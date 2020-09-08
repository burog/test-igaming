package ru.fadeev.test.igaming.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.fadeev.test.igaming.domain.Product;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findByName(String name);

}

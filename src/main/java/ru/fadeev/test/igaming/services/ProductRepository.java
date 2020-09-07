package ru.fadeev.test.igaming.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.fadeev.test.igaming.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> {
    List<Product> findByName(String name);

}

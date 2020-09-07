package ru.fadeev.test.igaming.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fadeev.test.igaming.domain.Product;
import ru.fadeev.test.igaming.domain.exceptions.NotFoundException;

import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Product getProduct(UUID id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("can't find product by id "+id));
    }

    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }
}

package ru.fadeev.test.igaming.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fadeev.test.igaming.domain.Product;
import ru.fadeev.test.igaming.domain.exceptions.NotFoundException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Product getProduct(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("can't find product by id "+id));
    }

    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public Product update(Product product) {
        productRepo.findById(product.getId())
                .orElseThrow(() -> new NotFoundException("can't find product by id " + product.getId()));

        return productRepo.save(product);
    }
}

package ru.fadeev.test.igaming.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fadeev.test.igaming.domain.Product;
import ru.fadeev.test.igaming.exceptions.IncorrectInputId;
import ru.fadeev.test.igaming.exceptions.NotFoundException;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public Product createProduct(Product product) {
        if (productRepo.existsById(product.getId())) {
            log.warn("Can't create product. product with id {} is already exist", product.getId());
            throw new IncorrectInputId(product.getId());
        }
        return productRepo.save(product);
    }

    public Product getProduct(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void deleteProduct(Long id) {
        if (!productRepo.existsById(id))
            throw new NotFoundException(id);

        productRepo.deleteById(id);
    }

    public Product update(Product product) {
        productRepo.findById(product.getId())
                .orElseThrow(() -> new NotFoundException(product.getId()));

        return productRepo.save(product);
    }
}

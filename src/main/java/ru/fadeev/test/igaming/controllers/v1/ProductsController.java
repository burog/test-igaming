package ru.fadeev.test.igaming.controllers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.fadeev.test.igaming.domain.Product;
import ru.fadeev.test.igaming.dto.v1.ProductDto;
import ru.fadeev.test.igaming.services.ProductMapper;
import ru.fadeev.test.igaming.services.ProductService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/products")
public class ProductsController {

    private static final Random RANDOM = new Random();
    @Autowired
    private ProductService service;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);
        return productMapper.productToProductDto(service.createProduct(product));
    }

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable Long id) {

        Product product = service.getProduct(id);
        return productMapper.productToProductDto(product);
    }

//    TODO REMOVE
    @GetMapping("hello")
    public ProductDto getProduct() {
        ProductDto productDto = new ProductDto();
        productDto.setName("stub hello product");
        productDto.setPrice(1L);
        productDto.setId(RANDOM.nextLong());
        productDto.setDate(LocalDateTime.now());
        return productDto;
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        Iterable<Product> allProducts = service.getAllProducts();
        return StreamSupport.stream(allProducts.spliterator(), false)
                .map(product -> productMapper.productToProductDto(product)).collect(Collectors.toList());
    }

    @DeleteMapping
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }

    @PutMapping
    public ProductDto update(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);
        Product updatedProduct = service.update(product);
        return productMapper.productToProductDto(updatedProduct);
    }
}

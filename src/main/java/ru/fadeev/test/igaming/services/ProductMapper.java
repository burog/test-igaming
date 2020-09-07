package ru.fadeev.test.igaming.services;

import org.mapstruct.Mapper;
import ru.fadeev.test.igaming.domain.Product;
import ru.fadeev.test.igaming.dto.v1.ProductDto;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto productDto);
}

package ru.fadeev.test.igaming.dto.v1;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private Long price;
//    private MonetaryAmount price;
    private LocalDateTime date;
//todo add curency and float value
}

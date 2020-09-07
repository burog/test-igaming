package ru.fadeev.test.igaming.dto.v1;

import lombok.Data;

import javax.money.MonetaryAmount;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ProductDto {
    private UUID id;
    private String name;
    private Long price;
//    private MonetaryAmount price;
    private LocalDateTime date;
//todo add curency and float value
}

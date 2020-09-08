package ru.fadeev.test.igaming.dto.v1;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {
    private Long id;
    private String name;
    //TODO here should be money pattern by Martin Fowler, just keep long as for simplicity
    private Long price;
    private LocalDateTime date;
}

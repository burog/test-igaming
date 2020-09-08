package ru.fadeev.test.igaming.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("can't find product by id =" + id);
    }
}

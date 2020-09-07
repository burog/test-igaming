package ru.fadeev.test.igaming.domain.exceptions;

//TODO add @ControllerAdvice
public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }
}

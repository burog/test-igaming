package ru.fadeev.test.igaming.exceptions;

public class IncorrectInputId extends RuntimeException {
    public IncorrectInputId(Long id) {
        super("can't perform operation with incorrect input id =" + id);
    }
}

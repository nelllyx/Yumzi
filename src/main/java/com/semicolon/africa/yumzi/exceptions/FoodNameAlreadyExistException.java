package com.semicolon.africa.yumzi.exceptions;

public class FoodNameAlreadyExistException extends RuntimeException {
    public FoodNameAlreadyExistException(String message) {
        super(message);
    }
}

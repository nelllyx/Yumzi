package com.semicolon.africa.yumzi.exceptions;

public class IncorrectPasswordOrEmailException extends RuntimeException {
    public IncorrectPasswordOrEmailException(String message) {
        super(message);
    }
}

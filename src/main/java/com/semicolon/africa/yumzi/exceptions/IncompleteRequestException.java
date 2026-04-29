package com.semicolon.africa.yumzi.exceptions;

public class IncompleteRequestException extends RuntimeException {
    public IncompleteRequestException(String message) {
        super(message);
    }
}

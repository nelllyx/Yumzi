package com.semicolon.africa.yumzi.exceptions;

public class InvalidPhoneNumberValueException extends RuntimeException{
    public InvalidPhoneNumberValueException(String message) {
        super(message);
    }
}

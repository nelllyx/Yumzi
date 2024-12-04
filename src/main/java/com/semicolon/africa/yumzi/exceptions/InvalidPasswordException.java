package com.semicolon.africa.yumzi.exceptions;

import com.semicolon.africa.yumzi.services.YumziUsers;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

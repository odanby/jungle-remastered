package com.jungle.exceptions;

public class UsernameOrPasscodeException extends RuntimeException {
    public UsernameOrPasscodeException(String message) {
        super(message);
    }
}
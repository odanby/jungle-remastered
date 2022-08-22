package com.jungle.exceptions;

public class IncorrectLogin extends RuntimeException {

    public IncorrectLogin(String message) {
        super(message);
    }
}

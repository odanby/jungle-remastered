package com.jungle.exceptions;

public class DuplicateEmail extends RuntimeException {

    public DuplicateEmail(String message) {
        super(message);
    }

}
package com.jungle.exceptions;

public class DuplicateUsername extends RuntimeException {

    public DuplicateUsername (String message) {
        super(message);
    }

}

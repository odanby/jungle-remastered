package com.jungle.exceptions;

public class TooManyCharacters extends RuntimeException{
    public TooManyCharacters(String message) {
        super(message);
    }
}

package com.iamlipe.MyMacros.infrastructure.exceptions;

public class InvalidEmailFormat extends RuntimeException {

    public InvalidEmailFormat() {
        super("Please provide a valid email address.");
    }
}

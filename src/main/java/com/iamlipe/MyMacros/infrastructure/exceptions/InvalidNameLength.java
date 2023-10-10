package com.iamlipe.MyMacros.infrastructure.exceptions;

public class InvalidNameLength extends RuntimeException {

    public InvalidNameLength() {
        super("The password must be at least 8 characters long.");
    }
}

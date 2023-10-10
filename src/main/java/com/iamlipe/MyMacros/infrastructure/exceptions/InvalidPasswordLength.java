package com.iamlipe.MyMacros.infrastructure.exceptions;

public class InvalidPasswordLength extends RuntimeException {

    public InvalidPasswordLength() {
        super("The password must be at least 8 characters long.");
    }
}

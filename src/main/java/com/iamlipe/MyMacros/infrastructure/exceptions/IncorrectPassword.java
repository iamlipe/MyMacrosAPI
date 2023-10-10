package com.iamlipe.MyMacros.infrastructure.exceptions;

public class IncorrectPassword extends RuntimeException {

    public IncorrectPassword() {
        super("Email and password do not match");
    }
}

package com.iamlipe.MyMacros.infrastructure.exceptions;

public class EmailAlreadyRegistered extends RuntimeException {

    public EmailAlreadyRegistered() {
        super("The provided email address is already in use.");
    }
}

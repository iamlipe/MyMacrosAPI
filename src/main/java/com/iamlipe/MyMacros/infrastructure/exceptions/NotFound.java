package com.iamlipe.MyMacros.infrastructure.exceptions;

public class NotFound extends RuntimeException {

    public NotFound(String id) {
        super("Not found " + id);
    }
}

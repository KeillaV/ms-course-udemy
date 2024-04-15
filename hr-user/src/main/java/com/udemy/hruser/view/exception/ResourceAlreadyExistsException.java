package com.udemy.hruser.view.exception;

public class ResourceAlreadyExistsException extends Exception {

    public ResourceAlreadyExistsException(String resource, String name, String value) {
        super(String.format("A %s with %s '%s' already exists", resource, name, value));
    }
}

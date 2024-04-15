package com.udemy.hruser.view.exception;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String resource, String name, String value) {
        super(String.format("Could not find a %s with %s '%s'", resource, name, value));
    }
}

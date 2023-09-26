package com.isaacyakl.pleasanthollow.api.errors;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

package com.isaacyakl.pleasanthollow.api.error;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

package com.isaacyakl.pleasanthollow.api.errors;

public class PostNotFoundException extends Exception {
    public PostNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

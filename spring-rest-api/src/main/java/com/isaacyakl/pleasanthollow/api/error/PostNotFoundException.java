package com.isaacyakl.pleasanthollow.api.error;

public class PostNotFoundException extends Exception {
    public PostNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

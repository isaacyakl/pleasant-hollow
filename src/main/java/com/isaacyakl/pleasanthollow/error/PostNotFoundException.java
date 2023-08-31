package com.isaacyakl.pleasanthollow.error;

public class PostNotFoundException extends Exception {
    public PostNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}

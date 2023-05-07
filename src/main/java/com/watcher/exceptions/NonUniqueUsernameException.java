package com.watcher.exceptions;

public class NonUniqueUsernameException extends RuntimeException {
    public NonUniqueUsernameException(String message) {
        super(message);
    }
}
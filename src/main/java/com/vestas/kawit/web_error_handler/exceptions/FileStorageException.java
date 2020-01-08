package com.vestas.kawit.web_error_handler.exceptions;

public class FileStorageException extends RuntimeException {

    private String message;

    public FileStorageException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

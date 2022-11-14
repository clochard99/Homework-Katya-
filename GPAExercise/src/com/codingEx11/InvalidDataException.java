package com.codingEx11;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}

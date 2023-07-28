package com.example.retro.exception;

public class GameRentingException extends Exception {
    public final static String CANNOT_RENT = "Cannot found or rent game with given id";
    public GameRentingException() {

    }

    public GameRentingException(String message) {
        super(message);
    }

    public GameRentingException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameRentingException(Throwable cause) {
        super(cause);
    }

    public GameRentingException(String message, Throwable cause, boolean enableSupression, boolean writableStackTrace) {
        super(message, cause, enableSupression, writableStackTrace);
    }
}

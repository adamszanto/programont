package com.example.restapp.exception;

public class DoctorValidationException extends Exception{

    public DoctorValidationException() {
    }

    public DoctorValidationException(String message) {
        super(message);
    }

    public DoctorValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoctorValidationException(Throwable cause) {
        super(cause);
    }

    public DoctorValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}

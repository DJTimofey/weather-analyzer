package com.example.weatheranalyzer.exceptions;

import java.time.LocalDate;

public class InvalidDateException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Invalid date";

    public InvalidDateException() {
        this(DEFAULT_MESSAGE);
    }

    public InvalidDateException(String message) {
        super(message);
    }

    public InvalidDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDateException(Throwable cause) {
        super(cause);
    }

    public static InvalidDateException create(String message) {
        return new InvalidDateException(message);
    }

    public static InvalidDateException create(Throwable cause) {
        return new InvalidDateException(cause);
    }

    public LocalDate getInvalidDate() {
        return null;
    }

    public void setInvalidDate(LocalDate invalidDate) {
    }
}

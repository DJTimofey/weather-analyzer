package com.example.weatheranalyzer.exceptions;

public class WeatherDataNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Weather data not found";

    public WeatherDataNotFoundException() {
        this(DEFAULT_MESSAGE);
    }

    public WeatherDataNotFoundException(String message) {
        super(message);
    }

    public WeatherDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherDataNotFoundException(Throwable cause) {
        super(cause);
    }

    public static WeatherDataNotFoundException create(String message) {
        return new WeatherDataNotFoundException(message);
    }

    public static WeatherDataNotFoundException create(Throwable cause) {
        return new WeatherDataNotFoundException(cause);
    }
}
package com.example.weatheranalyzer.exceptions;

public class WeatherAPIException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Weather API error";

    public WeatherAPIException() {
        this(DEFAULT_MESSAGE);
    }

    public WeatherAPIException(String message) {
        super(message);
    }

    public WeatherAPIException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherAPIException(Throwable cause) {
        super(cause);
    }

    public static WeatherAPIException create(String message) {
        return new WeatherAPIException(message);
    }

    public static WeatherAPIException create(Throwable cause) {
        return new WeatherAPIException(cause);
    }

    public Integer getCode() {
        return null;
    }

    public void setCode(Integer code) {
    }
}

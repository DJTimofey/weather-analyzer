package com.example.weatheranalyzer.modul.answer;

import lombok.Value;

@Value
public class ExceptionModul {

    String message;
    int statusCode;
    String statusMessage;
}
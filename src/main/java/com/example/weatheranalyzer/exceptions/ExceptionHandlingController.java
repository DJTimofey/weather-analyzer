package com.example.weatheranalyzer.exceptions;

import com.example.weatheranalyzer.modul.answer.ExceptionModul;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler({WeatherDataNotFoundException.class, InvalidDateException.class})
    public ResponseEntity<ExceptionModul> handleGeneralExceptions(RuntimeException e) {
        log.error("General error occurred:", e);
        return new ResponseEntity<>(
                new ExceptionModul(
                        "An unexpected error occurred. Please try again later.",
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionModul> parameterValidationExceptionHandler(
            MethodArgumentNotValidException e) {
        log.error("Invalid parameters:", e);
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            List<String> validationErrors = new ArrayList<>();
            for (FieldError error : result.getFieldErrors()) {
                validationErrors.add(error.getDefaultMessage());
            }
            return new ResponseEntity<>(
                    new ExceptionModul("Invalid parameters: " + validationErrors.toString(),
                            HttpStatus.BAD_REQUEST.value(),
                            HttpStatus.BAD_REQUEST.getReasonPhrase()),
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                new ExceptionModul("Argument validation failed", HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WeatherAPIException.class)
    public void handleWeatherAPIException(WeatherAPIException e) {
        log.error("Weather API error:", e);
    }
}
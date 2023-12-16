package com.example.weatheranalyzer.modul.request;



import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Value
public class DateFormat {

    @NotBlank(message = "Field cannot be empty")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Date format must be: dd-MM-yyyy")
    String from;

    @NotBlank(message = "Field cannot be empty")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Date format must be: dd-MM-yyyy")
    String to;
}

package com.example.weatheranalyzer.modul.answer;

import lombok.Value;

@Value
public class Weather {

    String location;
    Integer temperature;
    Double windMetersPerHour;
    Double pressureMB;
    Double humidity;
    String weatherCondition;
}

package com.example.weatheranalyzer.service;

import com.example.weatheranalyzer.modul.request.DateFormat;
import com.example.weatheranalyzer.modul.answer.AverageDailyTemperatureModul;
import com.example.weatheranalyzer.modul.answer.Weather;

public interface WeatherService {

    Weather getCurrentWeather();

    AverageDailyTemperatureModul getAverageDailyTemperature();

    AverageDailyTemperatureModul getAverageDailyTemperatureBetweenDates(DateFormat dateIntervalDto);
}

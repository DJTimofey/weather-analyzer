package com.example.weatheranalyzer.controller;



import com.example.weatheranalyzer.modul.request.DateFormat;
import com.example.weatheranalyzer.modul.answer.AverageDailyTemperatureModul;
import com.example.weatheranalyzer.modul.answer.Weather;
import com.example.weatheranalyzer.service.WeatherService;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<Weather> getCurrentWeather() {
        return new ResponseEntity<>(weatherService.getCurrentWeather(), HttpStatus.OK);
    }

    @GetMapping("/temperature")
    public ResponseEntity<AverageDailyTemperatureModul> getAverageDailyTemperature(
            @Valid @RequestBody(required = false)
            DateFormat dateFormat) {
        if (dateFormat == null){
            return new ResponseEntity<>(
                    weatherService.getAverageDailyTemperature(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    weatherService.getAverageDailyTemperatureBetweenDates(dateFormat), HttpStatus.OK);
        }
    }
}
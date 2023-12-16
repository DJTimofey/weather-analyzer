package com.example.weatheranalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan({"com.example.weatheranalyzer.entity"})
public class WeatherAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherAnalyzerApplication.class, args);
	}
}

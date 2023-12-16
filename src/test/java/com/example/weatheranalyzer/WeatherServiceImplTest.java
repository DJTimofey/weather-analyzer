package com.example.weatheranalyzer;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.weatheranalyzer.modul.answer.AverageDailyTemperatureModul;
import com.example.weatheranalyzer.modul.answer.Weather;
import com.example.weatheranalyzer.entity.WeatherData;
import com.example.weatheranalyzer.repository.WeatherRepository;
import com.example.weatheranalyzer.service.WeatherServiceImpl;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class WeatherServiceImplTest {

	@Mock
	private WeatherRepository weatherRepository;

	@InjectMocks
	private WeatherServiceImpl weatherService;

	@Test
	public void testGetCurrentWeather() {
		WeatherData weatherData = WeatherData.builder()
				.location("Minsk").temperature(6).windMetersPerHour(10000.0).pressureMB(1013.0).humidity(65.0).weatherCondition("Sunny")
				.createdAt(Instant.now())
				.build();

		Mockito.when(weatherRepository.findFirstByOrderByCreatedAtDesc())
				.thenReturn(Optional.of(weatherData));

		Weather expected =
				new Weather("Minsk", 6, 10000.0, 1013.0, 65.0, "Sunny");
		Weather actual = weatherService.getCurrentWeather();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetAverageDailyTemperature() {
		Instant now = Instant.now();

		WeatherData weatherData1 = WeatherData.builder().location("Minsk").temperature(6).windMetersPerHour(9000.0)
				.pressureMB(1017.0).humidity(66.0).weatherCondition("Sunny").createdAt( now.minus(Duration.ofDays(1)))
				.build();

		WeatherData weatherData2 = WeatherData.builder().location("Minsk").temperature(8).windMetersPerHour(6000.0)
				.pressureMB(1009.0).humidity(69.0).weatherCondition("Cloudy").createdAt(now)
				.build();

		Mockito.when(weatherRepository.findByCreatedAtBetween(Mockito.any(Instant.class),
				Mockito.any(Instant.class))).thenReturn(Arrays.asList(weatherData1, weatherData2));

		AverageDailyTemperatureModul expected = new AverageDailyTemperatureModul(7);
		AverageDailyTemperatureModul actual = weatherService.getAverageDailyTemperature();

		assertEquals(expected, actual);
	}

}

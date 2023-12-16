package com.example.weatheranalyzer.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.weatheranalyzer.entity.WeatherData;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Integer> {

    Optional<WeatherData> findFirstByOrderByCreatedAtDesc();

    List<WeatherData> findByCreatedAtBetween(Instant startDate, Instant endDate);

}

package com.hakcu.shootingstars;

import com.hakcu.shootingstars.records.CityWeather;
import com.hakcu.shootingstars.records.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@SpringBootApplication
@RestController
public class ShootingstarsApplication {
    @Value("${application.apiKey}")
    private String apiKey;
    @Value("${application.locale")
    private String locale;

    public static void main(String[] args) {
        SpringApplication.run(ShootingstarsApplication.class, args);

    }

    @GetMapping("/weather")
    public CityWeather cityWeatherProvider(@RequestParam(value = "city", defaultValue = "Barcelona") String city,
                                           @RequestParam(value = "date", defaultValue = "") String date) {
        CityWeatherAPI cityWeatherAPI = new WeatherAPI(new RestTemplate(), apiKey, locale);
        String finalDate = date.isEmpty() ? LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : date;
        WeatherResponse weatherResponse = cityWeatherAPI.getWeatherFromCity(city);
        boolean isVisible = weatherResponse.current().cloud() == 0;
        return new CityWeather(finalDate, city, isVisible, weatherResponse.current().cloud());
    }
}

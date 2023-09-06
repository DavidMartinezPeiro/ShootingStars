package com.hakcu.shootingstars;

import com.hakcu.shootingstars.records.WeatherResponse;
import org.springframework.web.client.RestTemplate;

public class WeatherAPI implements CityWeatherAPI {
    //TODO Read application.properties fields from other classes
    /*@Value("${application.apiKey}")
    private String apiKey;
    private final String apiKey = "ba97ef44267b4152bef140747230409";*/
    /*@Value("${application.locale")
    private String locale;
    private final String locale = "es";*/
    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String locale;

    WeatherAPI(RestTemplate restTemplate, String apiKey, String locale) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.locale = locale;
    }

    @Override
    public WeatherResponse getWeatherFromCity(String city) {
        String uri = "https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city + "&lang=" + locale;
        return restTemplate.getForObject(uri, WeatherResponse.class);
    }
}

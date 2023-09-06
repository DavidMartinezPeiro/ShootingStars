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
    public CityWeather cityWeather(@RequestParam(value = "city", defaultValue = "Barcelona") String city
            /*,@RequestParam(value = "date", defaultValue = "") String date*/) throws Exception {
        //String finalDate = date.isEmpty() ? LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : date;
        WeatherResponse wr = getWeatherFromCity(city);
        boolean isVisible = wr.current().cloud() == 0;
        return new CityWeather(/*finalDate,*/ city, isVisible, wr.current().cloud());

    }

    public WeatherResponse getWeatherFromCity(String city) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city + "&lang=" + locale;
        return restTemplate.getForObject(uri, WeatherResponse.class);
    }


}

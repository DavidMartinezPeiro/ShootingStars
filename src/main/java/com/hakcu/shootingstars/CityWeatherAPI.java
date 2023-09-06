package com.hakcu.shootingstars;

import com.hakcu.shootingstars.records.WeatherResponse;



public interface CityWeatherAPI {
    WeatherResponse getWeatherFromCity(String city);
}

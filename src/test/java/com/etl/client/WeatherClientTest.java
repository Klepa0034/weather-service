package com.etl.client;

import com.etl.dto.GeneralWeather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherClientTest {
    @Autowired
    private WeatherClient weatherClient;

    @Test
    void getWeatherTest() {
        String startDate = "2025-05-16";
        String endDate = "2025-05-30";
        String[] hourlyParams = {
                "temperature_2m", "relative_humidity_2m", "dew_point_2m",
                "apparent_temperature", "temperature_80m", "temperature_120m",
                "wind_speed_10m", "wind_speed_80m", "wind_direction_10m",
                "wind_direction_80m", "visibility", "evapotranspiration",
                "weather_code", "soil_temperature_0cm", "soil_temperature_6cm",
                "rain", "showers", "snowfall"
        };

        GeneralWeather weather = weatherClient.getWeather(
                55.0344,
                82.9434,
                new String[]{"sunrise", "sunset", "daylight_duration"},
                hourlyParams,
                "auto",
                "unixtime",
                "kn",
                "fahrenheit",
                "inch",
                startDate,
                endDate
        );

        System.out.print(weather);
    }

}

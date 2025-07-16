package com.example.demo.entity;

import com.example.demo.dto.HourlyUnits;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static net.bytebuddy.matcher.ElementMatchers.returns;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;

@SpringBootTest
class HourlyUnitsTest {
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @SneakyThrows
    @DisplayName("Сущность HourlyUnits конвертируется в json успешно")
    public void jsonToEntityTest(){
        String json=("""
                {
                    "time": "unixtime",
                    "temperature_2m": "°F",
                    "relative_humidity_2m": "%",
                    "dew_point_2m": "°F",
                    "apparent_temperature": "°F",
                    "temperature_80m": "°F",
                    "temperature_120m": "°F",
                    "wind_speed_10m": "kn",
                    "wind_speed_80m": "kn",
                    "wind_direction_10m": "°",
                    "wind_direction_80m": "°",
                    "visibility": "ft",
                    "evapotranspiration": "inch",
                    "weather_code": "wmo code",
                    "soil_temperature_0cm": "°F",
                    "soil_temperature_6cm": "°F",
                    "rain": "inch",
                    "showers": "inch",
                    "snowfall": "inch"
                  }
                """);

        HourlyUnits hourlyUnits = objectMapper.readValue(json, HourlyUnits.class);

        assertThat(hourlyUnits)
                .returns("unixtime",from(HourlyUnits::getTime))
                .returns("°F",from(HourlyUnits::getTemperatureTwoM))
                .returns("%",from(HourlyUnits::getRelativeHumidityTwoM))
                .returns("°F",from(HourlyUnits::getDewPointTwoM))
                .returns("°F",from(HourlyUnits::getApparentTemperature))
                .returns("°F",from(HourlyUnits::getTemperatureEightyM))
                .returns("°F",from(HourlyUnits::getTemperatureOneHundredAndTwentyM))
                .returns("°",from(HourlyUnits::getWindDirectionTenM))
                .returns("°F",from(HourlyUnits::getTemperatureEightyM))
                .returns("°",from(HourlyUnits::getWindDirectionTenM))
                .returns("kn",from(HourlyUnits::getWindSpeedEightyM))
                .returns("ft",from(HourlyUnits::getVisibility))
                .returns("inch",from(HourlyUnits::getEvapotranspiration))
                .returns("wmo code",from(HourlyUnits::getWeatherCode))
                .returns("°F",from(HourlyUnits::getSoilTemperatureZeroCm))
                .returns("°F",from(HourlyUnits::getSoilTemperatureSixCm))
                .returns("inch",from(HourlyUnits::getRain))
                .returns("inch",from(HourlyUnits::getShowers))
                .returns("inch",from(HourlyUnits::getSnowfall));
    }

}
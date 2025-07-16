package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HourlyUnits {
    @JsonAlias("time")
    private String time;
    @JsonAlias("temperature_2m")
    private String temperatureTwoM;
    @JsonAlias("relative_humidity_2m")
    private String relativeHumidityTwoM;
    @JsonAlias("dew_point_2m")
    private String dewPointTwoM;
    @JsonAlias("apparent_temperature")
    private String apparentTemperature;
    @JsonAlias("temperature_80m")
    private String temperatureEightyM;
    @JsonAlias("temperature_120m")
    private String temperatureOneHundredAndTwentyM;
    @JsonAlias("wind_speed_10m")
    private String windSpeedTenM;
    @JsonAlias("wind_speed_80m")
    private String windSpeedEightyM;
    @JsonAlias("wind_direction_10m")
    private String windDirectionTenM;
    @JsonAlias("wind_direction_80m")
    private String windDirectionEightyM;
    @JsonAlias("visibility")
    private String visibility;
    @JsonAlias("evapotranspiration")
    private String evapotranspiration;
    @JsonAlias("weather_code")
    private String weatherCode;
    @JsonAlias("soil_temperature_0cm")
    private String soilTemperatureZeroCm;
    @JsonAlias("soil_temperature_6cm")
    private String soilTemperatureSixCm;
    @JsonAlias("rain")
    private String rain;
    @JsonAlias("showers")
    private String showers;
    @JsonAlias("snowfall")
    private String snowfall;
}

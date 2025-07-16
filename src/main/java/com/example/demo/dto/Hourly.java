package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Hourly {
    @JsonAlias("time")
    private long[] time;
    @JsonAlias("temperature_2m")
    private double[] temperatureTwoM;
    @JsonAlias("relative_humidity_2m")
    private double[] relativeHumidityTwoM;
    @JsonAlias("dew_point_2m")
    private double[] dewPointTwoM;
    @JsonAlias("apparent_temperature")
    private double[] apparentTemperature;
    @JsonAlias("temperature_80m")
    private double[] temperatureEightyM;
    @JsonAlias("temperature_120m")
    private double[] temperatureOneHundredAndTwenty;
    @JsonAlias("wind_speed_10m")
    private double[] windSpeedTenM;
    @JsonAlias("wind_speed_80m")
    private double[] windSpeedEightyM;
    @JsonAlias("wind_direction_10m")
    private double[] windDirectionTenM;
    @JsonAlias("wind_direction_80m")
    private double[] windDirectionEightyM;
    @JsonAlias("visibility")
    private double[] visibility;
    @JsonAlias("evapotranspiration")
    private double[] evapotranspiration;
    @JsonAlias("weather_code")
    private double[] weatherCode;
    @JsonAlias("soil_temperature_0cm")
    private double[] soilTemperatureZeroCm;
    @JsonAlias("soil_temperature_6cm")
    private double[] soilTemperatureSixCm;
    @JsonAlias("rain")
    private double[] rain;
    @JsonAlias("showers")
    private double[] showers;
    @JsonAlias("snowfall")
    private double[] snowfall;
}

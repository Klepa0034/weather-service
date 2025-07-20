package com.example.etl.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.util.List;
/**
 * Represents hourly weather forecast data containing time-series measurements
 * for various atmospheric and surface parameters. All time values are in Unix timestamp format.
 *
 * <p>This class maps to the hourly data structure in weather API responses,
 * providing detailed meteorological observations at hourly intervals.</p>
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Hourly {
    /**
     * List of timestamps in Unix time (seconds since epoch) for each hourly observation
     */
    @JsonAlias("time")
    private List<Long> time;

    /**
     * Air temperature at 2 meters above ground in °C
     */
    @JsonAlias("temperature_2m")
    private List<Double> temperatureTwoM;

    /**
     * Relative humidity at 2 meters above ground in %
     */
    @JsonAlias("relative_humidity_2m")
    private List<Integer> relativeHumidityTwoM;

    /**
     * Dew point temperature at 2 meters above ground in °C
     */
    @JsonAlias("dew_point_2m")
    private List<Double> dewPointTwoM;

    /**
     * Apparent temperature (heat index/wind chill) in °C
     */
    @JsonAlias("apparent_temperature")
    private List<Double> apparentTemperature;

    /**
     * Air temperature at 80 meters above ground in °C (for wind energy applications)
     */
    @JsonAlias("temperature_80m")
    private List<Double> temperatureEightyM;

    /**
     * Air temperature at 120 meters above ground in °C (for wind energy applications)
     */
    @JsonAlias("temperature_120m")
    private List<Double> temperatureOneHundredAndTwenty;

    /**
     * Wind speed at 10 meters above ground in km/h
     */
    @JsonAlias("wind_speed_10m")
    private List<Double> windSpeedTenM;

    /**
     * Wind speed at 80 meters above ground in km/h (for wind energy applications)
     */
    @JsonAlias("wind_speed_80m")
    private List<Double> windSpeedEightyM;

    /**
     * Wind direction at 10 meters above ground in degrees (0-360)
     */
    @JsonAlias("wind_direction_10m")
    private List<Integer> windDirectionTenM;

    /**
     * Wind direction at 80 meters above ground in degrees (0-360)
     */
    @JsonAlias("wind_direction_80m")
    private List<Integer> windDirectionEightyM;

    /**
     * Horizontal visibility in km
     */
    @JsonAlias("visibility")
    private List<Double> visibility;

    /**
     * Evapotranspiration rate in mm/h
     */
    @JsonAlias("evapotranspiration")
    private List<Double> evapotranspiration;

    /**
     * WMO weather code describing current conditions
     * @see <a href="https://www.nodc.noaa.gov/archive/arc0021/0002199/1.1/data/0-data/HTML/WMO-CODE/WMO4677.HTM">WMO code definitions</a>
     */
    @JsonAlias("weather_code")
    private List<Integer> weatherCode;

    /**
     * Soil temperature at 0cm depth in °C
     */
    @JsonAlias("soil_temperature_0cm")
    private List<Double> soilTemperatureZeroCm;

    /**
     * Soil temperature at 6cm depth in °C
     */
    @JsonAlias("soil_temperature_6cm")
    private List<Double> soilTemperatureSixCm;

    /**
     * Rainfall amount in mm
     */
    @JsonAlias("rain")
    private List<Double> rain;

    /**
     * Showers precipitation amount in mm
     */
    @JsonAlias("showers")
    private List<Double> showers;

    /**
     * Snowfall amount in cm
     */
    @JsonAlias("snowfall")
    private List<Integer> snowfall;
}


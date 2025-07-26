package com.etl.dto.service;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
/**
 * Data Transfer Object containing hourly weather measurements.
 * <p>
 * Represents time-series weather data with measurements recorded at hourly intervals.
 * All lists maintain consistent ordering where index positions correspond to the same observation time.
 */
public class HourlyDto {

    /**
     * Timestamps for each hourly observation
     * (Unix epoch seconds in UTC)
     */
    private List<Long> time;

    /**
     * Hourly temperature at 2 meters height
     * (in degrees Celsius, °C)
     */
    private List<Double> temperatureTwoM;

    /**
     * Hourly relative humidity at 2 meters height
     * (in percent, %)
     */
    private List<Integer> relativeHumidityTwoM;

    /**
     * Hourly dew point temperature at 2 meters height
     * (in degrees Celsius, °C)
     */
    private List<Double> dewPointTwoM;

    /**
     * Hourly apparent (feels-like) temperature
     * (in degrees Celsius, °C)
     */
    private List<Double> apparentTemperature;

    /**
     * Hourly temperature at 80 meters height
     * (in degrees Celsius, °C)
     */
    private List<Double> temperatureEightyM;

    /**
     * Hourly temperature at 120 meters height
     * (in degrees Celsius, °C)
     */
    private List<Double> temperatureOneHundredAndTwenty;

    /**
     * Hourly wind speed at 10 meters height
     * (in meters per second, m/s)
     */
    private List<Double> windSpeedTenM;

    /**
     * Hourly wind speed at 80 meters height
     * (in meters per second, m/s)
     */
    private List<Double> windSpeedEightyM;

    /**
     * Hourly wind direction at 10 meters height
     * (in degrees, 0-360 where 0° is north)
     */
    private List<Integer> windDirectionTenM;

    /**
     * Hourly wind direction at 80 meters height
     * (in degrees, 0-360 where 0° is north)
     */
    private List<Integer> windDirectionEightyM;

    /**
     * Hourly visibility distance
     * (in meters, m)
     */
    private List<Double> visibility;

    /**
     * Hourly evapotranspiration rate
     * (in millimeters, mm)
     */
    private List<Double> evapotranspiration;

    /**
     * Hourly weather condition codes
     * (see WMO weather code classification)
     */
    private List<Integer> weatherCode;

    /**
     * Hourly soil temperature at 0 cm depth
     * (in degrees Celsius, °C)
     */
    private List<Double> soilTemperatureZeroCm;

    /**
     * Hourly soil temperature at 6 cm depth
     * (in degrees Celsius, °C)
     */
    private List<Double> soilTemperatureSixCm;

    /**
     * Hourly rainfall amount
     * (in millimeters, mm)
     */
    private List<Double> rain;

    /**
     * Hourly shower precipitation amount
     * (in millimeters, mm)
     */
    private List<Double> showers;

    /**
     * Hourly snowfall amount
     * (in centimeters, cm)
     */
    private List<Integer> snowfall;
}

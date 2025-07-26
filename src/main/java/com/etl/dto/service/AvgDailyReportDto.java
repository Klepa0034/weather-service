package com.etl.dto.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Data Transfer Object containing aggregated daily weather metrics.
 * <p>
 * Represents 24-hour average and total values for various weather parameters.
 * All measurements follow standard meteorological units unless otherwise noted.
 */
public class AvgDailyReportDto {

    /**
     * 24-hour average temperature at 2 meters above ground
     * (in degrees Celsius, °C)
     */
    private Double avgTemperatureTwoMTwentyFourH;

    /**
     * 24-hour average temperature at 120 meters above ground
     * (in degrees Celsius, °C)
     */
    private Double avgTemperatureOneHundredAndTwentyMTwentyFourH;

    /**
     * 24-hour average temperature at 80 meters above ground
     * (in degrees Celsius, °C)
     */
    private Double avgTemperatureEightyMDTwentyFourH;

    /**
     * 24-hour average dew point temperature at 2 meters
     * (in degrees Celsius, °C)
     */
    private Double avgDewPointTwoMTwentyFourH;

    /**
     * 24-hour average relative humidity at 2 meters
     * (in percent, %)
     */
    private Integer avgRelativeHumidityTwoMDTwentyFourH;

    /**
     * 24-hour average wind speed at 10 meters height
     * (in meters per second, m/s)
     */
    private Double avgWindSpeedTenMTwentyFourH;

    /**
     * 24-hour average wind speed at 80 meters height
     * (in meters per second, m/s)
     */
    private Double avgWindSpeedEightyMTwentyFourH;

    /**
     * 24-hour average visibility
     * (in meters, m)
     */
    private Double avgVisibilityTwentyFourH;

    /**
     * Total rainfall accumulation over 24 hours
     * (in millimeters, mm)
     */
    private Double totalRainTwentyFourH;

    /**
     * Total shower precipitation over 24 hours
     * (in millimeters, mm)
     */
    private Double totalShowersTwentyFourH;

    /**
     * Total snowfall accumulation over 24 hours
     * (in centimeters, cm)
     */
    private Double totalSnowfallTwentyFourH;

    /**
     * 24-hour average apparent (feels-like) temperature at 2 meters
     * (in degrees Celsius, °C)
     */
    private Double avgApparentTemperatureTwentyFourH;

    /**
     * Current rain precipitation rate
     * (in millimeters per hour, mm/h)
     */
    private Double rain;

    /**
     * Current shower precipitation rate
     * (in millimeters per hour, mm/h)
     */
    private Double showers;

    /**
     * Current snowfall accumulation
     * (in centimeters, cm)
     */
    private Integer snowfall;
}

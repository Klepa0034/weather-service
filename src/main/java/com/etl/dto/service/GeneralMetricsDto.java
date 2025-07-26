package com.etl.dto.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Data Transfer Object containing general weather metrics with per-second measurements.
 * <p>
 * Combines time-related events (sunrise/sunset) with per-second rate measurements
 * of various weather parameters. ISO timestamps follow ISO 8601 format.
 */
public class GeneralMetricsDto {

    /**
     * Sunset time in ISO 8601 format (UTC)
     */
    private String sunsetIso;

    /**
     * Sunrise time in ISO 8601 format (UTC)
     */
    private String sunriseIso;

    /**
     * Instantaneous temperature at 2 meters height
     * (in degrees Celsius per second, °C/s)
     */
    private Double temperatureTwoMPerS;

    /**
     * Instantaneous temperature at 80 meters height
     * (in degrees Celsius per second, °C/s)
     */
    private Double temperatureEightyMPerS;

    /**
     * Instantaneous temperature at 120 meters height
     * (in degrees Celsius per second, °C/s)
     */
    private Double temperatureOneHundredAndTwentyPerS;

    /**
     * Instantaneous apparent (feels-like) temperature
     * (in degrees Celsius per second, °C/s)
     */
    private Double apparentTemperatureMPerS;

    /**
     * Instantaneous wind speed at 10 meters height
     * (in meters per second squared, m/s²)
     */
    private Double windSpeedTenMPerS;

    /**
     * Instantaneous wind speed at 80 meters height
     * (in meters per second squared, m/s²)
     */
    private Double windSpeedEightyMPerS;

    /**
     * Instantaneous soil temperature at 0 cm depth
     * (in degrees Celsius per second, °C/s)
     */
    private Double soilTemperatureZeroCmPerS;

    /**
     * Instantaneous soil temperature at 6 cm depth
     * (in degrees Celsius per second, °C/s)
     */
    private Double soilTemperatureSixCmPerS;

    /**
     * Instantaneous rain precipitation rate
     * (in millimeters per second, mm/s)
     */
    private Double rainMmPerS;

    /**
     * Instantaneous shower precipitation rate
     * (in millimeters per second, mm/s)
     */
    private Double showerMmPerS;

    /**
     * Instantaneous snowfall rate
     * (in millimeters per second, mm/s)
     */
    private Double snowfallMmPerS;

    /**
     * Duration of daylight
     * (in hours)
     */
    private Double daylightHours;

    /**
     * Daily sunset time in ISO 8601 format (UTC)
     */
    private String sunsetIsoD;

    /**
     * Daily sunrise time in ISO 8601 format (UTC)
     */
    private String sunriseIsoD;
}

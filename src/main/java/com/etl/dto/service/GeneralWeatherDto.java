package com.etl.dto.service;

import lombok.Getter;
import lombok.Setter;

import java.util.TimeZone;

@Getter
@Setter
/**
 * Data Transfer Object containing comprehensive weather data for a specific location.
 * <p>
 * Represents the complete weather observation including geographic information,
 * timezone details, and both daily and hourly weather measurements with their units.
 */
public class GeneralWeatherDto {

    /**
     * Latitude coordinate of the location
     * (in decimal degrees)
     */
    private int latitude;

    /**
     * Longitude coordinate of the location
     * (in decimal degrees)
     */
    private int longitude;

    /**
     * Data generation processing time
     * (in milliseconds)
     */
    private Double generationTimeMs;

    /**
     * UTC offset from local time
     * (in seconds)
     */
    private Long utcOffsetSeconds;

    /**
     * Timezone information object
     */
    private TimeZone timezone;

    /**
     * Abbreviated timezone identifier
     * (e.g., "PST", "EST")
     */
    private String timezoneAbbreviation;

    /**
     * Elevation above sea level
     * (in meters)
     */
    private int elevation;

    /**
     * Container for daily weather measurements
     *
     * @see DailyDto
     */
    private DailyDto dailyDto;

    /**
     * Units for daily weather measurements
     *
     * @see DailyUnitsDto
     */
    private DailyUnitsDto dailyUnitsDto;

    /**
     * Container for hourly weather measurements
     *
     * @see HourlyDto
     */
    private HourlyDto hourlyDto;

    /**
     * Units for hourly weather measurements
     *
     * @see HourlyUnitsDto
     */
    private HourlyUnitsDto hourlyUnitsDto;
}

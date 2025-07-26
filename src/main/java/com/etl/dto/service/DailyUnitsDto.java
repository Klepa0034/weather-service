package com.etl.dto.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Data Transfer Object containing unit information for daily weather measurements.
 * <p>
 * Specifies the measurement units used in corresponding {@link DailyDto} fields.
 * All unit strings should follow standardized meteorological conventions.
 */
public class DailyUnitsDto {

    /**
     * Unit of measurement for time fields
     * (typically "unixtime" or "ISO8601")
     */
    private String time;

    /**
     * Unit of measurement for sunrise times
     * (typically "unixtime" or "ISO8601")
     */
    private String sunrise;

    /**
     * Unit of measurement for sunset times
     * (typically "unixtime" or "ISO8601")
     */
    private String sunset;

    /**
     * Unit of measurement for daylight duration
     * (typically "hours" or "seconds")
     */
    private String daylightDuration;
}
package com.etl.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.util.TimeZone;

/**
 * Represents the complete weather data response from a weather API.
 * Contains geographic information, timezone data, and both daily and hourly weather forecasts
 * with their respective units of measurement.
 *
 * <p>This class serves as the root object for weather API responses, combining location metadata
 * with actual weather measurements and their units.</p>
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GeneralWeather {
    /**
     * Geographic latitude in decimal degrees (-90 to +90)
     */
    @JsonAlias("latitude")
    private int latitude;

    /**
     * Geographic longitude in decimal degrees (-180 to +180)
     */
    @JsonAlias("longitude")
    private int longitude;

    /**
     * Time taken to generate the response in milliseconds
     */
    @JsonAlias("generationtime_ms")
    private Double generationTimeMs;

    /**
     * UTC offset in seconds for the requested location
     */
    @JsonAlias("utc_offset_seconds")
    private Long utcOffsetSeconds;

    /**
     * Timezone information for the requested location
     */
    @JsonAlias("timezone")
    private TimeZone timezone;

    /**
     * Abbreviated timezone identifier (e.g., "PST", "CET")
     */
    @JsonAlias("timezone_abbreviation")
    private String timezoneAbbreviation;

    /**
     * Elevation above sea level in meters
     */
    @JsonAlias("elevation")
    private int elevation;

    /**
     * Container for daily weather forecast data
     * @see Daily
     */
    @JsonAlias("daily")
    private Daily daily;

    /**
     * Units of measurement for daily forecast data
     * @see DailyUnits
     */
    @JsonAlias("daily_units")
    private DailyUnits dailyUnits;

    /**
     * Container for hourly weather forecast data
     * @see Hourly
     */
    @JsonAlias("hourly")
    private Hourly hourly;

    /**
     * Units of measurement for hourly forecast data
     * @see HourlyUnits
     */
    @JsonAlias("hourly_units")
    private HourlyUnits hourlyUnits;
}
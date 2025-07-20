package com.etl.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

/**
 * Represents the units of measurement for daily weather data fields.
 * Contains metadata about the units used in corresponding {@link Daily} data fields.
 * Typically used alongside weather API responses to provide unit information.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DailyUnits {
    /**
     * Measurement unit for time values (typically "iso8601" or "unixtime")
     */
    @JsonAlias("time")
    private String time;

    /**
     * Measurement unit for sunrise times (typically "iso8601" or "unixtime")
     */
    @JsonAlias("sunrise")
    private String sunrise;

    /**
     * Measurement unit for sunset times (typically "iso8601" or "unixtime")
     */
    @JsonAlias("sunset")
    private String sunset;

    /**
     * Measurement unit for daylight duration (typically "seconds")
     */
    @JsonAlias("daylight_duration")
    private String daylightDuration;
}

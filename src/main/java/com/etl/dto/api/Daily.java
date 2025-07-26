package com.etl.dto.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * Represents daily weather data elements from a weather API response.
 * Contains time-series data for daily weather metrics including sunrise, sunset,
 * and daylight duration information.
 *
 * <p>Uses Jackson annotations for flexible JSON property mapping.</p>
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Daily {
    /**
     * List of timestamps representing the days in Unix time format (seconds since epoch)
     */
    @JsonAlias("time")
    private List<Long> time;

    /**
     * List of sunrise times in Unix time format (seconds since epoch)
     */
    @JsonAlias("sunrise")
    private List<Long> sunrise;

    /**
     * List of sunset times in Unix time format (seconds since epoch)
     */
    @JsonProperty("sunset")
    private List<Long> sunset;

    /**
     * List of daylight duration values in seconds for each day
     */
    @JsonProperty("daylight_duration")
    private List<Double> daylightDuration;
}

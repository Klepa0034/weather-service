package com.etl.dto.service;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
/**
 * Data Transfer Object containing daily weather time-related parameters.
 * <p>
 * Represents timestamps and durations for daily weather events.
 * All time values are in Unix epoch seconds unless otherwise specified.
 */
public class DailyDto {

    /**
     * List of daily timestamps (Unix epoch seconds)
     * representing the reference time for each day
     */
    private List<Long> time;

    /**
     * List of sunrise times for each day
     * (Unix epoch seconds in UTC)
     */
    private List<Long> sunrise;

    /**
     * List of sunset times for each day
     * (Unix epoch seconds in UTC)
     */
    private List<Long> sunset;

    /**
     * List of daylight durations for each day
     * (in hours)
     */
    private List<Double> daylightDuration;
}

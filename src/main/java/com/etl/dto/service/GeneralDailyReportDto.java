package com.etl.dto.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Data Transfer Object containing comprehensive daily precipitation metrics.
 * <p>
 * Includes both 24-hour totals and daylight-specific precipitation measurements.
 * All measurements follow standard meteorological units unless otherwise noted.
 */
public class GeneralDailyReportDto {

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
    private Integer totalSnowfallTwentyFourH;

    /**
     * Total rainfall during daylight hours only
     * (in millimeters, mm)
     */
    private Double totalRainDailyLight;

    /**
     * Total shower precipitation during daylight hours only
     * (in millimeters, mm)
     */
    private Double totalShowersDailyLight;

    /**
     * Total snowfall during daylight hours only
     * (in centimeters, cm)
     */
    private Integer totalSnowfallDailyLight;

    /**
     * Current rain precipitation rate
     * (in millimeters per hour, mm/h)
     */
    private Double rain;

    /**
     * Current snowfall accumulation
     * (in centimeters, cm)
     */
    private Double snowfall;

    /**
     * Alternative representation of 24-hour snowfall total
     * (in centimeters, cm)
     */
    private Double snowfallTwentyFourH;
}

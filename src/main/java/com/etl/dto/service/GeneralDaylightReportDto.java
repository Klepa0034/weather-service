package com.etl.dto.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Data Transfer Object containing daylight-specific precipitation totals.
 * <p>
 * Stores aggregated precipitation measurements specifically for daylight hours.
 * Values are stored as Strings to preserve formatting and units from source data.
 */
public class GeneralDaylightReportDto {

    /**
     * Total rainfall during daylight hours
     * (formatted String with units, typically "mm")
     */
    private String totalRainDaylight;

    /**
     * Total shower precipitation during daylight hours
     * (formatted String with units, typically "mm")
     */
    private String totalShowersDaylight;

    /**
     * Total snowfall during daylight hours
     * (formatted String with units, typically "cm")
     */
    private String totalSnowfallDaylight;
}

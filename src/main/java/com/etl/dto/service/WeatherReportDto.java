package com.etl.dto.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
/**
 * Data Transfer Object representing a complete weather report.
 * <p>
 * Aggregates all weather data components including daily averages, daylight-specific metrics,
 * and general measurements. Serves as the main container for processed weather information.
 */
public class WeatherReportDto {

    /**
     * Contains 24-hour average weather metrics
     *
     * @see AvgDailyReportDto
     */
    private AvgDailyReportDto avgDailyReport;

    /**
     * Contains comprehensive daily precipitation and weather measurements
     *
     * @see GeneralDailyReportDto
     */
    private GeneralDailyReportDto generalDailyReport;

    /**
     * Contains daylight-specific average weather metrics
     *
     * @see AvgDaylightReportDto
     */
    private AvgDaylightReportDto avgDaylightReport;

    /**
     * Contains daylight-specific precipitation totals
     *
     * @see GeneralDaylightReportDto
     */
    private GeneralDaylightReportDto generalDaylightReport;

    /**
     * Contains general weather metrics with per-second measurements
     *
     * @see GeneralMetricsDto
     */
    private GeneralMetricsDto generalMetrics;
}

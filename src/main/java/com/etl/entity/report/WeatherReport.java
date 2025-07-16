package com.etl.entity.report;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Comprehensive weather report container class that aggregates all weather data components.
 *
 * <p>This class serves as the main container for different types of weather reports,
 * combining daily averages, daylight-specific measurements, and general metrics into
 * a single unified structure.</p>
 *
 * <p>Contains the following report types:
 * <ul>
 *   <li>{@link AvgDailyReport} - 24-hour average values</li>
 *   <li>{@link GeneralDailyReport} - Daily precipitation totals</li>
 *   <li>{@link AvgDaylightReport} - Daylight hour averages</li>
 *   <li>{@link GeneralDaylightReport} - Daylight precipitation totals</li>
 *   <li>{@link GeneralMetrics} - Current weather observations</li>
 * </ul>
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
public class WeatherReport {
    /**
     * Contains 24-hour average weather measurements
     */
    private AvgDailyReport avgDailyReport;

    /**
     * Contains total daily precipitation measurements
     */
    private GeneralDailyReport generalDailyReport;

    /**
     * Contains weather averages specifically for daylight hours
     */
    private AvgDaylightReport avgDaylightReport;

    /**
     * Contains precipitation totals specifically for daylight hours
     */
    private GeneralDaylightReport generalDaylightReport;

    /**
     * Contains current weather observations and metrics
     */
    private GeneralMetrics generalMetrics;
}
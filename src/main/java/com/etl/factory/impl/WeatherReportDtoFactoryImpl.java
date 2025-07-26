package com.etl.factory.impl;

import com.etl.dto.service.*;
import com.etl.factory.WeatherReportDtoFactory;
import org.springframework.stereotype.Component;

/**
 * Factory implementation for creating new {@link WeatherReportDto} instances with default sub-DTOs.
 * <p>
 * Constructs a complete weather report data transfer object with all necessary child DTOs initialized.
 * Each created instance contains fresh sub-DTOs for:
 * <ul>
 *   <li>Daylight reports ({@link GeneralDaylightReportDto})</li>
 *   <li>Daily averages ({@link AvgDailyReportDto})</li>
 *   <li>Daylight averages ({@link AvgDaylightReportDto})</li>
 *   <li>General metrics ({@link GeneralMetricsDto})</li>
 *   <li>Daily reports ({@link GeneralDailyReportDto})</li>
 * </ul>
 */

@Component
public class WeatherReportDtoFactoryImpl implements WeatherReportDtoFactory {

    @Override
    public WeatherReportDto create() {

        return WeatherReportDto
                .builder()
                .generalDaylightReport(new GeneralDaylightReportDto())
                .avgDailyReport(new AvgDailyReportDto())
                .avgDaylightReport(new AvgDaylightReportDto())
                .generalMetrics(new GeneralMetricsDto())
                .generalDailyReport(new GeneralDailyReportDto())
                .build();
    }
}

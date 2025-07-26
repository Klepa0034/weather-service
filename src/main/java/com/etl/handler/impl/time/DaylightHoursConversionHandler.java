package com.etl.handler.impl.time;

import com.etl.dto.service.GeneralMetricsDto;
import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;
import com.etl.handler.ConversionHandler;
import com.etl.settings.NumericUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Handler for processing and converting daylight duration data into daily average values.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average daily daylight duration in hours. The calculation provides important
 * information for solar energy applications, agricultural planning, and ecological studies.
 */
@Component
@RequiredArgsConstructor
public class DaylightHoursConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing time duration calculations and conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes daily daylight duration data and calculates the average duration in hours.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves daily daylight duration measurements in hours</li>
     *   <li>Calculates the average daylight duration</li>
     *   <li>Stores the result in the general metrics report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the daylight duration list is empty or contains negative values
     * @see NumericUtils#calculateValueHours(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> daylightDuration = generalWeatherDto.getDailyDto().getDaylightDuration();
        GeneralMetricsDto generalMetrics = weatherReportDto.getGeneralMetrics();
        double average = numericUtils.calculateValueHours(daylightDuration);
        generalMetrics.setDaylightHours(average);
    }
}

package com.etl.handler.impl.Instant;

import com.etl.dto.service.GeneralMetricsDto;
import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;
import com.etl.handler.ConversionHandler;
import com.etl.settings.NumericUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Handler for processing and converting wind speed data at 10 meters elevation
 * into instantaneous metric values.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average wind speed in meters per second (m/s) at standard meteorological measurement
 * height (10m) above ground level. This measurement is essential for weather forecasting,
 * aviation, and marine operations.
 */
@Component
@RequiredArgsConstructor
public class HourlyWindSpeedTenMInstantConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing wind speed calculations and conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly wind speed data at 10 meters elevation and calculates
     * the average wind speed in meters per second.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly wind speed measurements at 10m height</li>
     *   <li>Calculates the average wind speed in m/s</li>
     *   <li>Stores the result in the general metrics report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the wind speed data list is empty or contains negative values
     * @see NumericUtils#calculateOverallInMetersPerSecond(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> windSpeedTenM = generalWeatherDto.getHourlyDto().getWindSpeedTenM();
        GeneralMetricsDto generalMetrics = weatherReportDto.getGeneralMetrics();
        Double average = numericUtils.calculateOverallInMetersPerSecond(windSpeedTenM);
        generalMetrics.setWindSpeedTenMPerS(average);
    }
}

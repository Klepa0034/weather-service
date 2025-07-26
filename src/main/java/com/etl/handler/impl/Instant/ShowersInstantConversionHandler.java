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
 * Handler for processing and converting shower precipitation data
 * into instantaneous metric values.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average shower precipitation amount in millimeters (mm). The calculation focuses on
 * convective shower precipitation which typically differs from steady rainfall in intensity
 * and duration.
 */
@Component
@RequiredArgsConstructor
public class ShowersInstantConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing precipitation calculations and conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly shower data and calculates the average shower precipitation.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly shower measurements in millimeters</li>
     *   <li>Calculates the average shower precipitation amount</li>
     *   <li>Stores the result in the general metrics report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the shower data list is empty or contains negative values
     * @see NumericUtils#calculateValueInMillimeters(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> showers = generalWeatherDto.getHourlyDto().getShowers();
        GeneralMetricsDto generalMetrics = weatherReportDto.getGeneralMetrics();
        double average = numericUtils.calculateValueInMillimeters(showers);
        generalMetrics.setShowerMmPerS(average);
    }
}

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
 * Handler for processing and converting snowfall data into instantaneous metric values.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average snowfall amount in millimeters (mm) water equivalent. The calculation provides
 * a standardized measure of snowfall intensity that accounts for varying snow densities.
 */
@Component
@RequiredArgsConstructor
public class SnowfallInstantConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing snowfall calculations and conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly snowfall data and calculates the average snowfall amount.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly snowfall measurements in millimeters water equivalent</li>
     *   <li>Calculates the average snowfall amount</li>
     *   <li>Stores the result in the general metrics report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the snowfall data list is empty or contains negative values
     * @see NumericUtils#calculateSnowfallValueInMillimeters(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Integer> snowfall = generalWeatherDto.getHourlyDto().getSnowfall();
        GeneralMetricsDto generalMetrics = weatherReportDto.getGeneralMetrics();
        double average = numericUtils.calculateSnowfallValueInMillimeters(snowfall);
        generalMetrics.setSnowfallMmPerS(average);
    }
}

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
 * Handler for processing and converting apparent temperature (feels-like temperature) data
 * into instantaneous metric values.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the apparent temperature in Celsius, accounting for combined effects of air temperature,
 * humidity, and wind chill on perceived warmth.
 */
@Component
@RequiredArgsConstructor
public class ApparentTemperatureInstantConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing apparent temperature calculations and conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly apparent temperature data and calculates the average
     * apparent temperature in Celsius.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly apparent temperature measurements</li>
     *   <li>Calculates the average apparent temperature in degrees Celsius</li>
     *   <li>Stores the result in the general metrics report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the apparent temperature data list is empty
     * @see NumericUtils#calculateInCelsius(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        GeneralMetricsDto generalMetrics = weatherReportDto.getGeneralMetrics();
        List<Double> apparentTemperature = generalWeatherDto.getHourlyDto().getApparentTemperature();
        double average = numericUtils.calculateInCelsius(apparentTemperature);
        generalMetrics.setApparentTemperatureMPerS(average);
    }
}

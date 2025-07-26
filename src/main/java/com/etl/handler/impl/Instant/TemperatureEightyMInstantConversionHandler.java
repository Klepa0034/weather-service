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
 * Handler for processing and converting air temperature data at 80 meters elevation
 * into instantaneous metric values.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average air temperature in Celsius at 80 meters above ground level. This measurement
 * is particularly relevant for wind energy applications, atmospheric boundary layer studies,
 * and tall structure climate analysis.
 */
@Component
@RequiredArgsConstructor
public class TemperatureEightyMInstantConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing temperature calculations and conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly temperature data at 80 meters elevation and calculates
     * the average temperature in Celsius.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly temperature measurements at 80m height</li>
     *   <li>Calculates the average temperature in degrees Celsius</li>
     *   <li>Stores the result in the general metrics report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the temperature data list is empty
     * @see NumericUtils#calculateInCelsius(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> temperatureEightyM = generalWeatherDto.getHourlyDto().getTemperatureEightyM();
        GeneralMetricsDto generalMetrics = weatherReportDto.getGeneralMetrics();
        double average = numericUtils.calculateInCelsius(temperatureEightyM);
        generalMetrics.setTemperatureEightyMPerS(average);
    }
}

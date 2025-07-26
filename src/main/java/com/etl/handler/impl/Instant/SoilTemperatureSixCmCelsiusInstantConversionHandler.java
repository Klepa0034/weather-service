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
 * Handler for processing and converting soil temperature data at 6cm depth
 * into instantaneous metric values.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average soil temperature in Celsius at 6 centimeters below the surface. This measurement
 * is critical for agricultural planning, seed germination studies, and soil ecosystem analysis.
 */
@Component
@RequiredArgsConstructor
public class SoilTemperatureSixCmCelsiusInstantConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing temperature calculations and conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly soil temperature data at 6cm depth and calculates
     * the average temperature in Celsius.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly soil temperature measurements at 6cm depth</li>
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
        GeneralMetricsDto generalMetrics = weatherReportDto.getGeneralMetrics();
        List<Double> soilTemperatureSixCm = generalWeatherDto.getHourlyDto().getSoilTemperatureSixCm();
        Double average = numericUtils.calculateInCelsius(soilTemperatureSixCm);
        generalMetrics.setSoilTemperatureSixCmPerS(average);
    }
}

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
 * Handler for processing and converting surface soil temperature data
 * into instantaneous metric values.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average soil surface temperature in Celsius (measured at 0cm depth). This measurement
 * is particularly valuable for frost detection, evaporation rate estimation, and
 * surface energy balance studies.
 */
@Component
@RequiredArgsConstructor
public class SoilTemperatureZeroCmInstantConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing temperature calculations and conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly surface soil temperature data and calculates
     * the average temperature in Celsius.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly surface soil temperature measurements</li>
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
        List<Double> soilTemperatureZeroCm = generalWeatherDto.getHourlyDto().getSoilTemperatureZeroCm();
        Double average = numericUtils.calculateInCelsius(soilTemperatureZeroCm);
        generalMetrics.setSoilTemperatureZeroCmPerS(average);
    }
}

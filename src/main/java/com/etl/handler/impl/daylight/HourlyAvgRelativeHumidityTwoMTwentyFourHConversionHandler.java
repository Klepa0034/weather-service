package com.etl.handler.impl.daylight;

import com.etl.dto.service.AvgDaylightReportDto;
import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;
import com.etl.handler.ConversionHandler;
import com.etl.settings.NumericUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Handler for processing and converting relative humidity data at 2 meters elevation
 * into a 24-hour average value with daylight period consideration.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average relative humidity percentage, specifically focusing on daylight hours when
 * humidity levels significantly impact human comfort, agricultural operations, and
 * perceived temperature.
 */
@Component
@RequiredArgsConstructor
public class HourlyAvgRelativeHumidityTwoMTwentyFourHConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing humidity calculations with daylight weighting
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly relative humidity data at 2 meters elevation and calculates
     * the 24-hour average with daylight emphasis.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly relative humidity measurements at 2m height</li>
     *   <li>Calculates the weighted average humidity percentage (0-100%)</li>
     *   <li>Stores the result in the daylight weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (non-null)
     * @param generalWeatherDto the source DTO containing raw observations (non-null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the humidity data list is empty or contains invalid values (<0 or >100)
     * @see NumericUtils#calculateAverageValueDayLightRelativeHumidity(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        AvgDaylightReportDto avgDailyReport = weatherReportDto.getAvgDaylightReport();
        List<Integer> relativeHumidityTwoM = generalWeatherDto.getHourlyDto().getRelativeHumidityTwoM();
        Integer average = numericUtils.calculateAverageValueDayLightRelativeHumidity(relativeHumidityTwoM);
        avgDailyReport.setRelativeHumidityTwoMDaylight(average);
    }
}

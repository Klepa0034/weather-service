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
 * Handler for processing and converting sunrise time data into ISO 8601 formatted strings.
 * <p>
 * This component implements the {@link ConversionHandler} interface to process Unix timestamp
 * values representing sunrise times and convert them into standardized ISO 8601 format
 * (e.g., "2023-12-25T06:30:00Z") for consistent representation and interoperability.
 */
@Component
@RequiredArgsConstructor
public class SunriseIsoConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing time conversions and ISO formatting
     */
    private final NumericUtils numericUtils;

    /**
     * Processes sunrise time data and converts it to ISO 8601 format.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves sunrise time values as Unix timestamps (seconds since epoch)</li>
     *   <li>Converts timestamps to ISO 8601 formatted strings</li>
     *   <li>Stores the result in the general metrics report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the sunrise time list is empty
     * @see NumericUtils#calculateSecondsListToIso(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Long> sunriseTimes = generalWeatherDto.getDailyDto().getSunrise();
        GeneralMetricsDto generalMetrics = weatherReportDto.getGeneralMetrics();
        String average = numericUtils.calculateSecondsListToIso(sunriseTimes);
        generalMetrics.setSunriseIsoD(average);
    }
}

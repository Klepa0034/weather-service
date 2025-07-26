package com.etl.handler.impl.daily;

import com.etl.dto.service.AvgDailyReportDto;
import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;
import com.etl.handler.ConversionHandler;
import com.etl.settings.NumericUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Handler for processing and converting atmospheric visibility data.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average 24-hour visibility distance in meters. It processes hourly visibility measurements
 * to determine daily average conditions, which are critical for aviation, marine, and transportation safety.
 */
@Component
@RequiredArgsConstructor
public class VisibilityDayLightConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing meteorological calculations and distance conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly visibility data and calculates the daily average visibility distance.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly visibility measurements from source data</li>
     *   <li>Calculates the 24-hour average visibility in meters</li>
     *   <li>Stores the result in the daily weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO where results will be stored (non-null)
     * @param generalWeatherDto the source DTO containing raw weather observations (non-null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the visibility data list is empty or contains negative values
     * @see NumericUtils#calculateAverageValueInMeters(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        AvgDailyReportDto avgDailyReport = weatherReportDto.getAvgDailyReport();
        List<Double> visibility = generalWeatherDto.getHourlyDto().getVisibility();
        double average = numericUtils.calculateAverageValueInMeters(visibility);
        avgDailyReport.setAvgVisibilityTwentyFourH(average);
    }
}

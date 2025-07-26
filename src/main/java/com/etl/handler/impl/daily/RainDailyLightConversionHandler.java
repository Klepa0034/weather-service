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
 * Handler for processing and converting daily rainfall data from hourly measurements.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the total 24-hour rainfall amount in millimeters. It processes hourly rain data and
 * computes the daily aggregate value.
 */
@Component
@RequiredArgsConstructor
public class RainDailyLightConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing numerical calculations and unit conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly rainfall data and calculates the total daily precipitation amount.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly rainfall measurements from the source data</li>
     *   <li>Calculates the 24-hour total precipitation in millimeters</li>
     *   <li>Stores the result in the daily weather report</li>
     * </ol>
     *
     * @param weatherReportDto  The target weather report DTO where results will be stored
     * @param generalWeatherDto The source DTO containing raw weather observations
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the rain data list is empty
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> rain = generalWeatherDto.getHourlyDto().getRain();
        AvgDailyReportDto avgDailyReport = weatherReportDto.getAvgDailyReport();
        double average = numericUtils.calculateAverageValueInMillimeters(rain);
        avgDailyReport.setTotalRainTwentyFourH(average);
    }
}

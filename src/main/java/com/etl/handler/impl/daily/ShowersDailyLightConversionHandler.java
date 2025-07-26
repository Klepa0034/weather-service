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
 * Handler for processing and converting shower precipitation data from hourly measurements.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the total 24-hour shower precipitation amount in millimeters. It processes hourly shower data
 * and computes the daily aggregate value.
 */
@Component
@RequiredArgsConstructor
public class ShowersDailyLightConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing numerical calculations and unit conversions
     * related to precipitation data.
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly shower precipitation data and calculates the total daily amount.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly shower measurements from the source data</li>
     *   <li>Calculates the 24-hour total precipitation in millimeters</li>
     *   <li>Stores the result in the daily weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO where results will be stored
     * @param generalWeatherDto the source DTO containing raw weather observations
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the showers data list is empty
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> showers = generalWeatherDto.getHourlyDto().getShowers();
        AvgDailyReportDto generalDailyReport = weatherReportDto.getAvgDailyReport();
        Double average = numericUtils.calculateAverageValueInMillimeters(showers);
        generalDailyReport.setTotalShowersTwentyFourH(average);
    }
}

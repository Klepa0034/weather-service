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
 * Handler for processing and converting daily snowfall data from hourly measurements.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the total 24-hour snowfall accumulation in millimeters. It processes hourly snowfall data
 * and computes the daily aggregate value.
 */
@Component
@RequiredArgsConstructor
public class SnowfallDailyLightConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing numerical calculations and unit conversions
     * specific to snowfall measurements.
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly snowfall data and calculates the total daily accumulation.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly snowfall measurements from the source data</li>
     *   <li>Calculates the 24-hour total snowfall accumulation in millimeters</li>
     *   <li>Stores the result in the daily weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO where results will be stored (must not be null)
     * @param generalWeatherDto the source DTO containing raw weather observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the snowfall data list is empty
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Integer> snowfall = generalWeatherDto.getHourlyDto().getSnowfall();
        AvgDailyReportDto generalDailyReport = weatherReportDto.getAvgDailyReport();
        double average = numericUtils.calculateAverageSnowfallValueInMillimeters(snowfall);
        generalDailyReport.setTotalSnowfallTwentyFourH(average);
    }
}

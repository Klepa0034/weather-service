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
 * Handler for processing and converting dew point temperature data at 2 meters elevation
 * to calculate daily average values in Celsius.
 * <p>
 * Implements the {@link ConversionHandler} interface to integrate with the weather data processing pipeline.
 * This component specifically handles dew point temperature conversion and averaging operations.
 */
@Component
@RequiredArgsConstructor
public class DewPointTwoMDayLightConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing numerical calculations and conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly dew point temperature data at 2 meters elevation, calculates the daily average,
     * and stores the result in the weather report DTO.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves the hourly dew point temperature data</li>
     *   <li>Calculates the 24-hour average value in Celsius</li>
     *   <li>Stores the result in the daily weather report</li>
     * </ol>
     *
     * @param weatherReportDto  The target weather report DTO where results will be stored
     * @param generalWeatherDto The source DTO containing raw weather data
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the dew point temperature list is empty
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        AvgDailyReportDto avgDailyReport = weatherReportDto.getAvgDailyReport();
        List<Double> dewPointTwoM = generalWeatherDto.getHourlyDto().getDewPointTwoM();
        double average = numericUtils.calculateAverageInCelsius(dewPointTwoM);
        avgDailyReport.setAvgDewPointTwoMTwentyFourH(average);
    }
}

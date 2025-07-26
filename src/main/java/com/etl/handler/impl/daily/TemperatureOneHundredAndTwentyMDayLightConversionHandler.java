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
 * Handler for processing and converting temperature data at 120 meters elevation.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average 24-hour air temperature at 120 meters above ground level in Celsius.
 * Primarily used for modern wind turbine applications and upper atmospheric studies.
 */
@Component
@RequiredArgsConstructor
public class TemperatureOneHundredAndTwentyMDayLightConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing meteorological calculations and temperature conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly temperature data at 120 meters elevation and calculates
     * the daily average temperature in Celsius.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly temperature measurements at 120m height from source data</li>
     *   <li>Calculates the 24-hour average temperature in degrees Celsius</li>
     *   <li>Stores the result in the daily weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO where results will be stored (non-null)
     * @param generalWeatherDto the source DTO containing raw weather observations (non-null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the temperature data list is empty
     * @see NumericUtils#calculateAverageInCelsius(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> temperatureOneHundredTwentyM = generalWeatherDto.getHourlyDto().getTemperatureOneHundredAndTwenty();
        AvgDailyReportDto generalDailyReport = weatherReportDto.getAvgDailyReport();
        double average = numericUtils.calculateAverageInCelsius(temperatureOneHundredTwentyM);
        generalDailyReport.setAvgTemperatureOneHundredAndTwentyMTwentyFourH(average);
    }
}

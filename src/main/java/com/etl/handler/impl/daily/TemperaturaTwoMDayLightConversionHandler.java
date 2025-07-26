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
 * Handler for processing and converting temperature data at 2 meters elevation.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average 24-hour air temperature at 2 meters above ground level in Celsius.
 */
@Component
@RequiredArgsConstructor
public class TemperaturaTwoMDayLightConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing temperature calculations and conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly temperature data at 2 meters elevation and calculates
     * the daily average temperature in Celsius.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly temperature measurements at 2m height from source data</li>
     *   <li>Calculates the 24-hour average temperature in degrees Celsius</li>
     *   <li>Stores the result in the daily weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO where results will be stored (must not be null)
     * @param generalWeatherDto the source DTO containing raw weather observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the temperature data list is empty
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> temperatureTwoM = generalWeatherDto.getHourlyDto().getTemperatureTwoM();
        AvgDailyReportDto generalDailyReport = weatherReportDto.getAvgDailyReport();
        Double average = numericUtils.calculateAverageInCelsius(temperatureTwoM);
        generalDailyReport.setAvgTemperatureTwoMTwentyFourH(average);
    }
}

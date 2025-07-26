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
 * Handler for processing and converting temperature data at 80 meters elevation.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average 24-hour air temperature at 80 meters above ground level in Celsius.
 * Primarily used for wind energy applications and upper air temperature analysis.
 */
@Component
@RequiredArgsConstructor
public class TemperatureEightyMDayLightConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing meteorological calculations and temperature conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly temperature data at 80 meters elevation and calculates
     * the daily average temperature in Celsius.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly temperature measurements at 80m height from source data</li>
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
        List<Double> temperatureEightyM = generalWeatherDto.getHourlyDto().getTemperatureEightyM();
        AvgDailyReportDto generalDailyReport = weatherReportDto.getAvgDailyReport();
        double average = numericUtils.calculateAverageInCelsius(temperatureEightyM);
        generalDailyReport.setAvgTemperatureEightyMDTwentyFourH(average);
    }
}

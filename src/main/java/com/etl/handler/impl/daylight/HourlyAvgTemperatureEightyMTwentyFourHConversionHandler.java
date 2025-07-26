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
 * Handler for processing and converting temperature data at 80 meters elevation
 * into a 24-hour average value with daylight period consideration.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average air temperature in Celsius at 80 meters above ground level, with special
 * emphasis on daylight hours. This measurement is particularly relevant for wind energy
 * applications, atmospheric studies, and temperature gradient analysis.
 */
@Component
@RequiredArgsConstructor
public class HourlyAvgTemperatureEightyMTwentyFourHConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing temperature calculations with daylight weighting
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly temperature data at 80 meters elevation and calculates
     * the 24-hour average with daylight emphasis.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly temperature measurements at 80m height</li>
     *   <li>Calculates the weighted average temperature in degrees Celsius</li>
     *   <li>Stores the result in the daylight weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (non-null)
     * @param generalWeatherDto the source DTO containing raw observations (non-null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the temperature data list is empty
     * @see NumericUtils#calculateAverageInCelsiusDailyLight(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> temperatureEightyM = generalWeatherDto.getHourlyDto().getTemperatureEightyM();
        AvgDaylightReportDto generalDailyReport = weatherReportDto.getAvgDaylightReport();
        double average = numericUtils.calculateAverageInCelsiusDailyLight(temperatureEightyM);
        generalDailyReport.setTemperatureEightyMDaylight(average);
    }
}

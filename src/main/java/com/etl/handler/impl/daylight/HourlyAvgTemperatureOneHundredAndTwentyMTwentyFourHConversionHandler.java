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
 * Handler for processing and converting temperature data at 120 meters elevation
 * into a 24-hour average value with daylight period consideration.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average air temperature in Celsius at 120 meters above ground level, with special
 * emphasis on daylight hours. This measurement is crucial for modern wind turbine
 * applications, atmospheric boundary layer research, and tall structure climate analysis.
 */
@Component
@RequiredArgsConstructor
public class HourlyAvgTemperatureOneHundredAndTwentyMTwentyFourHConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing advanced temperature calculations with
     * daylight period weighting
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly temperature data at 120 meters elevation and calculates
     * the 24-hour average with daylight emphasis.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly temperature measurements at 120m height</li>
     *   <li>Applies daylight-hour weighting to the calculations</li>
     *   <li>Calculates the weighted average temperature in degrees Celsius</li>
     *   <li>Stores the result in the daylight weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the temperature data list is empty
     * @see NumericUtils#calculateAverageInCelsiusDailyLight(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> temperatureOneHundredAndTwenty = generalWeatherDto.getHourlyDto().getTemperatureOneHundredAndTwenty();
        AvgDaylightReportDto avgDailyReport = weatherReportDto.getAvgDaylightReport();
        double average = numericUtils.calculateAverageInCelsiusDailyLight(temperatureOneHundredAndTwenty);
        avgDailyReport.setTemperatureOneHundredAndTwentyDaylight(average);
    }
}

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
 * Handler for processing and converting apparent temperature (feels-like temperature) data
 * for daylight hours into a 24-hour average value.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average apparent temperature in Celsius, specifically focusing on daylight period
 * measurements. The apparent temperature accounts for both air temperature and humidity
 * effects on perceived warmth.
 */
@Component
@RequiredArgsConstructor
public class HourlyavgApparentTemperatureTwentyFourHConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing temperature calculations and conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly apparent temperature data and calculates the 24-hour average
     * value in Celsius, with special consideration for daylight hours.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly apparent temperature measurements from source data</li>
     *   <li>Calculates the 24-hour average apparent temperature in degrees Celsius</li>
     *   <li>Stores the result in the daylight weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO where results will be stored (non-null)
     * @param generalWeatherDto the source DTO containing raw weather observations (non-null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the apparent temperature data list is empty
     * @see NumericUtils#calculateAverageInCelsiusDailyLight(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        AvgDaylightReportDto avgDaylightReport = weatherReportDto.getAvgDaylightReport();
        List<Double> apparentTemperature = generalWeatherDto.getHourlyDto().getApparentTemperature();
        double average = numericUtils.calculateAverageInCelsiusDailyLight(apparentTemperature);
        avgDaylightReport.setApparentTemperatureDaylight(average);
    }
}

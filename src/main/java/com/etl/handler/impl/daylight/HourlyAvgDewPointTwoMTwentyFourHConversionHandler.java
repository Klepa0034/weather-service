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
 * Handler for processing and converting dew point temperature data at 2 meters elevation
 * into a 24-hour average value with daylight period consideration.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average dew point temperature in Celsius, focusing on daylight hours when humidity
 * effects are most significant for human comfort and agricultural applications.
 */
@Component
@RequiredArgsConstructor
public class HourlyAvgDewPointTwoMTwentyFourHConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing meteorological calculations and temperature conversions
     * with daylight hour weighting
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly dew point data at 2 meters elevation and calculates
     * the 24-hour average with daylight emphasis.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly dew point measurements at 2m height from source data</li>
     *   <li>Calculates the weighted average dew point in degrees Celsius</li>
     *   <li>Stores the result in the daylight weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO where results will be stored (non-null)
     * @param generalWeatherDto the source DTO containing raw weather observations (non-null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the dew point data list is empty
     * @see NumericUtils#calculateAverageInCelsiusDailyLight(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        AvgDaylightReportDto avgDailyReport = weatherReportDto.getAvgDaylightReport();
        List<Double> dewPointTwoM = generalWeatherDto.getHourlyDto().getDewPointTwoM();
        double average = numericUtils.calculateAverageInCelsiusDailyLight(dewPointTwoM);
        avgDailyReport.setDewPointTwoMDaylight(average);
    }
}
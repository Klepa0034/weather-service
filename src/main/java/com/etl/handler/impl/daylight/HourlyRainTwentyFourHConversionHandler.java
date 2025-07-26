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
 * Handler for processing and converting rainfall data into a 24-hour average value
 * with daylight period consideration.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average rainfall amount in millimeters (mm), with special emphasis on daylight hours
 * when precipitation characteristics often differ from nighttime patterns.
 */
@Component
@RequiredArgsConstructor
public class HourlyRainTwentyFourHConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing precipitation calculations with daylight weighting
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly rainfall data and calculates the 24-hour average
     * with daylight emphasis.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly rainfall measurements in millimeters</li>
     *   <li>Applies daylight-hour weighting to the calculations</li>
     *   <li>Calculates the weighted average rainfall amount</li>
     *   <li>Stores the result in the daylight weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the rainfall data list is empty or contains negative values
     * @see NumericUtils#calculateAverageValueInMillimetersDailyLight(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> rain = generalWeatherDto.getHourlyDto().getRain();
        AvgDaylightReportDto generalDailyReport = weatherReportDto.getAvgDaylightReport();
        Double average = numericUtils.calculateAverageValueInMillimetersDailyLight(rain);
        generalDailyReport.setRainTwentyFourHDaylight(average);
    }
}

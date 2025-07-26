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
 * Handler for processing and converting atmospheric visibility data
 * into a 24-hour average value with daylight period consideration.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average visibility distance in meters, with special emphasis on daylight hours when
 * visibility conditions are most critical for transportation, aviation, and outdoor activities.
 */
@Component
@RequiredArgsConstructor
public class HourlyAvgVisibilityTwentyFourHConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing visibility calculations with daylight weighting
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly visibility data and calculates the 24-hour average
     * with daylight emphasis.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly visibility measurements in meters</li>
     *   <li>Applies daylight-hour weighting to the calculations</li>
     *   <li>Calculates the weighted average visibility distance</li>
     *   <li>Stores the result in the daylight weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the visibility data list is empty or contains negative values
     * @see NumericUtils#calculateAverageValueInMetersDailyLight(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        AvgDaylightReportDto avgDailyReport = weatherReportDto.getAvgDaylightReport();
        List<Double> visibility = generalWeatherDto.getHourlyDto().getVisibility();
        double average = numericUtils.calculateAverageValueInMetersDailyLight(visibility);
        avgDailyReport.setVisibilityDaylight(average);
    }
}

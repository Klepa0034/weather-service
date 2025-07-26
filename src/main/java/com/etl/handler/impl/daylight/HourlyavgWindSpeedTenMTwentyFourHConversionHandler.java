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
 * Handler for processing and converting wind speed data at 10 meters elevation
 * into a 24-hour average value with daylight period consideration.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average wind speed in meters per second (m/s) at standard meteorological height
 * (10m) above ground level, with special emphasis on daylight hours when surface wind
 * patterns are most significant for weather forecasting and outdoor activities.
 */
@Component
@RequiredArgsConstructor
public class HourlyavgWindSpeedTenMTwentyFourHConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing wind speed calculations with daylight weighting
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly wind speed data at 10 meters elevation and calculates
     * the 24-hour average with daylight emphasis.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly wind speed measurements at 10m height</li>
     *   <li>Applies daylight-hour weighting to the calculations</li>
     *   <li>Calculates the weighted average wind speed in m/s</li>
     *   <li>Stores the result in the daylight weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the wind speed data list is empty or contains negative values
     * @see NumericUtils#calculateOverallAverageInMetersPerSecondDailyLight(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> windSpeedTenM = generalWeatherDto.getHourlyDto().getWindSpeedTenM();
        AvgDaylightReportDto avgDailyReport = weatherReportDto.getAvgDaylightReport();
        Double average = numericUtils.calculateOverallAverageInMetersPerSecondDailyLight(windSpeedTenM);
        avgDailyReport.setWindSpeedTenMDaylight(average);
    }
}

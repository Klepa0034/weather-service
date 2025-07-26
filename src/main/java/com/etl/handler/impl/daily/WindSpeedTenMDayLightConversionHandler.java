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
 * Handler for processing and converting wind speed data at 10 meters elevation.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average 24-hour wind speed at the standard meteorological height of 10 meters
 * above ground level in meters per second (m/s). This measurement is essential for
 * traditional weather forecasting and surface wind analysis.
 */
@Component
@RequiredArgsConstructor
public class WindSpeedTenMDayLightConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing wind-related calculations and unit conversions
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly wind speed data at 10 meters elevation and calculates
     * the daily average wind speed in meters per second.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly wind speed measurements at 10m height from source data</li>
     *   <li>Calculates the 24-hour average wind speed in m/s</li>
     *   <li>Stores the result in the daily weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO where results will be stored (non-null)
     * @param generalWeatherDto the source DTO containing raw weather observations (non-null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the wind speed data list is empty or contains negative values
     * @see NumericUtils#calculateAverageValueInMetersPerSecond(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> windSpeedTenM = generalWeatherDto.getHourlyDto().getWindSpeedTenM();
        AvgDailyReportDto avgDailyReport = weatherReportDto.getAvgDailyReport();
        Double average = numericUtils.calculateAverageValueInMetersPerSecond(windSpeedTenM);
        avgDailyReport.setAvgWindSpeedTenMTwentyFourH(average);
    }
}

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
 * Handler for processing and converting relative humidity data at 2 meters elevation.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average 24-hour relative humidity percentage at 2 meters above ground level.
 */
@Component
@RequiredArgsConstructor
public class RelativeHumidityTwoMDayLightConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing numerical calculations on weather data
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly relative humidity data at 2 meters elevation and calculates
     * the daily average percentage value.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly relative humidity measurements from source data</li>
     *   <li>Calculates the 24-hour average relative humidity percentage</li>
     *   <li>Stores the result in the daily weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO where results will be stored
     * @param generalWeatherDto the source DTO containing raw weather observations
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the humidity data list is empty
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        AvgDailyReportDto avgDailyReport = weatherReportDto.getAvgDailyReport();
        List<Integer> relativeHumidityTwoM = generalWeatherDto.getHourlyDto().getRelativeHumidityTwoM();
        int average = numericUtils.calculateAverageValueRelativeHumidity(relativeHumidityTwoM);
        avgDailyReport.setAvgRelativeHumidityTwoMDTwentyFourH(average);
    }
}

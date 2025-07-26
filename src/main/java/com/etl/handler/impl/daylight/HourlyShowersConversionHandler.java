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
 * Handler for processing and converting shower precipitation data into a 24-hour average value
 * with daylight period consideration.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average shower precipitation amount in millimeters (mm), with special emphasis on
 * daylight hours when convective showers are most prevalent.
 */
@Component
@RequiredArgsConstructor
public class HourlyShowersConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing precipitation calculations with daylight weighting
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly shower data and calculates the 24-hour average
     * with daylight emphasis.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly shower measurements in millimeters</li>
     *   <li>Applies daylight-hour weighting to the calculations</li>
     *   <li>Calculates the weighted average shower precipitation</li>
     *   <li>Stores the result in the daylight weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the shower data list is empty or contains negative values
     * @see NumericUtils#calculateAverageValueInMillimetersDailyLight(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Double> showers = generalWeatherDto.getHourlyDto().getShowers();
        AvgDaylightReportDto generalDailyReport = weatherReportDto.getAvgDaylightReport();
        Double average = numericUtils.calculateAverageValueInMillimetersDailyLight(showers);
        generalDailyReport.setShowersTwentyFourHDaylight(average);
    }
}

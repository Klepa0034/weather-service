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
 * Handler for processing and converting snowfall data into a 24-hour average value
 * with daylight period consideration.
 * <p>
 * This component implements the {@link ConversionHandler} interface to calculate and store
 * the average snowfall amount in millimeters (mm) water equivalent, with special emphasis
 * on daylight hours when snowfall characteristics and impacts often differ from nighttime.
 */
@Component
@RequiredArgsConstructor
public class HourlySnowfallTwentyFourHConversionHandler implements ConversionHandler {

    /**
     * Utility service for performing snowfall calculations with daylight weighting
     */
    private final NumericUtils numericUtils;

    /**
     * Processes hourly snowfall data and calculates the 24-hour average
     * with daylight emphasis.
     * <p>
     * The method performs the following operations:
     * <ol>
     *   <li>Retrieves hourly snowfall measurements in millimeters water equivalent</li>
     *   <li>Applies daylight-hour weighting to the calculations</li>
     *   <li>Calculates the weighted average snowfall amount</li>
     *   <li>Stores the result in the daylight weather report</li>
     * </ol>
     *
     * @param weatherReportDto  the target weather report DTO (must not be null)
     * @param generalWeatherDto the source DTO containing raw observations (must not be null)
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the snowfall data list is empty or contains negative values
     * @see NumericUtils#calculateAverageSnowfallValueInMillimeters(List)
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        List<Integer> snowfall = generalWeatherDto.getHourlyDto().getSnowfall();
        AvgDaylightReportDto generalDailyReport = weatherReportDto.getAvgDaylightReport();
        double average = numericUtils.calculateAverageSnowfallValueInMillimeters(snowfall);
        generalDailyReport.setSnowfallTwentyFourHDaylight(average);
    }
}

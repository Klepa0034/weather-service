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
 * Handler for converting apparent temperature (feels-like temperature) data
 * and calculating daily average values in Celsius.
 * <p>
 * Implements the {@link ConversionHandler} interface for integration into the weather data processing system.
 */
@Component
@RequiredArgsConstructor
public class ApparentTemperatureDayLightConversionHandler implements ConversionHandler {

    private final NumericUtils numericUtils;

    /**
     * Performs conversion of apparent temperature data from hourly values
     * to a daily average value in Celsius and stores the result in the report.
     *
     * @param weatherReportDto  Weather report DTO where the result will be stored
     * @param generalWeatherDto DTO containing source weather data
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if the temperature list is empty
     */
    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        AvgDailyReportDto avgDailyReport = weatherReportDto.getAvgDailyReport();
        List<Double> apparentTemperature = generalWeatherDto.getHourlyDto().getApparentTemperature();
        double average = numericUtils.calculateAverageInCelsius(apparentTemperature);
        avgDailyReport.setAvgApparentTemperatureTwentyFourH(average);
    }
}

package com.etl.service.impl;

import com.etl.adapter.ConversionAdapter;
import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;
import com.etl.factory.WeatherReportDtoFactory;
import com.etl.manager.ConversionManager;
import com.etl.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service implementation for converting and adapting weather data.
 * <p>
 * This service coordinates the conversion process between {@link GeneralWeatherDto} and {@link WeatherReportDto}
 * using the following steps:
 * <ol>
 *   <li>Creates a new {@link WeatherReportDto} instance via {@link WeatherReportDtoFactory}</li>
 *   <li>Performs data conversion using {@link ConversionManager}</li>
 *   <li>Adapts the converted data via {@link ConversionAdapter}</li>
 * </ol>
 *
 * @see ConversionService
 */

@Service
@RequiredArgsConstructor
public class ConversionServiceImpl implements ConversionService {

    private final ConversionAdapter conversionAdapter;
    private final ConversionManager conversionManager;
    private final WeatherReportDtoFactory weatherReportDtoFactory;

    @Override
    public void convert(GeneralWeatherDto generalWeatherDto) {
        WeatherReportDto weatherReportDto = weatherReportDtoFactory.create();
        conversionManager.conversion(weatherReportDto, generalWeatherDto);
        conversionAdapter.adapt(weatherReportDto);
    }
}

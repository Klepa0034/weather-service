package com.etl.manager.impl;

import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;
import com.etl.handler.ConversionHandler;
import com.etl.manager.ConversionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Manages the conversion process between {@link GeneralWeatherDto} and {@link WeatherReportDto}
 * by delegating to registered {@link ConversionHandler} implementations.
 * <p>
 * This component orchestrates the conversion workflow by sequentially invoking all
 * configured handlers to transform different aspects of the weather data.
 *
 * @see ConversionManager
 * @see ConversionHandler
 */

@Component
@RequiredArgsConstructor
public class ConversionManagerImpl implements ConversionManager {
    private final List<ConversionHandler> handlers;

    @Override
    public void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto) {
        handlers.forEach(handler -> handler.conversion(weatherReportDto, generalWeatherDto));
    }
}

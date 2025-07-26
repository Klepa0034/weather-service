package com.etl.controller;

import com.etl.dto.api.GeneralWeather;
import com.etl.dto.service.GeneralWeatherDto;
import com.etl.mapper.ConversionMapper;
import com.etl.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for weather data conversion operations.
 * <p>
 * Provides endpoints for converting raw weather data into standardized report formats.
 * Maps to the base path '/api/v1' and handles POST requests for conversion processes.
 *
 * @see ConversionService
 * @see ConversionMapper
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WeatherController {

    /**
     * Converts raw weather data to a standardized report format.
     * <p>
     * Conversion process:
     * <ol>
     *   <li>Maps the incoming {@link GeneralWeather} to {@link GeneralWeatherDto} using {@link ConversionMapper}</li>
     *   <li>Executes the conversion process via {@link ConversionService}</li>
     *   <li>Returns HTTP 204 (No Content) on success</li>
     * </ol>
     *
     * @param generalWeather The raw weather data to convert (required)
     * @return ResponseEntity with no content (HTTP 204)
     * //@throws BadRequestException if input validation fails
     * //@throws ConversionException if conversion process fails
     * @throws IllegalArgumentException if generalWeather is null
     */

    private final ConversionMapper conversionMapper;
    private final ConversionService conversionService;

    @PostMapping("/conversion")
    public ResponseEntity<Void> convertToReport(@RequestBody GeneralWeather generalWeather) {
        GeneralWeatherDto generalWeatherDto = conversionMapper.toGeneralWeatherDto(generalWeather);
        conversionService.convert(generalWeatherDto);
        return ResponseEntity
                .noContent()
                .build();
    }

}

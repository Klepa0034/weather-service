package com.etl.service;

import com.etl.dto.service.GeneralWeatherDto;

/**
 * Service interface for weather data conversion pipeline.
 * <p>
 * Orchestrates the complete transformation of raw weather data ({@link GeneralWeatherDto})
 * into processed weather reports. The conversion typically involves:
 * <ul>
 *   <li>Data normalization</li>
 *   <li>Unit conversions</li>
 *   <li>Aggregation calculations</li>
 *   <li>Final report generation</li>
 * </ul>
 *
 * @see GeneralWeatherDto
 * @see .WeatherReportDto
 */
public interface ConversionService {

    /**
     * Executes the complete weather data conversion process.
     * <p>
     * Transforms raw weather observations into structured report format.
     * Implementations should handle the entire conversion workflow including
     * error handling and data validation.
     *
     * @param generalWeatherDto source weather data to convert (must not be null)
     * @throws NullPointerException     if generalWeatherDto is null
     * @throws .ConversionException     if any conversion step fails
     * @throws .DataValidationException if source data fails validation checks
     */
    void convert(GeneralWeatherDto generalWeatherDto);
}

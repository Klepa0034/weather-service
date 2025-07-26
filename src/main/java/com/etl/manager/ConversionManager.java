package com.etl.manager;

import com.etl.dto.service.GeneralWeatherDto;
import com.etl.dto.service.WeatherReportDto;

/**
 * Manages the conversion process from raw weather data to standardized report format.
 * <p>
 * Coordinates the transformation of {@link GeneralWeatherDto} (source data) into
 * {@link WeatherReportDto} (processed report) by executing a series of conversion steps.
 * Implementations should handle the complete conversion workflow while ensuring data integrity.
 *
 * @see GeneralWeatherDto
 * @see WeatherReportDto
 */
public interface ConversionManager {

    /**
     * Executes the conversion process from raw weather data to report format.
     * <p>
     * Modifies the target {@code weatherReportDto} by applying conversions from
     * the source {@code generalWeatherDto}. The method should fully populate all
     * relevant fields in the report DTO.
     *
     * @param weatherReportDto  the target report DTO to be populated (must not be null)
     * @param generalWeatherDto the source weather data DTO (must not be null)
     * @throws NullPointerException if either parameter is null
     * @throws. ConversionException if any conversion operation fails
     * @throws. DataIntegrityException if source data fails validation checks
     */
    void conversion(WeatherReportDto weatherReportDto, GeneralWeatherDto generalWeatherDto);
}
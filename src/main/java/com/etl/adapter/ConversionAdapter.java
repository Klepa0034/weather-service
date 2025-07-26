package com.etl.adapter;

import com.etl.dto.service.WeatherReportDto;

/**
 * Adapter interface for weather report data transformation.
 * <p>
 * Defines the contract for adapting {@link WeatherReportDto} into target formats.
 * Implementations should handle final data transformation (e.g., database persistence,
 * file export, or external system integration).
 *
 * @implSpec Implementations must be thread-safe when used in concurrent environments
 * @see WeatherReportDto
 */
public interface ConversionAdapter {
    /**
     * Performs adaptation of weather report DTO.
     *
     * @param weatherReportDto weather report data transfer object (must not be null)
     * @throws NullPointerException if weatherReportDto is null
     * @throws .AdaptationException when data adaptation fails
     */
    void adapt(WeatherReportDto weatherReportDto);
}

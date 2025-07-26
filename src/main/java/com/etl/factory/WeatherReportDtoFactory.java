package com.etl.factory;

import com.etl.dto.service.WeatherReportDto;

/**
 * Factory interface for creating new {@link WeatherReportDto} instances.
 * <p>
 * Provides a standardized way to instantiate weather report DTOs with properly initialized
 * sub-components. Implementations should return fully constructed objects with all
 * required child DTOs instantiated.
 *
 * @see WeatherReportDto
 */
public interface WeatherReportDtoFactory {

    /**
     * Creates a new initialized WeatherReportDto instance.
     * <p>
     * The returned object should have all nested DTOs (daily reports, metrics, etc.)
     * properly initialized to avoid null references.
     *
     * @return a new fully initialized {@link WeatherReportDto} instance
     * @throws .DtoCreationException if the DTO cannot be properly constructed
     */
    WeatherReportDto create();
}

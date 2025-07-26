package com.etl.repository;

import com.etl.entity.report.WeatherReport;

/**
 * Repository interface for persisting weather reports to Excel format.
 * <p>
 * Defines the contract for storing {@link WeatherReport} data in Excel files.
 * Implementations should handle all Excel-specific operations including:
 * <ul>
 *   <li>File creation/updating</li>
 *   <li>Data formatting</li>
 *   <li>Sheet management</li>
 * </ul>
 *
 * @see WeatherReport
 */
public interface ExcelRepository {

    /**
     * Persists a weather report to Excel storage.
     * <p>
     * The implementation should write all relevant weather data to
     * a properly formatted Excel file according to business requirements.
     *
     * @param weatherReport the weather report to persist (must not be null)
     * @throws NullPointerException  if weatherReport is null
     * @throws .ExcelExportException if file operations fail
     * @throws .DataFormatException  if report data cannot be properly formatted
     */
    void save(WeatherReport weatherReport);
}

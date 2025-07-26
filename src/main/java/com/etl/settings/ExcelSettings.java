package com.etl.settings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration properties for Excel file processing settings.
 * <p>
 * This class contains customizable parameters for Excel file operations and can be configured
 * through application properties using the 'excel' prefix. These settings are typically used
 * for defining file locations and worksheet names for weather data import/export operations.
 */
@Getter
@Setter
@Configuration
@NoArgsConstructor
@ConfigurationProperties("excel")
public class ExcelSettings {

    /**
     * File system path to the Excel workbook
     * <p>
     * This should be an absolute path to the .xlsx file containing weather data.
     * Example: "/var/data/weather_reports/daily_metrics.xlsx"
     */
    private String path;

    /**
     * Name of the worksheet within the Excel workbook
     * <p>
     * Specifies which sheet contains the data to be processed.
     * Example: "DailyMetrics" or "HourlyObservations"
     */
    private String sheetName;
}

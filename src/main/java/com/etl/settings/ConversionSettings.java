package com.etl.settings;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration properties for weather data conversion settings.
 * <p>
 * This class contains all customizable parameters used for converting and processing
 * weather data. Properties can be overridden through application configuration files
 * using the 'report' prefix.
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("report")
public class ConversionSettings {

    /**
     * Default number of hours to include in data exports (default: 2)
     */
    private int dataExportHours = 2;

    /**
     * Fahrenheit temperature value for the freezing point of water (default: 32)
     */
    private int fahrenheitFreezingPoint = 32;

    /**
     * Denominator for Fahrenheit to Celsius conversion ratio (default: 9)
     * <p>
     * Used in formula: °C = (°F - {@link #fahrenheitFreezingPoint}) * {@link #fahrenheitToCelsiusRatioNumerator} / {@link #fahrenheitToCelsiusRatioDenominator}
     */
    private int fahrenheitToCelsiusRatioDenominator = 9;

    /**
     * Numerator for Fahrenheit to Celsius conversion ratio (default: 5)
     * <p>
     * Used in formula: °C = (°F - {@link #fahrenheitFreezingPoint}) * {@link #fahrenheitToCelsiusRatioNumerator} / {@link #fahrenheitToCelsiusRatioDenominator}
     */
    private int fahrenheitToCelsiusRatioNumerator = 5;

    /**
     * Starting hour for daylight period (24-hour format) (default: 5)
     */
    private int daylightStartHour = 5;

    /**
     * Ending hour for daylight period (24-hour format) (default: 22)
     */
    private int daylightEndHour = 22;

    /**
     * Conversion factor from inches to millimeters (default: 25.4)
     */
    private double inchesToMm = 25.4;

    /**
     * Conversion factor from feet to meters (default: 0.3048)
     */
    private double feetToMeters = 0.3048;

    /**
     * Conversion factor from knots to meters per second (default: 0.514444)
     */
    private double convertedToMps = 0.514444;

    /**
     * Default number of days to include in data exports (default: 1)
     */
    private int dataExportDays = 1;

    /**
     * Number of seconds in one hour (default: 3600)
     * <p>
     * Used for converting time durations from seconds to hours
     */
    private int dataSecondsToHours = 3600;
}
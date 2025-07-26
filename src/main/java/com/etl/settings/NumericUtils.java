package com.etl.settings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Utility class for performing various meteorological calculations and unit conversions.
 * <p>
 * This component provides methods for converting between different measurement units
 * and calculating averages with configurable time windows. All calculations use
 * conversion parameters defined in {@link ConversionSettings}.
 */
@Setter
@Getter
@Component
@RequiredArgsConstructor
public class NumericUtils {
    private final ConversionSettings conversionSettings;

    /**
     * Converts average temperature from Fahrenheit to Celsius.
     *
     * @param values List of temperatures in Fahrenheit (not null)
     * @return Average temperature in Celsius for last N hours
     * (N = dataExportHours from settings)
     * @throws NullPointerException if values is null
     */
    public double calculateAverageInCelsius(List<Double> values) {
        int dataExportHours = conversionSettings.getDataExportHours();
        int fahrenheitFreezingPoint = conversionSettings.getFahrenheitFreezingPoint();
        int fahrenheitToCelsiusRatioNumerator = conversionSettings.getFahrenheitToCelsiusRatioNumerator();
        int fahrenheitToCelsiusRatioDenominator = conversionSettings.getFahrenheitToCelsiusRatioDenominator();
        return values
                .stream()
                .limit(dataExportHours)
                .map(s -> (s - fahrenheitFreezingPoint) * fahrenheitToCelsiusRatioNumerator / fahrenheitToCelsiusRatioDenominator)
                .reduce(Double::sum)
                .map(s -> s / dataExportHours)
                .orElse(0.0);
    }

    /**
     * Calculates the average precipitation amount in millimeters from inches.
     * <p>
     * Processes only the most recent values (up to configured data export hours limit).
     * Conversion uses the inches-to-mm factor from {@link ConversionSettings}.
     *
     * @param values List of precipitation values in inches (not null)
     * @return Average precipitation in millimeters for the time period
     * @throws NullPointerException if values is null
     * @see ConversionSettings#getDataExportHours()
     * @see ConversionSettings#getInchesToMm()
     */
    public double calculateAverageValueInMillimeters(List<Double> values) {
        int dataExportHours = conversionSettings.getDataExportHours();
        return values
                .stream()
                .limit(conversionSettings.getDataExportHours())
                .reduce(Double::sum)
                .map(s -> s / dataExportHours)
                .map(s -> s * conversionSettings.getInchesToMm())
                .orElse(0.0);
    }

    /**
     * Calculates the average value in meters from a list of values.
     *
     * @param values List of values to average (in original units)
     * @return Average value converted to meters, or 0.0 if list is empty
     */
    public double calculateAverageValueInMeters(List<Double> values) {
        int dataExportHours = conversionSettings.getDataExportHours();
        return values
                .stream()
                .limit(conversionSettings.getDataExportHours())
                .reduce(Double::sum)
                .map(s -> s / dataExportHours)
                .map(s -> s * conversionSettings.getFeetToMeters())
                .orElse(0.0);
    }

    /**
     * Calculates average speed in m/s from knots for recent N hours.
     * Uses conversion factor from {@link ConversionSettings}.
     *
     * @param values List of speed values in knots (not null)
     * @return Average in m/s or 0.0 if empty
     */
    public double calculateAverageValueInMetersPerSecond(List<Double> values) {
        int dataExportHours = conversionSettings.getDataExportHours();
        return values
                .stream()
                .limit(conversionSettings.getDataExportHours())
                .reduce(Double::sum)
                .map(s -> s / dataExportHours)
                .map(s -> s * conversionSettings.getConvertedToMps())
                .orElse(0.0);
    }

    /**
     * Calculates average temperature in Celsius during daylight hours from Fahrenheit values.
     * <p>
     * Processes values between {@link ConversionSettings#getDaylightStartHour()} and
     * {@link ConversionSettings#getDaylightEndHour()}, converts them to Celsius using:
     * {@code (°F - freezingPoint) * numerator / denominator}, then calculates the average.
     *
     * @param values List of temperature values in Fahrenheit (not null)
     * @return Average temperature in Celsius during daylight, or 0.0 if no valid data
     * @throws NullPointerException if values is null
     * @see ConversionSettings#getFahrenheitFreezingPoint()
     * @see ConversionSettings#getFahrenheitToCelsiusRatioNumerator()
     * @see ConversionSettings#getFahrenheitToCelsiusRatioDenominator()
     */
    public double calculateAverageInCelsiusDailyLight(List<Double> values) {
        int dataExportHours = conversionSettings.getDataExportHours();
        int fahrenheitFreezingPoint = conversionSettings.getFahrenheitFreezingPoint();
        int fahrenheitToCelsiusRatioNumerator = conversionSettings.getFahrenheitToCelsiusRatioNumerator();
        int fahrenheitToCelsiusRatioDenominator = conversionSettings.getFahrenheitToCelsiusRatioDenominator();
        return values
                .stream()
                .limit(conversionSettings.getDaylightEndHour())
                .skip(conversionSettings.getDaylightStartHour())
                .map(s -> ((s - fahrenheitFreezingPoint) * fahrenheitToCelsiusRatioNumerator) / fahrenheitToCelsiusRatioDenominator)
                .reduce(Double::sum)
                .map(s -> s / dataExportHours)
                .orElse(0.0);
    }

    /**
     * Calculates average precipitation in millimeters during daylight hours.
     * Processes values between daylight start and end hours from {@link ConversionSettings}.
     * Converts from inches to millimeters using {@link ConversionSettings#getInchesToMm()}.
     *
     * @param values Precipitation values in inches (not null, can be empty)
     * @return Average in millimeters, or 0.0 if no daylight values available
     * @throws NullPointerException if values is null
     * @throws ArithmeticException  if dataExportHours is 0 (division by zero)
     */
    public double calculateAverageValueInMillimetersDailyLight(List<Double> values) {
        int dataExportHours = conversionSettings.getDataExportHours();
        return values
                .stream()
                .limit(conversionSettings.getDaylightEndHour())
                .skip(conversionSettings.getDaylightStartHour())
                .reduce(Double::sum)
                .map(s -> s / dataExportHours)
                .map(s -> s * conversionSettings.getInchesToMm())
                .orElse(0.0);
    }

    /**
     * Calculates the average precipitation in millimeters during daylight hours.
     * <p>
     * Processes values between {@link ConversionSettings#getDaylightStartHour()} and
     * {@link ConversionSettings#getDaylightEndHour()}, converts from inches to millimeters
     * using the conversion factor from {@link ConversionSettings#getInchesToMm()}.
     *
     * @param values List of precipitation values in inches (not null)
     * @return Average precipitation in millimeters during daylight hours, or 0.0 if no valid data
     * @throws NullPointerException if values is null
     * @see ConversionSettings#getDataExportHours()
     * @see ConversionSettings#getInchesToMm()
     */
    public double calculateAverageValueInMetersDailyLight(List<Double> values) {
        int dataExportHours = conversionSettings.getDataExportHours();
        return values
                .stream()
                .limit(conversionSettings.getDaylightEndHour())
                .skip(conversionSettings.getDaylightStartHour())
                .reduce(Double::sum)
                .map(s -> s / dataExportHours)
                .map(s -> s * conversionSettings.getFeetToMeters())
                .orElse(0.0);
    }

    /**
     * Calculates the overall average wind speed in m/s during daylight hours.
     * <p>
     * Processes values starting from {@link ConversionSettings#getDaylightStartHour()},
     * converts from knots to m/s using {@link ConversionSettings#getConvertedToMps()}.
     * The average is calculated across all available daylight values.
     *
     * @param values List of wind speed values in knots (not null)
     * @return Overall average wind speed in m/s during daylight, or 0.0 if empty
     * @throws NullPointerException if values is null
     * @throws ArithmeticException  if values.size() is 0 (division by zero)
     */
    public double calculateOverallAverageInMetersPerSecondDailyLight(List<Double> values) {
        return values.
                stream()
                .skip(conversionSettings.getDaylightStartHour())
                .reduce(Double::sum)
                .map(s -> s / values.size())
                .map(s -> s * conversionSettings.getConvertedToMps())
                .orElse(0.0);
    }

    /**
     * Calculates the average relative humidity percentage from a list of values.
     * <p>
     * Processes up to {@link ConversionSettings#getDataExportHours()} most recent values.
     *
     * @param values List of relative humidity percentages (0-100 range, not null)
     * @return Average relative humidity percentage (integer), or 0 if input is empty
     * @throws NullPointerException if values is null
     * @throws ArithmeticException  if dataExportHours is 0 (division by zero)
     */
    public int calculateAverageValueRelativeHumidity(List<Integer> values) {
        int dataExportHours = conversionSettings.getDataExportHours();
        return values
                .stream()
                .limit(conversionSettings.getDataExportHours())
                .reduce(Integer::sum)
                .map(s -> s / dataExportHours)
                .orElse(0);
    }

    /**
     * Converts a sum of time values from seconds to hours.
     * <p>
     * Processes up to {@link ConversionSettings#getDataExportDays()} most recent values,
     * sums them, and converts to hours using {@link ConversionSettings#getDataSecondsToHours()}.
     *
     * @param values List of time duration values in seconds (not null)
     * @return Total time in hours (double precision), or 0.0 if input is empty
     * @throws NullPointerException if values is null
     * @throws ArithmeticException  if dataSecondsToHours is 0 (division by zero)
     * @see ConversionSettings#getDataExportDays()
     * @see ConversionSettings#getDataSecondsToHours()
     */
    public double calculateValueHours(List<Double> values) {
        return values
                .stream()
                .limit(conversionSettings.getDataExportDays())
                .reduce(Double::sum)
                .map(s -> s / conversionSettings.getDataSecondsToHours())
                .orElse(0.0);
    }

    /**
     * Converts epoch seconds to ISO-8601 strings and concatenates them.
     * Limits input to {@link ConversionSettings#getDataExportDays()} values.
     *
     * @param values List of epoch seconds
     * @return Concatenated ISO-8601 strings or empty string
     */
    public String calculateSecondsListToIso(List<Long> values) {
        return values.stream()
                .limit(conversionSettings.getDataExportDays())
                .map(seconds -> DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochSecond(seconds)))
                .reduce("", (partial, next) -> partial + next);

    }

    /**
     * Calculates average relative humidity (%) during daylight hours.
     * Uses daylight hours range from ConversionSettings.
     *
     * @param values Humidity values (0-100%)
     * @return Average humidity or 0 if no data
     */
    public int calculateAverageValueDayLightRelativeHumidity(List<Integer> values) {
        int dataExportHours = conversionSettings.getDataExportHours();
        return values
                .stream()
                .limit(conversionSettings.getDaylightEndHour())
                .skip(conversionSettings.getDaylightStartHour())
                .reduce(Integer::sum)
                .map(s -> s / dataExportHours)
                .orElse(0);
    }

    /**
     * Calculates average snowfall in millimeters from inches.
     * Uses most recent values (up to dataExportHours limit).
     *
     * @param values Snowfall values in inches
     * @return Average in mm or 0.0 if empty
     */
    public double calculateAverageSnowfallValueInMillimeters(List<Integer> values) {
        int dataExportHours = conversionSettings.getDataExportHours();
        return values
                .stream()
                .limit(conversionSettings.getDataExportHours())
                .reduce(Integer::sum)
                .map(s -> s / dataExportHours)
                .map(s -> s * conversionSettings.getInchesToMm())
                .orElse(0.0);
    }

    /**
     * Converts total precipitation from inches to millimeters.
     * Processes all available values (no time window limit).
     *
     * @param values Precipitation values in inches
     * @return Total precipitation in mm or 0.0 if empty
     */
    public double calculateValueInMillimeters(List<Double> values) {
        return values
                .stream()
                .reduce(Double::sum)
                .map(s -> s * conversionSettings.getInchesToMm())
                .orElse(0.0);
    }

    /**
     * Calculates total snowfall converted from inches to millimeters.
     *
     * @param values Snowfall measurements in inches (not null)
     * @return Total snowfall in millimeters, or 0.0 if empty
     */
    public double calculateSnowfallValueInMillimeters(List<Integer> values) {
        return values
                .stream()
                .reduce(Integer::sum)
                .map(s -> s * conversionSettings.getInchesToMm())
                .orElse(0.0);
    }

    /**
     * Converts Fahrenheit temperatures to Celsius and calculates average.
     * Uses conversion formula: (°F - {@link ConversionSettings#getFahrenheitFreezingPoint()})
     * * {@link ConversionSettings#getFahrenheitToCelsiusRatioNumerator()}
     * / {@link ConversionSettings#getFahrenheitToCelsiusRatioDenominator()}
     *
     * @param values Temperatures in Fahrenheit (not null)
     * @return Average temperature in Celsius, or 0.0 if empty
     */
    public double calculateInCelsius(List<Double> values) {
        int dataExportHours = conversionSettings.getDataExportHours();
        int fahrenheitFreezingPoint = conversionSettings.getFahrenheitFreezingPoint();
        int fahrenheitToCelsiusRatioNumerator = conversionSettings.getFahrenheitToCelsiusRatioNumerator();
        int fahrenheitToCelsiusRatioDenominator = conversionSettings.getFahrenheitToCelsiusRatioDenominator();
        return values
                .stream()
                .limit(dataExportHours)
                .map(s -> (s - fahrenheitFreezingPoint) * fahrenheitToCelsiusRatioNumerator / fahrenheitToCelsiusRatioDenominator)
                .reduce(Double::sum)
                .map(s -> s / values.size())
                .orElse(0.0);

    }

    /**
     * Calculates overall average wind speed in m/s from knots.
     * Processes most recent values (up to dataExportHours limit).
     *
     * @param values Wind speeds in knots (not null)
     * @return Average speed in m/s, or 0.0 if empty
     * @see ConversionSettings#getConvertedToMps()
     */
    public double calculateOverallInMetersPerSecond(List<Double> values) {
        return values.
                stream()
                .limit(conversionSettings.getDataExportHours())
                .reduce(Double::sum)
                .map(s -> s / values.size())
                .map(s -> s * conversionSettings.getConvertedToMps())
                .orElse(0.0);
    }
}
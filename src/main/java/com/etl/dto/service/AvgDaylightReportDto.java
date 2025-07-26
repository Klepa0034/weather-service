package com.etl.dto.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Data Transfer Object containing aggregated daylight weather metrics.
 * <p>
 * Represents average and total values for various weather parameters
 * specifically during daylight hours (as defined by the application's daylight period).
 * All measurements follow standard meteorological units.
 */
public class AvgDaylightReportDto {

    /**
     * Average temperature at 2 meters height during daylight hours
     * (in degrees Celsius, °C)
     */
    private Double temperatureTwoMCelsiusDaylight;

    /**
     * Average relative humidity at 2 meters during daylight hours
     * (in percent, %)
     */
    private Integer relativeHumidityTwoMDaylight;

    /**
     * Average dew point at 2 meters during daylight hours
     * (in degrees Celsius, °C)
     */
    private Double dewPointTwoMDaylight;

    /**
     * Average apparent (feels-like) temperature during daylight hours
     * (in degrees Celsius, °C)
     */
    private Double apparentTemperatureDaylight;

    /**
     * Average temperature at 80 meters height during daylight hours
     * (in degrees Celsius, °C)
     */
    private Double temperatureEightyMDaylight;

    /**
     * Average temperature at 120 meters height during daylight hours
     * (in degrees Celsius, °C)
     */
    private Double temperatureOneHundredAndTwentyDaylight;

    /**
     * Average wind speed at 10 meters height during daylight hours
     * (in meters per second, m/s)
     */
    private Double windSpeedTenMDaylight;

    /**
     * Average wind speed at 80 meters height during daylight hours
     * (in meters per second, m/s)
     */
    private Double windSpeedEightyMDaylight;

    /**
     * Average visibility during daylight hours
     * (in meters, m)
     */
    private Double visibilityDaylight;

    /**
     * Weather condition code during daylight hours
     * (see application's weather code mapping)
     */
    private Integer weatherCodeDaylight;

    /**
     * Average soil temperature at 0 cm depth during daylight hours
     * (in degrees Celsius, °C)
     */
    private Double soilTemperatureZeroCmDaylight;

    /**
     * Average soil temperature at 6 cm depth during daylight hours
     * (in degrees Celsius, °C)
     */
    private Double soilTemperatureSixCmDaylight;

    /**
     * Total snowfall accumulation during daylight hours
     * (in centimeters, cm)
     */
    private Double snowfallTwentyFourHDaylight;

    /**
     * Total shower precipitation during daylight hours
     * (in millimeters, mm)
     */
    private Double showersTwentyFourHDaylight;

    /**
     * Total rainfall during daylight hours
     * (in millimeters, mm)
     */
    private Double rainTwentyFourHDaylight;
}

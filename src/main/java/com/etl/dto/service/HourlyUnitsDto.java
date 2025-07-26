package com.etl.dto.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Data Transfer Object containing unit definitions for hourly weather measurements.
 * <p>
 * Specifies the measurement units for corresponding fields in {@link HourlyDto}.
 * Unit strings should follow standardized meteorological conventions.
 */
public class HourlyUnitsDto {

    /**
     * Unit for timestamps (typically "unixtime" or "ISO8601")
     */
    private String time;

    /**
     * Unit for temperature at 2m height (typically "°C")
     */
    private String temperatureTwoM;

    /**
     * Unit for relative humidity at 2m (typically "%")
     */
    private String relativeHumidityTwoM;

    /**
     * Unit for dew point temperature (typically "°C")
     */
    private String dewPointTwoM;

    /**
     * Unit for apparent temperature (typically "°C")
     */
    private String apparentTemperature;

    /**
     * Unit for temperature at 80m height (typically "°C")
     */
    private String temperatureEightyM;

    /**
     * Unit for temperature at 120m height (typically "°C")
     */
    private String temperatureOneHundredAndTwentyM;

    /**
     * Unit for wind speed at 10m (typically "m/s")
     */
    private String windSpeedTenM;

    /**
     * Unit for wind speed at 80m (typically "m/s")
     */
    private String windSpeedEightyM;

    /**
     * Unit for wind direction at 10m (typically "°" [0-360])
     */
    private String windDirectionTenM;

    /**
     * Unit for wind direction at 80m (typically "°" [0-360])
     */
    private String windDirectionEightyM;

    /**
     * Unit for visibility (typically "m")
     */
    private String visibility;

    /**
     * Unit for evapotranspiration (typically "mm")
     */
    private String evapotranspiration;

    /**
     * Description for weather codes (typically "wmo code")
     */
    private String weatherCode;

    /**
     * Unit for soil temperature at 0cm (typically "°C")
     */
    private String soilTemperatureZeroCm;

    /**
     * Unit for soil temperature at 6cm (typically "°C")
     */
    private String soilTemperatureSixCm;

    /**
     * Unit for rainfall (typically "mm")
     */
    private String rain;

    /**
     * Unit for shower precipitation (typically "mm")
     */
    private String showers;

    /**
     * Unit for snowfall (typically "cm")
     */
    private String snowfall;
}

package com.example.etl.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

/**
 * Contains unit definitions for all fields in the {@link Hourly} weather data class.
 * Provides metadata about measurement units used in the corresponding hourly weather observations.
 *
 * <p>This class typically accompanies {@link Hourly} data in API responses to specify
 * the units of measurement for each weather parameter.</p>
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class HourlyUnits {
    /**
     * Unit for time values (typically "unixtime" or "iso8601")
     */
    @JsonAlias("time")
    private String time;

    /**
     * Temperature unit (typically "°C" or "°F")
     */
    @JsonAlias("temperature_2m")
    private String temperatureTwoM;

    /**
     * Relative humidity unit (typically "%")
     */
    @JsonAlias("relative_humidity_2m")
    private String relativeHumidityTwoM;

    /**
     * Dew point temperature unit (typically "°C" or "°F")
     */
    @JsonAlias("dew_point_2m")
    private String dewPointTwoM;

    /**
     * Apparent temperature unit (typically "°C" or "°F")
     */
    @JsonAlias("apparent_temperature")
    private String apparentTemperature;

    /**
     * Temperature unit at 80m elevation (typically "°C" or "°F")
     */
    @JsonAlias("temperature_80m")
    private String temperatureEightyM;

    /**
     * Temperature unit at 120m elevation (typically "°C" or "°F")
     */
    @JsonAlias("temperature_120m")
    private String temperatureOneHundredAndTwentyM;

    /**
     * Wind speed unit at 10m (typically "km/h", "mph", or "m/s")
     */
    @JsonAlias("wind_speed_10m")
    private String windSpeedTenM;

    /**
     * Wind speed unit at 80m (typically "km/h", "mph", or "m/s")
     */
    @JsonAlias("wind_speed_80m")
    private String windSpeedEightyM;

    /**
     * Wind direction unit (typically "degrees" or "°")
     */
    @JsonAlias("wind_direction_10m")
    private String windDirectionTenM;

    /**
     * Wind direction unit (typically "degrees" or "°")
     */
    @JsonAlias("wind_direction_80m")
    private String windDirectionEightyM;

    /**
     * Visibility unit (typically "km" or "miles")
     */
    @JsonAlias("visibility")
    private String visibility;

    /**
     * Evapotranspiration unit (typically "mm")
     */
    @JsonAlias("evapotranspiration")
    private String evapotranspiration;

    /**
     * Weather code unit (typically "wmo code")
     */
    @JsonAlias("weather_code")
    private String weatherCode;

    /**
     * Soil temperature unit at surface (typically "°C" or "°F")
     */
    @JsonAlias("soil_temperature_0cm")
    private String soilTemperatureZeroCm;

    /**
     * Soil temperature unit at 6cm depth (typically "°C" or "°F")
     */
    @JsonAlias("soil_temperature_6cm")
    private String soilTemperatureSixCm;

    /**
     * Rainfall unit (typically "mm" or "inch")
     */
    @JsonAlias("rain")
    private String rain;

    /**
     * Showers precipitation unit (typically "mm" or "inch")
     */
    @JsonAlias("showers")
    private String showers;

    /**
     * Snowfall unit (typically "cm" or "inch")
     */
    @JsonAlias("snowfall")
    private String snowfall;
}

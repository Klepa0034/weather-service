package com.etl.client;

import com.etl.dto.api.GeneralWeather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client for retrieving weather data from the Open-Meteo API.
 *
 * <p>Provides methods to fetch weather forecasts based on geographic coordinates and various parameters.</p>
 *
 * @see <a href="https://open-meteo.com/">Open-Meteo API Documentation</a>
 */
@FeignClient(
        name = "open-meteo",
        url = "https://api.open-meteo.com/v1")
public interface WeatherClient {

    /**
     * Retrieves weather forecast data for specified location and time range.
     *
     * @param latitude           Geographic latitude in decimal degrees (-90 to 90)
     * @param longitude          Geographic longitude in decimal degrees (-180 to 180)
     * @param daily              Array of daily weather variables to retrieve
     * @param hourly             Array of hourly weather variables to retrieve
     * @param timezone           Timezone for the returned data (e.g., "Europe/London")
     * @param timeformat         Format for time values (e.g., "iso8601")
     * @param wind_speed_unit    Unit for wind speed (e.g., "kmh", "ms", "mph", "kn")
     * @param temperature_unit   Temperature unit ("celsius" or "fahrenheit")
     * @param precipitation_unit Precipitation unit ("mm" or "inch")
     * @param startDate          Start date in YYYY-MM-DD format
     * @param endDate            End date in YYYY-MM-DD format
     * @return GeneralWeather object containing forecast data
     * @see GeneralWeather
     */
    @GetMapping("/forecast")
    GeneralWeather getWeather(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam String[] daily,
            @RequestParam String[] hourly,
            @RequestParam String timezone,
            @RequestParam String timeformat,
            @RequestParam String wind_speed_unit,
            @RequestParam String temperature_unit,
            @RequestParam String precipitation_unit,
            @RequestParam("start_date") String startDate,
            @RequestParam("end_date") String endDate
    );
}
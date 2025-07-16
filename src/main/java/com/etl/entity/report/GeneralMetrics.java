package com.etl.entity.report;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents comprehensive weather metrics containing various atmospheric and surface measurements.
 * Includes wind speeds, temperatures at different elevations, precipitation data, and daylight information.
 *
 * <p>This class is designed for Excel export with Russian-language column headers
 * and provides current weather observations with standardized units of measurement.</p>
 */
@Getter
@Setter
@NoArgsConstructor
public class GeneralMetrics {
    /**
     * Wind speed at 10 meters elevation in meters per second (м/с)
     */
    @ExcelProperty("Скорость ветра на высоте 10 метров (м/с)")
    private String windSpeedTenMMPerS;

    /**
     * Wind speed at 80 meters elevation in meters per second (м/с)
     * (relevant for wind energy applications)
     */
    @ExcelProperty("Скорость ветра на высоте 80 метров (м/с)")
    private String windSpeedEightyMMPerS;

    /**
     * Air temperature at 2 meters elevation in Celsius (°C)
     */
    @ExcelProperty("Температура на высоте 2 метров (°C)")
    private String temperatureTwoMCelsius;

    /**
     * Apparent (feels-like) temperature in Celsius (°C)
     * (accounts for wind chill/heat index effects)
     */
    @ExcelProperty("Кажущаяся температура (ощущаемая температура) (°C)")
    private String apparentTemperatureCelsius;

    /**
     * Air temperature at 80 meters elevation in Celsius (°C)
     * (relevant for wind energy applications)
     */
    @ExcelProperty("Температура на высоте 80 метров (°C)")
    private String temperatureEightyMCelsius;

    /**
     * Air temperature at 120 meters elevation in Celsius (°C)
     * (relevant for wind energy applications)
     */
    @ExcelProperty("Температура на высоте 120 метров (°C)")
    private String temperatureOneHundredAndTwentyMCelsius;

    /**
     * Soil temperature at surface level (0 cm depth) in Celsius (°C)
     */
    @ExcelProperty("Температура почвы на глубине 0 см (°C)")
    private String soilTemperatureZeroCmCelsius;

    /**
     * Soil temperature at 6 cm depth in Celsius (°C)
     */
    @ExcelProperty("Температура почвы на глубине 6 см (°C)")
    private String soilTemperatureSixCmCelsius;

    /**
     * Rainfall accumulation in millimeters (мм)
     */
    @ExcelProperty("Количество дождя (мм)")
    private String rainMm;

    /**
     * Showers precipitation accumulation in millimeters (мм)
     */
    @ExcelProperty("Количество ливней (мм)")
    private String showersMm;

    /**
     * Snowfall accumulation in millimeters (мм)
     */
    @ExcelProperty("Количество снегопада (мм)")
    private String snowfallMm;

    /**
     * Duration of daylight in hours
     */
    @ExcelProperty("Продолжительность светового дня (часы)")
    private String daylightHours;

    /**
     * Sunset time in ISO 8601 format
     */
    @ExcelProperty("Время заката (ISO 8601)")
    private String sunsetIso;

    /**
     * Sunrise time in ISO 8601 format
     */
    @ExcelProperty("Время восхода (ISO 8601)")
    private String sunriseIso;
}
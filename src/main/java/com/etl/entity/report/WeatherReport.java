package com.etl.entity.report;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Comprehensive weather report container class that aggregates all weather data components.
 *
 * <p>This class serves as the main container for different types of weather reports,
 * combining daily averages, daylight-specific measurements, and general metrics into
 * a single unified structure.</p>
 *
 * <p>Contains the following report types:
 * <ul>
 *   <li>{@link AvgDailyReport} - 24-hour average values</li>
 *   <li>{@link GeneralDailyReport} - Daily precipitation totals</li>
 *   <li>{@link AvgDaylightReport} - Daylight hour averages</li>
 *   <li>{@link GeneralDaylightReport} - Daylight precipitation totals</li>
 *   <li>{@link GeneralMetrics} - Current weather observations</li>
 * </ul>
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
public class WeatherReport {
    /**
     * 24-hour average air temperature at 2 meters elevation in Celsius
     */
    @ExcelProperty("Средняя температура на высоте 2 метров за 24 часа (в градусах Цельсия)")
    private String avgTemperatureTwoMTwentyFourH;

    /**
     * 24-hour average relative humidity at 2 meters elevation in percent
     */
    @ExcelProperty("Средняя относительная влажность на высоте 2 метров за 24 часа (в процентах)")
    private String avgRelativeHumidityTwoMTwentyFourH;

    /**
     * 24-hour average dew point temperature at 2 meters elevation in Celsius
     */
    @ExcelProperty("Средняя точка росы на высоте 2 метров за 24 часа (в градусах Цельсия)")
    private String avgDewPointTwoMTwentyFourH;

    /**
     * 24-hour average apparent (feels-like) temperature in Celsius
     */
    @ExcelProperty("Средняя кажущаяся температура (ощущаемая температура) за 24 часа (в градусах Цельсия)")
    private String avgApparentTemperatureTwentyFourH;

    /**
     * 24-hour average air temperature at 80 meters elevation in Celsius
     * (typically relevant for wind energy applications)
     */
    @ExcelProperty("Средняя температура на высоте 80 метров за 24 часа (в градусах Цельсия)")
    private String avgTemperatureEightyMTwentyFourH;

    /**
     * 24-hour average air temperature at 120 meters elevation in Celsius
     * (typically relevant for wind energy applications)
     */
    @ExcelProperty("Средняя температура на высоте 120 метров за 24 часа (в градусах Цельсия)")
    private String avgTemperatureOneHundredAndTwentyMTwentyFourH;

    /**
     * 24-hour average wind speed at 10 meters elevation in meters per second
     */
    @ExcelProperty("Средняя скорость ветра на высоте 10 метров за 24 часа (в метрах в секунду)")
    private String avgWindSpeedTenMTwentyFourH;

    /**
     * 24-hour average wind speed at 80 meters elevation in meters per second
     * (typically relevant for wind energy applications)
     */
    @ExcelProperty("Средняя скорость ветра на высоте 80 метров за 24 часа (в метрах в секунду)")
    private String avgWindSpeedEightyMTwentyFourH;

    /**
     * 24-hour average horizontal visibility in meters
     */
    @ExcelProperty("Средняя видимость за 24 часа (в метрах)")
    private String avgVisibilityTwentyFourH;
    /**
     * Total rainfall accumulation over 24 hours in millimeters
     */
    @ExcelProperty("Общее количество дождя за 24 часа (в миллиметрах)")
    private String totalRainTwentyFourH;

    /**
     * Total shower precipitation accumulation over 24 hours in millimeters
     */
    @ExcelProperty("Общее количество ливней за 24 часа (в миллиметрах)")
    private String totalShowersTwentyFourH;

    /**
     * Total snowfall accumulation over 24 hours in millimeters
     */
    @ExcelProperty("Общее количество снегопада за 24 часа (в миллиметрах)")
    private String totalSnowfallTwentyFourH;
    /**
     * Average air temperature at 2 meters elevation during daylight hours (°C)
     */
    @ExcelProperty("Средняя температура на высоте 2 м (°C)")
    private String avgTemperatureTwoMDaylight;

    /**
     * Average relative humidity at 2 meters elevation during daylight hours (%)
     */
    @ExcelProperty("Средняя относительная влажность на высоте 2 м (%)")
    private String avgRelativeHumidityTwoMDaylight;

    /**
     * Average dew point temperature at 2 meters elevation during daylight hours (°C)
     */
    @ExcelProperty("Средняя точка росы на высоте 2 м (°C)")
    private String avgDewPointTwoMDaylight;

    /**
     * Average apparent (feels-like) temperature during daylight hours (°C)
     */
    @ExcelProperty("Средняя ощущаемая температура (°C)")
    private String avgApparentTemperatureDaylight;

    /**
     * Average air temperature at 80 meters elevation during daylight hours (°C)
     * (relevant for wind energy applications)
     */
    @ExcelProperty("Средняя температура на высоте 80 м (°C)")
    private String avgTemperatureEightyMDaylight;

    /**
     * Average air temperature at 120 meters elevation during daylight hours (°C)
     * (relevant for wind energy applications)
     */
    @ExcelProperty("Средняя температура на высоте 120 м (°C)")
    private String avgTemperatureOneHundredAndTwentyMDaylight;

    /**
     * Average wind speed at 10 meters elevation during daylight hours (m/s)
     */
    @ExcelProperty("Средняя скорость ветра на высоте 10 м (м/с)")
    private String avgWindSpeedTenMDaylight;

    /**
     * Average wind speed at 80 meters elevation during daylight hours (m/s)
     * (relevant for wind energy applications)
     */
    @ExcelProperty("Средняя скорость ветра на высоте 80 м (м/с)")
    private String avgWindSpeedEightyMDaylight;

    /**
     * Average horizontal visibility during daylight hours (meters)
     */
    @ExcelProperty("Средняя видимость (м)")
    private String avgVisibilityDaylight;
    /**
     * Total rainfall accumulation during daylight hours in millimeters (mm)
     */
    @ExcelProperty("Общее количество дождя (мм)")
    private String totalRainDaylight;

    /**
     * Total shower precipitation accumulation during daylight hours in millimeters (mm)
     */
    @ExcelProperty("Общее количество ливней (мм)")
    private String totalShowersDaylight;

    /**
     * Total snowfall accumulation during daylight hours in millimeters (mm)
     */
    @ExcelProperty("Общее количество снегопада (мм)")
    private String totalSnowfallDaylight;
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
package com.etl.entity.report;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a daily aggregated weather report containing 24-hour average values
 * for various meteorological parameters at different elevations.
 *
 * <p>This class is designed for Excel export with human-readable column headers
 * describing each weather measurement in detail. All values represent daily averages.</p>
 */
@Getter
@Setter
@NoArgsConstructor
public class AvgDailyReport {
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
}
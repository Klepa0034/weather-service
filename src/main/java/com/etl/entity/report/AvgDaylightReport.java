package com.etl.entity.report;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a report of average weather conditions during daylight hours.
 * Contains aggregated meteorological data for various parameters at different elevations.
 *
 * <p>This class is designed for Excel export with concise yet descriptive column headers
 * in Russian language. All values represent averages calculated specifically for daylight periods.</p>
 */
@Getter
@Setter
@NoArgsConstructor
public class AvgDaylightReport {
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
}
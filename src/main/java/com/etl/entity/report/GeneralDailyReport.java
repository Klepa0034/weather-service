package com.etl.entity.report;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a daily precipitation report containing 24-hour cumulative totals
 * for different types of precipitation measurements.
 *
 * <p>This class is designed for Excel export with Russian-language column headers
 * and provides aggregated precipitation data over a 24-hour period.</p>
 */
@Getter
@Setter
@NoArgsConstructor
public class GeneralDailyReport {
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
}
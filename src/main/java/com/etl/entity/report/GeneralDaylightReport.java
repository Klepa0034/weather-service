package com.etl.entity.report;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a daylight precipitation report containing cumulative totals
 * for different types of precipitation during daylight hours.
 *
 * <p>This class is designed for Excel export with concise Russian-language column headers
 * and provides aggregated precipitation data specifically for daylight periods.</p>
 *
 * <p>All measurements represent the total accumulation during daylight hours only.</p>
 */
@Getter
@Setter
@NoArgsConstructor
public class GeneralDaylightReport {
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
}

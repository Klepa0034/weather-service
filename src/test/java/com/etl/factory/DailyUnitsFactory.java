package com.etl.factory;

import com.etl.dto.DailyUnits;
import org.springframework.stereotype.Component;

@Component
public class DailyUnitsFactory {
    public DailyUnits create() {
        return new DailyUnits(
                "unixtime",
                "unixtime",
                "unixtime",
                "s"
        );
    }
}
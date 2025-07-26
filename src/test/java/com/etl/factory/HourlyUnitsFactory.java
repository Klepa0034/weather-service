package com.etl.factory;

import com.etl.dto.api.HourlyUnits;
import org.springframework.stereotype.Component;

@Component
public class HourlyUnitsFactory {
    public HourlyUnits create() {
        return new HourlyUnits(
                "unixtime",
                "°F",
                "%",
                "°F",
                "°F",
                "°F",
                "°F",
                "kn",
                "kn",
                "°",
                "°",
                "ft",
                "inch",
                "wmo code",
                "°F",
                "°F",
                "inch",
                "inch",
                "inch"
        );
    }
}

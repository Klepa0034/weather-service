package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DailyUnits {
    @JsonAlias("time")
    private String time;
    @JsonAlias("sunrise")
    private String sunrise;
    @JsonAlias("sunset")
    private String sunset;
    @JsonAlias("daylight_duration")
    private String daylightDuration;
}

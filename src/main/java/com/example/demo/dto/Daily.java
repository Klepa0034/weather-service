package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Daily {
    @JsonAlias("time")
    private long[] time;
    @JsonAlias("sunrise")
    private long[] sunrise;
    @JsonProperty("sunset")
    private long[] sunset;
    @JsonProperty("daylight_duration")
    private double[] daylightDuration;
}

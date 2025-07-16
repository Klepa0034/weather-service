package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.TimeZone;

@Getter
@Setter
@NoArgsConstructor
public class GeneralInformation {
    @JsonAlias("latitude")
    private double latitude;
    @JsonAlias("longitude")
    private double longitude;
    @JsonAlias("generationtime_ms")
    private double generationTimeMs;
    @JsonAlias("utc_offset_seconds")
    private long utcOffsetSeconds;
    @JsonAlias("timezone")
    private TimeZone timeZone;
    @JsonAlias("timezone_abbreviation")
    private TimeZone timezoneAbbreviation;
    @JsonAlias("elevation")
    private double elevation;


    public String toString() {
        return "GeneralInformation(latitude=" + this.getLatitude() + ", longitude=" + this.getLongitude() + ", generationTimeMs=" + this.getGenerationTimeMs() + ", utcOffsetSeconds=" + this.getUtcOffsetSeconds() + ", timeZone=" + this.getTimeZone() + ", timezoneAbbreviation=" + this.getTimezoneAbbreviation() + ", elevation=" + this.getElevation() + ")";
    }
}
